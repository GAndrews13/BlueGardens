package com.netbuilder.messagesender;

import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;

import com.netbuilder.service.ProductsOfIntrest;
import com.netbuilder.util.ProductOfIntrestLists;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;

/**
 * @author lczornyj
 * This is a message sender for the landing page.
 * This does not need to be used as it was purely a test.
 * The method draws in the products of interest from the products of interest page and places them into an object to be sent.
 * 
 * This was designed with jboss 7.0 however it should not work with wildfly.
 */
public class SalePourousTrendingSender {
	@Inject
	ProductsOfIntrest poi;
	private Context context;
	private QueueConnectionFactory connectionFactory;
	private Destination destination;
	private Connection connection;
	private Session session;
	private MessageProducer messageProducer;
	private ObjectMessage objectMessage;
	
	public void sendObjectMessage() {
		try {
			context = new InitialContext();
			connectionFactory = (QueueConnectionFactory) context.lookup("ConnectionFactory");
			destination = (Queue) context.lookup("messagequeue");
			connection = connectionFactory.createConnection();
			session = connection.createSession(false, AUTO_ACKNOWLEDGE);
			messageProducer = session.createProducer(destination);
			ProductOfIntrestLists message = new ProductOfIntrestLists(poi.getSale(), poi.getPourous(), poi.getTrending());
			objectMessage = session.createObjectMessage(message);
			connection.start();
			messageProducer.send(objectMessage);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			if (context != null) { try {
					context.close();
				} catch (NamingException e) { e.printStackTrace(); }
			}
			if (connection != null) { try {
					connection.close();
				} catch (JMSException e) { e.printStackTrace(); }
			}
		}
	}
}