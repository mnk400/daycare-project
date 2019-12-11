package edu.neu.csye6200;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.net.ssl.SSLSession;
import javax.activation.*;
import javax.mail.Transport.*;

public class Mailer {
	
	String host;
	String to;
	Properties props;
	Session session;
	int f;
	String subject;
	String recpName;
	String studName;
	String dose;
	String vaccine;
	String password = "ag196666";
	String from = "daycareCSYE6200@gmail.com";
	
	
	public Mailer(String to) {
		this.to = to;
		this.host = "smtp.gmail.com";
		props = System.getProperties();
		props.setProperty("mail.smtp.host", host);
		props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", host);
	    props.put("mail.smtp.user", from);
	    props.put("mail.smtp.password", password);
	    props.put("mail.smtp.port", "587");
	    props.put("mail.smtp.auth", "true");
		this.session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });
		
	}
	
	
	
	public String getDose() {
		return dose;
	}



	public void setDose(String dose) {
		this.dose = dose;
	}



	public String getVaccine() {
		return vaccine;
	}



	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}



	public String getStudName() {
		return studName;
	}



	public void setStudName(String studName) {
		this.studName = studName;
	}
	
	public String getRecpName() {
		return recpName;
	}



	public void setRecpName(String recpName) {
		this.recpName = recpName;
	}



	public void sendImmunizationNotificationMail() {
		try {
			System.out.println("sending mail");
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Reminder: Your ward is due for their vaccine");
			message.setText("Dear " + this.getRecpName() + "\n" + "Your ward" + this.getStudName() + " is due for their " + this.getDose() + "th dose of the " + this.getVaccine() + " vaccination" + "\n" + "Sincerely," + "\n" + "Daycare - CSY6200");

			Transport transport = this.session.getTransport("smtp");
			transport.connect(host, 587, from,  password);
			transport.sendMessage(message, message.getAllRecipients());
//			transport.close();
			
		} catch (MessagingException mex) {
			mex.printStackTrace();
		} 
	}
	
	public void sendImmunizationWarning() {
		try {
			System.out.println("sending mail");
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Warning: Your ward is overdue for their vaccine");
			message.setText("Dear " + this.getRecpName() + "\n" + "Your ward " + this.getStudName() + " is overdue for their " + this.getDose() + "th dose of the " + this.getVaccine() + " vaccination" + "\n" + "Sincerely," + "\n" + "Daycare - CSY6200");
			Transport transport = this.session.getTransport("smtp");
			transport.connect(host, 587, from,  password);
			transport.sendMessage(message, message.getAllRecipients());
			//Transport.send(message);
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
