package com.netbuilder.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author jmander
 **/
public class ForgottenPasswordEmail {

	public ForgottenPasswordEmail(String customerEmail) {
		String to = customerEmail;
		String from = "jordanmander@gmail.com";
		String host = "localhost";
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(properties);
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Welcome to NB Gardens");
			message.setText("Password reset link");
			Transport.send(message);
		} catch (MessagingException mex) { mex.printStackTrace(); }
	}
}