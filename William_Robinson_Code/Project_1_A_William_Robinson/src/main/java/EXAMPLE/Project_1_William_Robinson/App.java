package EXAMPLE.Project_1_William_Robinson;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import java.io.*;
import java.sql.SQLException;
import java.util.*;
import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;
import javax.activation.*;  


class SendMailSSL 
{
	
    public static void send(String from,String password,String to,String sub,String msg){  
        //Get properties object    
        Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class",    
                  "javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", "465");    
        //get Session   
        Session session = Session.getDefaultInstance(props,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication(from,password);  
         }    
        });    
        //compose message    
        try {    
         MimeMessage message = new MimeMessage(session);    
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
         message.setSubject(sub);    
         message.setText(msg);    
         //send message  
         Transport.send(message);    
         System.out.println("message sent successfully");    
        } catch (MessagingException e) {e.printStackTrace();}    
           
  }  
}  
public class App{    
public static void main(String[] args) {    
   //from,password,to,subject,message  
	SendMailSSL.send("william.robinson.2018@gmail.com","","billrob2954@ameritech.net","hello javatpoint","How r u?");  
   //change from, password and to  
}    
		 } 
	
	
	   /* Get actual class name to be printed on */

	 //  public static void main(String[] args){
	     
	   
	
/*	static Logger log = Logger.getLogger(App.class.getName());
	
    public static void main( String[] args ) throws IOException,SQLException
    {
 	   
 	   log.debug("Hello this is a debug message");
 	      log.info("Hello this is an info message");
    	
        System.out.println( "Hello World!" );
    }*/

