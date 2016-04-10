/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package summarizer;

import com.ibm.watson.developer_cloud.alchemy.v1.model.CombinedResults;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Concept;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Keyword;
import java.util.List;

/**
 *
 * @author Christopher
 */
public class Author {
    
    public String summarize(CombinedResults results)
    {
        String out = "";
        List<Concept> concepts = results.getConcepts();
                
        out += "\nConcepts:\n\n";
        for(Concept e: concepts)
        {
            if(e.getRelevance()> .350)
                out += (e.getText() + ": " + e.getDbpedia() + "\n\n");
        }
        
        out += "\n\nKey Terms:\n\n";
        for(Keyword k :results.getKeywords())
        {
            if(k.getRelevance() > .75)
                out += (k.getText() + ": " + "\n\n");
        }
        
        
        return out;
    }
}