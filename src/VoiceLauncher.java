
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class VoiceLauncher {
    public static void main(String[] args) throws IOException {
        Configuration configuration = new Configuration();
         configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
         configuration.setDictionaryPath("4717.dic");
         configuration.setLanguageModelPath("4717.lm");
         
         LiveSpeechRecognizer recognize= new LiveSpeechRecognizer(configuration);
         recognize.startRecognition(true);
         
         SpeechResult result;
         while ((result=recognize.getResult()) != null) {            
            String command=result.getHypothesis();
            String work=null;
            Process p;
            
             if (command.equalsIgnoreCase("Monday")) {
                 System.out.println("1");
                 
                
              //   ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "myfile.txt");
                // pb.start();
             }else if (command.equalsIgnoreCase("Tuesday")) {
                 System.out.println("2");
                
             }
             else if (command.equalsIgnoreCase("Wednesday")) {
                 System.out.println("3");
                 
             }
             else if (command.equalsIgnoreCase("Thursday")) {
                 System.out.println("4");
                 
             }
             
            /* if(work != null){
                 p=Runtime.getRuntime().exec(work);
             }
             work=null; */
        }
    }
}
