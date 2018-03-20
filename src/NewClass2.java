
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
public class NewClass2 {
    public static void main(String[] args) {
        try {
            String s ="",temp1="",sm="",ff="";
            int count=0;
            Document doc=Jsoup.connect("http://www.imdb.com/movies-in-theaters/?ref_=nv_mv_inth_1").userAgent("Mozilla/17.0").get();
            Elements temp=doc.select("div#main");
            int i=0;
            for(Element listmm:temp)
            {
                i++;
                s=listmm.getElementsByTag("a").text();  
            }
            
            for (int j = 45; j < s.length(); j++) {
                temp1=temp1+s.charAt(j);
                if (s.charAt(j)==' ') {
                    count++;
                }else{
                    count=0;
                }
                if(count==2){
                    for (int k = 0; k < temp1.length(); k++) {
                        
                        if(temp1.charAt(k)=='('){
                            break;
                        }else{
                            ff=ff+temp1.charAt(k);
                        }
                    }
                    System.out.println(ff);
                    ff="";
                    count=0;
                    temp1="";
                } 
                
            } 
            
            
           
        } catch (IOException ex) {
            Logger.getLogger(web.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
