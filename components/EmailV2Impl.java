package brainathon.components;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import com.itextpdf.text.Document;  
import com.itextpdf.text.DocumentException;  
import com.itextpdf.text.Paragraph;  
import com.itextpdf.text.pdf.PdfWriter;  

public class EmailV2Impl extends UnicastRemoteObject implements EmailV2{


	private static final long serialVersionUID = 1L;
	public EmailV2Impl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
    public void sendEmail(String from, String to, String subject, String body) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.mailtrap.io");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication( "00300707a3ce27", "6536d1491ba68b" );
            }
        });

        try {
        	Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
			message.setSubject(subject);		    
		    BodyPart messageBodyPart1 = new MimeBodyPart();  
		    messageBodyPart1.setText(body);
		    MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
		    String pdfname=subject+"_"+to+".pdf";
		    Document doc = new Document();  
		    PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(pdfname));
			System.out.println("PDF created.");  
			doc.open();    
			doc.add(new Paragraph(body));     
			doc.close();  
			writer.close();  
		    String filename = pdfname;
		    DataSource source = new FileDataSource(filename);  
		    messageBodyPart2.setDataHandler(new DataHandler(source));  
		    messageBodyPart2.setFileName(filename);  
		    Multipart multipart = new MimeMultipart();  
		    multipart.addBodyPart(messageBodyPart1);  
		    multipart.addBodyPart(messageBodyPart2);  
		    message.setContent(multipart);  
		    Transport.send(message);
		    System.out.println("Email Message Sent Successfully");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
}
