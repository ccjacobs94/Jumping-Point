/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package summarizer;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.CombinedResults;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author Christopher
 */
public class Communicater {
    
    public CombinedResults getInsightInString(String URL)
    {       
        AlchemyLanguage service = new AlchemyLanguage();
        service.setApiKey("ddde059aa171e004290d804451f836f11465e70b");
        
        
        
        Map<String,Object> params = new HashMap<>();
        
        params.put(AlchemyLanguage.HTML, URL);
        CombinedResults summary = service.getCombinedResults(params);
        
        return summary;
    }
    
    public CombinedResults getInsightInTextFile(String address)
    {
        String text = "";
        AlchemyLanguage service = new AlchemyLanguage();
        service.setApiKey("ddde059aa171e004290d804451f836f11465e70b");
        
        try{
            Scanner in = new Scanner(new FileInputStream(address));
            while(in.hasNextLine()){
                text+=in.nextLine();
            }
        }
        catch(Exception e)
        {
            System.out.println("FILE NOT FOUND");
            System.exit(0);
        }
        
        Map<String,Object> params = new HashMap<String, Object>();
       
        params.put(AlchemyLanguage.HTML, text);
        
        CombinedResults summary = service.getCombinedResults(params);
        
        return summary;
    }
    
    public CombinedResults getInsightInPDF(String address)
    {
        String text = "";
        
        try {
            PDFManager pdfManager = new PDFManager();
            pdfManager.setFilePath(address);
            text = pdfManager.ToText();
        } catch (IOException ex) {
            Logger.getLogger(Communicater.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return getInsightInString(text);
    }
}