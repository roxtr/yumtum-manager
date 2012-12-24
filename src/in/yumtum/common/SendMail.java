package in.yumtum.common;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.simpleemail.AWSJavaMailTransport;

public class SendMail {

	private String from;
	private String to;
	private String subject;
	private String text;
	
	static Logger log = Logger.getLogger(SendMail.class);
	
	public SendMail(String from, String to, String subject, String text){
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.text = text;
	}
	
	public void send(){
		AWSCredentials credentials = new AWSCredentials() {
			
			@Override
			public String getAWSSecretKey() {
				// TODO Auto-generated method stub
				return "fx9NQvN1cV2OJig+RU+XB8t/+Ev9+mrQEoZiHbi4";
			}
			
			@Override
			public String getAWSAccessKeyId() {
				// TODO Auto-generated method stub
				return "AKIAI66O6LRTVJBTPZCA";
			}
		};
		
       // AmazonSimpleEmailService ses = new AmazonSimpleEmailServiceClient(credentials);
        

		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "aws");

        props.setProperty("mail.aws.user", credentials.getAWSAccessKeyId());
        props.setProperty("mail.aws.password", credentials.getAWSSecretKey());

        
        Session session = Session.getInstance(props);

        try {
            // Create a new Message
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setSubject(subject);
            msg.setContent(text,"text/html");
            msg.saveChanges();

            // Reuse one Transport object for sending all your messages
            // for better performance
            Transport t = new AWSJavaMailTransport(session, null);
            t.connect();
            t.sendMessage(msg, null);

            // Close your transport when you're completely done sending
            // all your messages
            t.close();
        } catch (AddressException e) {
            e.printStackTrace();
            System.out.println("Caught an AddressException, which means one or more of your "
                    + "addresses are improperly formatted.");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Caught a MessagingException, which means that there was a "
                    + "problem sending your message to Amazon's E-mail Service check the "
                    + "stack trace for more information.");
        }
        
        /*        
		
		Message simpleMessage = new MimeMessage(getSession());
		
		InternetAddress fromAddress = null;
		InternetAddress toAddress = null;
		try {
			fromAddress = new InternetAddress(from);
			toAddress = new InternetAddress(to);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			simpleMessage.setFrom(fromAddress);
			simpleMessage.setRecipient(RecipientType.TO, toAddress);
			simpleMessage.setSubject(subject);
			simpleMessage.setContent(text,"text/html");
			
			Transport.send(simpleMessage);			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
*/	}
	
/*	private Session getSession() {
		Authenticator authenticator = new Authenticator();

		Properties properties = new Properties();
		properties.setProperty("mail.smtp.submitter", authenticator.getPasswordAuthentication().getUserName());
		properties.setProperty("mail.smtp.auth", "true");

		properties.setProperty("mail.smtp.host", "smtp.yumtum.in");
		properties.setProperty("mail.smtp.port", "25");

		return Session.getInstance(properties, authenticator);
	}*/
	
/*	private class Authenticator extends javax.mail.Authenticator {
		private PasswordAuthentication authentication;

		public Authenticator() {
			String username = "hello@yumtum.in";
			String password = "ujjwala@TCS1";
			authentication = new PasswordAuthentication(username, password);
		}

		protected PasswordAuthentication getPasswordAuthentication() {
			return authentication;
		}
	}
	*/
	public static void main(String[] args) {
		
		 //BasicConfigurator.configure();

	     //log.setLevel(Level.DEBUG); // optional if log4j.properties file not used
	     // Possible levels: TRACE, DEBUG, INFO, WARN, ERROR, and FATAL
		String urefId="1234";
		String from = "hello@yumtum.in";
		String to = "makamhareesh@gmail.com";
		String subject = "Thanks for signing Up";
		String message = "<div>Hi "+to+", <p>Thanks for coming back. We will contact you shortly with a beta invite.</p><p>In the meantime, you can follow us on <span><a href='www.twitter.com/yumtumindia'>Twitter</a></span>  or on <span><a href='www.facebook.com/yumtumindia'>Facebook</a></span> to get the inside scoop .</p></div>" +
				"<p>Go ahead and share the URL ( http://www.yumtum.in/?refId="+urefId+" )with your friends and spread the joy.</p><p>\n \n \n \n - Team Yumtum</p>";

		SendMail sendMail = new SendMail(from, to, subject, message);
		sendMail.send();
	}
	
	
}
