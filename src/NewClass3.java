

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javazoom.jl.player.Player;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class NewClass3 {
    
    public static final String VOICENAME="kevin16";  
        
        public static int check() throws IOException{
            
         Configuration configuration = new Configuration();
         configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
         configuration.setDictionaryPath("2248.dic");
         configuration.setLanguageModelPath("2248.lm");
         
         LiveSpeechRecognizer recognize= new LiveSpeechRecognizer(configuration);
         recognize.startRecognition(true);
         int x=0;
         SpeechResult result;
         while ((result=recognize.getResult()) != null) {            
            String command=result.getHypothesis();
            
            
             if (command.equalsIgnoreCase("A")) {
                 x=1;
                 
                break;
              //   ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "myfile.txt");
                // pb.start();
             }else if (command.equalsIgnoreCase("B")) {
                 x=2;
                 break;
                
             }
             
             
            
        }
         recognize.stopRecognition();
         return x;
        }
    
        public static void start() throws FileNotFoundException, IOException{
        String go="",pl="";
        int count=0;
        Voice voice;
        VoiceManager vm= VoiceManager.getInstance();
        voice= vm.getVoice(VOICENAME);
        
        voice.allocate();
        FileReader reader=new FileReader("letsgo.txt");
        int character;
 
            while ((character = reader.read()) != -1) {
                go=go+(char) character;
            }
            reader.close();
        int i=0;
        for (int j = 0; j < go.length(); j++) {
            if(go.charAt(j)=='.'){
                count++;
            }
        }
        for (int j = 0; j < count; j++) {
            
        
            for (; i < go.length(); i++) {

                pl=pl+go.charAt(i);
                if(go.charAt(i)=='.'){
                    i++;
                    break;
                }
            }
            
            try {
                voice.speak(pl);
                Thread.sleep(500);
            } catch (Exception e) {
            }
            pl="";
        }
        
        
    }
    
    public static class Mp3Player {
    
    private String filename;
    private Player player; 
    
    
 
        public Mp3Player(String filename) { 
            this.filename = filename;
        }
        
        
        
        
        public void play() {
        try {   
            BufferedInputStream buffer = new BufferedInputStream(
            new FileInputStream(filename));
            player = new Player(buffer);
            player.play();
        }
        catch (Exception e) {
 
         System.out.println(e);
        }
 
    }
    
}
    public static void main(String[] args) throws IOException {
        
        Voice voice;
                VoiceManager vm= VoiceManager.getInstance();
                voice= vm.getVoice(VOICENAME);
        
                voice.allocate();
        String[] cool=new String[]{"beep.mp3","beep.mp3","Hornblow.mp3","Naah.mp3","Soch.mp3","Yaar.mp3"};
        for (int i = 0; i < 10; i++) {
            Mp3Player mp= new Mp3Player(cool[i]);
            mp.play();
            start();
            int m=check();
            if(m==2){
                
                
                break;
            }
        }
        voice.speak("THANK YOU");
        new Txttspe().setVisible(true);
        
    }
}
