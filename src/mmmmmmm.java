
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
public class mmmmmmm {
    public static void main(String[] args) {
        try {
            String s ="",temp1="",sm="";
            int count=0;
            Document doc=Jsoup.connect("http://www.imdb.com/title/tt2557478/?ref_=inth_ov_tt").userAgent("Mozilla/17.0").get();
            Elements temp=doc.select("div.summary_text");
            String bol=temp.text();
            System.out.println(bol);
            Elements temp11=doc.select("div.credit_summary_item");
            System.out.println(temp11.text());
            
            
           // System.out.println(temp1);
        } catch (IOException ex) {
            Logger.getLogger(web.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
