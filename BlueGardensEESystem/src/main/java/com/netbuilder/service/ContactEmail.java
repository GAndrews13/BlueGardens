package com.netbuilder.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author abalagel
 */
public class ContactEmail {

	public void sendEmail(String name, String email, String message) {
		String emailAddressTo = "anca.balagel@netbuilder.com";
		String host = "localhost";
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(properties);
		try {
			 MimeMessage comm = new MimeMessage(session);
			 comm.setFrom(new InternetAddress(email));
	         comm.addRecipient(Message.RecipientType.TO, new InternetAddress(emailAddressTo));	         
	         comm.setText(name + " sent this message: " + message);
	         Transport.send(comm);	
		} catch (MessagingException mex) {  mex.printStackTrace(); }
	}
}