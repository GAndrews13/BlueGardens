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

public class RegistrationEmail {

	public RegistrationEmail(String customerEmail, String firstName,
			String username) {
		// Recipient's email ID needs to be mentioned.
		String to = customerEmail;

		// Sender's email ID needs to be mentioned
		String from = "jordanmander@gmail.com";

		// Assuming you are sending email from localhost
		String host = "localhost";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));

			// Set Subject: header field
			message.setSubject("Welcome to NB Gardens");

			// Now set the actual message
			message.setText("Dear" + firstName + "/r/r"
					+ "Thank you for registering with NB Gardens." + "/r/r"
					+ "For future reference your username is: " + username
					+ "/r/r" + "Sincerely, NB Gardens");

			// Send message
			Transport.send(message);

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
