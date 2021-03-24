
package Pharmacy;

import java.util.Properties;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email_sender {
    
    static String to;
    static String mesage;
    public static void get_sum(String t, String m)
    {

        mesage=m;
        to=t;
        TO = to;
        TEXT = mesage;
    }
 
    private static String HOST = "smtp.gmail.com";
    private static String USER  = "jathu.js1@gmail.com";
    private static String PASSWORD = "jathushan123";
    private static String PORT = "465";
    private static String FROM = "jathu.js1@gmail.com";
    private static String TO;// = from;
 
    private static String STARTTLS = "true";
    private static String AUTH = "true";
    private static String DEBUG = "true";
    private static String SOCKET_FACTORY = "javax.net.ssl.SSLSocketFactory";
    private static String SUBJECT = "Purcasing Order From Yarl Hospitial";
    private static String TEXT;// = mesage;

    public static synchronized void send() {
    
        Properties props = new Properties();
 
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.user", USER);
 
        props.put("mail.smtp.auth", AUTH);
        props.put("mail.smtp.starttls.enable", STARTTLS);
        props.put("mail.smtp.debug", DEBUG);
 
        props.put("mail.smtp.socketFactory.port", PORT);
        props.put("mail.smtp.socketFactory.class", SOCKET_FACTORY);
        props.put("mail.smtp.socketFactory.fallback", "false");
 
        try {
 

            Session session = Session.getDefaultInstance(props, null);
            session.setDebug(true);
 
        
            MimeMessage message = new MimeMessage(session);
            message.setText(TEXT);
            message.setSubject(SUBJECT);
            message.setFrom(new InternetAddress(FROM));
            message.addRecipient(RecipientType.TO, new InternetAddress(TO));
            message.saveChanges();
 
      
            Transport transport = session.getTransport("smtp");
            transport.connect(HOST, USER, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
