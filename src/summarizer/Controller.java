/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package summarizer;

/**
 *
 * @author Christopher
 */
public class Controller {
    
    String path = "";
    public Controller(String filePath)
    {
        path = filePath;
    }
    
    public String analyzeTextDoc()
    {
        
        Author auth = new Author();
        Communicater comm = new Communicater();
        String type = path.substring(path.length() - 3);
        if(type.matches(".pdf"))
        {
            return auth.summarize(comm.getInsightInPDF(path));
        }
        else
        {
            return auth.summarize(comm.getInsightInTextFile(path));
        }
    }
}

