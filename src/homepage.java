/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import com.sun.speech.freetts.*;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javazoom.jl.player.Player;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 *
 * @author Admin
 */
public class homepage extends javax.swing.JFrame {

    /**
     * Creates new form homepage
     */
    int option=0;
     Configuration configuration;
     LiveSpeechRecognizer recognize;
     int i=0,x=0,count=0;
     recog my=new recog();
     public static final String VOICENAME="kevin16";
    public homepage() throws IOException {
        initComponents();
        configuration = new Configuration();
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
         configuration.setDictionaryPath("4717.dic");
         configuration.setLanguageModelPath("4717.lm");
         recognize= new LiveSpeechRecognizer(configuration);
         recognize.startRecognition(true);
    }

     
    class ivr extends Thread{
        public void run(){
            String go="",pl="";
        int count=0;
        Voice voice;
        VoiceManager vm= VoiceManager.getInstance();
        voice= vm.getVoice(VOICENAME);
        
        voice.allocate();
        FileReader reader = null;
            try {
                reader = new FileReader("ivrstart.txt");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
        int character;
 
            try {
                while ((character = reader.read()) != -1) {
                    go=go+(char) character;
                }
            } catch (IOException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        recogstart();
        }
        
    }
    
    public void ivrstart(){
        ivr mm=new ivr();
        mm.start();
    }
    
    class recog extends Thread{
        public void run(){
            
         int x=0;
         SpeechResult result;
         while ((result=recognize.getResult()) != null) {            
            String command=result.getHypothesis();
            
            
             if (command.equalsIgnoreCase("Monday")) {
                 option=1;
                
                try {
                    recogstop();
                } catch (IOException ex) {
                    Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
                }
                 break;
            //    break;
              //   ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "myfile.txt");
                // pb.start();
                 }else if (command.equalsIgnoreCase("Tuesday")) {
                 option=2;
                 
                try {
                     try {
                         recogstop();
                     } catch (InterruptedException ex) {
                         Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
                     }
                } catch (IOException ex) {
                    Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                 break;
                
             }else if(command.equalsIgnoreCase("Wednesday")){
                 option=3;
                try {
                    recogstop();
                } catch (IOException ex) {
                    Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
                }
                 break;
             }else if(command.equalsIgnoreCase("Thursday")){
                 option=4;
                try {
                    recogstop();
                } catch (IOException ex) {
                    Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
                }
                 break;
             }else if(command.equalsIgnoreCase("Friday")){
                 option=5;
                try {
                    recogstop();
                } catch (IOException ex) {
                    Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
                }
                 break;
             }
             
                
             
            
        }
         
        }
    }
    
    public void recogstart(){
        recog my=new recog();
        my.start();
    }
    public void recogstop() throws IOException, InterruptedException{
        Voice voice;
        VoiceManager vm= VoiceManager.getInstance();
        voice= vm.getVoice(VOICENAME);
        
        voice.allocate();
        if(option==1){
            jTextField1.setText("Audio Player");
            voice.speak("Starting Audio Player");
            one();
        }else if(option==2){
            
            jTextField1.setText("LIST OF LATEST MOVIES");
            voice.speak("Latest Movies are as follows :- ");
            movies();
            
        }else if(option==3){
           jTextField1.setText("News Headlines");
            voice.speak("News Headlines");
            news();
        }else if(option==4){
           jTextField1.setText("Latest Updates on Technology");
            voice.speak("Latest Updates on Technology");
            tech();
        }else if(option==5){
           jTextField1.setText("Going To Main Menu");
            voice.speak("Going To Main Menu");
            ivrstart();
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("WELCOME");
        jTextField1.setEnabled(false);
        jTextField1.setOpaque(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1421404594_801955_1421404773_noticia_normal.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ivrstart();
      //  recogstart();
        
    }//GEN-LAST:event_formWindowOpened

    
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
     
     
     
     public void one() throws IOException, InterruptedException{
        Voice voice;
                VoiceManager vm= VoiceManager.getInstance();
                voice= vm.getVoice(VOICENAME);
        
                voice.allocate();
        String[] cool=new String[]{"Beep.mp3","Hornblow.mp3","Naah.mp3","Soch.mp3","Yaar.mp3"};
        for (int i = 0; i < 5; i++) {
            NewClass3.Mp3Player mp= new NewClass3.Mp3Player(cool[i]);
            mp.play();
            start();
            int m=check();
            if(m==2){   
                break;
            }
        }
        voice.speak("THANK YOU");
        ivrstart();
       
        
        
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
     
     
     public int check() throws IOException, InterruptedException{
         int x=0;
         SpeechResult result;
         while ((result=recognize.getResult()) != null) {            
            String command=result.getHypothesis();
            
            
             if (command.equalsIgnoreCase("Monday")) {
                 x=1;
                 
                break;
              //   ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "myfile.txt");
                // pb.start();
             }else if (command.equalsIgnoreCase("Tuesday")) {
                 x=2;
                 
                 break;
                
             }else if (command.equalsIgnoreCase("Wednesday")) {
                 x=3;
                 
                 break;
                
             }
             
             
            
        }
         return x;
        }
     
     public void moviesplaylist() throws FileNotFoundException, IOException, InterruptedException{
         String go="",pl="";
        int count=0;
        Voice voice;
        VoiceManager vm= VoiceManager.getInstance();
        voice= vm.getVoice(VOICENAME);
        
        voice.allocate();
        FileReader reader=new FileReader("movieplay.txt");
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
        
        int x=check();
        if(x==1){
            movies();
        }else if(x==2){
            voice.speak("THANK YOU");
            ivrstart();
        }else if(x==3){
            moviesplaylist();
        }
     }
     
     public void movies() throws FileNotFoundException, InterruptedException{
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
                    Voice voice;
                    VoiceManager vm= VoiceManager.getInstance();
                    voice= vm.getVoice(VOICENAME);
                    voice.allocate();
                    voice.speak(ff);
                    ff="";
                    count=0;
                    temp1="";
                } 
                
            } 
            
            
           moviesplaylist();
        } catch (IOException ex) {
            Logger.getLogger(web.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void tech() throws IOException, FileNotFoundException{
         try {
            String s = "",temp1="",temp2="";
            int count=0;
            Document doc=Jsoup.connect("https://www.cnet.com/news/").userAgent("Mozilla/17.0").get();
            Elements temp=doc.select("div#rbContent");
            int i=0;
            
            for(Element listmm:temp)
            {
                i++;
                s=listmm.getElementsByTag("a").text();
               // temp1=listmm.getElementsByTag("p").text();
             //   jTextArea1.setText(s);
                //jTextArea1.append(temp1);
            }
            
            for (int j = 0; j < s.length(); j++) {
                temp1=temp1+s.charAt(j);
                if(s.charAt(j)==' '){
                    temp2=temp2+temp1;
                    if("ago ".equals(temp1)){
                        Voice voice;
                        VoiceManager vm= VoiceManager.getInstance();
                        voice= vm.getVoice(VOICENAME);
                        voice.allocate();
                        voice.speak(temp2);
                        temp2="";
                    }
                    temp1="";
                }
            }
                
         techback();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
         
        
     }
     
     public void techback() throws FileNotFoundException, IOException, InterruptedException{
         String go="",pl="";
        int count=0;
        Voice voice;
        VoiceManager vm= VoiceManager.getInstance();
        voice= vm.getVoice(VOICENAME);
        
        voice.allocate();
        FileReader reader=new FileReader("movieplay.txt");
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
        
        int x=check();
        if(x==1){
            tech();
        }else if(x==2){
            voice.speak("THANK YOU");
            ivrstart();
        }else if(x==3){
            techback();
        }
     }
     
     public void news(){
         try {
            String s = null,temp1="";
            int count=0;
            Document doc=Jsoup.connect("http://www.rediff.com/headline.html").userAgent("Mozilla/17.0").get();
            Elements temp=doc.select("div#hdtab1");
            int i=0;
            Voice voice;
                VoiceManager vm= VoiceManager.getInstance();
                voice= vm.getVoice(VOICENAME);
        
                voice.allocate();
            for(Element listmm:temp)
            {
                i++;
                s=listmm.getElementsByTag("a").text();
               // jTextArea1.setText(s);
            }
            voice.speak(s);
            
                
          /*  for (int j = 0; j < s.length(); j++) {
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
           // System.out.println(temp1); */
            newsback();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
     }
     
     public void newsback() throws FileNotFoundException, IOException, InterruptedException{
          String go="",pl="";
        int count=0;
        Voice voice;
        VoiceManager vm= VoiceManager.getInstance();
        voice= vm.getVoice(VOICENAME);
        
        voice.allocate();
        FileReader reader=new FileReader("movieplay.txt");
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
        
        int x=check();
        if(x==1){
            news();
        }else if(x==2){
            voice.speak("THANK YOU");
            ivrstart();
        }else if(x==3){
            newsback();
        }
     }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new homepage().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
