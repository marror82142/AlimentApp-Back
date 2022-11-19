package alimentApp.models.services;

import javax.mail.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class EmailSenderService {
	
	public static void sendEmail(String para, String asunto, String mensaje) {
		Properties props = new Properties();
	    props.put( "mail.smtp.host" , "smtp.office365.com");
	    props.put( "mail.smtp.user" , "marror7@hotmail.com" );
	    // Use TLS
	    props.put("mail.smtp.auth" , "true" );
	    props.put( "mail.smtp.starttls.enable" , "true" );
	    props.put( "mail.smtp.password" , "mLemou2022*" );
	    props.put("mail.smtp.port", "587");
	    
		Session session = Session.getInstance(props, new Authenticator() {
		    @Override
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication("alimentapp@outlook.es", "Proyectoint2022");
		    }
		});
		String de = "alimentapp@outlook.es";
	    MimeMessage message = new MimeMessage(session);
	    MimeBodyPart messagePart = new MimeBodyPart();

	    try {
	        message.setRecipients( Message.RecipientType.TO, InternetAddress.parse( para ) );
	        message.setFrom( new InternetAddress(de) );
	        message.setSubject(asunto);
	        message.setText( mensaje );
	        messagePart.setText( mensaje );
	        Multipart hotmailMP = new MimeMultipart();
	        hotmailMP.addBodyPart( messagePart );
	        message.setContent( hotmailMP );
	        Transport transport = session.getTransport("smtp");
	        transport.send(message);     
	    }  catch(Exception exc) {
	        System.out.println(exc);
	    }
		
	}
}
