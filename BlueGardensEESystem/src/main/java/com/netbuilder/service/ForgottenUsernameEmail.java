package com.netbuilder.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.netbuilder.entitymanagers.CustomerLoginManager;

/**
 * @author jmander
 **/
public class ForgottenUsernameEmail {
	private CustomerLoginManager customerLoginManager;
	private String username;

	public ForgottenUsernameEmail(String customerEmail) {
		username = customerLoginManager.getCustomerUsername(customerEmail);
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
			message.setText("Your username is: " + username + "/r/r" + "Sincerely, NB Gardens");
			Transport.send(message);
		} catch (MessagingException mex) { mex.printStackTrace(); }
	}
}