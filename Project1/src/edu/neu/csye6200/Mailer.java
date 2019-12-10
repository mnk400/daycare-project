package edu.neu.csye6200;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.net.ssl.SSLSession;
import javax.activation.*;

public class Mailer {
	
	String from;
	String host;
	String to;
	Properties properties;
	Session session;
	int f;
	String subject;
	String recpName;
	String studName;
	String dose;
	String vaccine;
	
	
	
	public Mailer(String from, String to) {
		this.from = from;
		this.to = to;
		this.host = "localhost";
		properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		session.getDefaultInstance(properties);
		
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



	public void sendImmunizationNotificationMail() {
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Reminder: Your ward is due for their vaccine");
			
			message.setText("Your ward" + this.getStudName() + "is due for their" + this.getDose() + "of the" + this.getVaccine());

			Transport.send(message);
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
	
	public void sendImmunizationWarning() {
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Warning: Your ward is overdue for their vaccine");
			message.setText("Your ward" + this.getStudName() + "is overdue for their" + this.getDose() + "of the" + this.getVaccine());
			Transport.send(message);
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
