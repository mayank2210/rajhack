
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
    
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class web {
    public static void main(String[] args) {
        try {
            String s = null,temp1="";
            int count=0;
            Document doc=Jsoup.connect("https://timesofindia.indiatimes.com/news").userAgent("Mozilla/17.0").get();
            Elements temp=doc.select("div#ulItemContainer");
            int i=0;
            for(Element listmm:temp)
            {
                i++;
                s=listmm.getElementsByTag("a").text();
                
            }
            
            for (int j = 0; j < s.length(); j++) {
                temp1=temp1+s.charAt(j);
                if (s.charAt(j)==' ') {
                    count++;
                }else{
                    count=0;
                }
                if(count==2){
                    System.out.println(temp1);
                    count=0;
                    temp1="";
                } 
                
            } 
           // System.out.println(temp1);
        } catch (IOException ex) {
            Logger.getLogger(web.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
