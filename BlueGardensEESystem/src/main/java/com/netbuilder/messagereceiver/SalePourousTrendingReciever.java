package com.netbuilder.messagereceiver;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.netbuilder.util.ProductOfIntrestLists;

public class SalePourousTrendingReciever {
	private Context context;
	private QueueConnectionFactory connectionFactory;
	private Destination destination;
	private Connection connection;
	private Session session;
	private MessageConsumer messageConsumer;
	Thread thread;
	ProductOfIntrestLists poil;

	public String receiveObjectMessage() {
		try {
			context = new InitialContext();
			connectionFactory = (QueueConnectionFactory) context.lookup("ConnectionFactory");
			destination = (Queue) context.lookup("messagequeue");
			connection = connectionFactory.createConnection();
			session = connection.createSession(false, AUTO_ACKNOWLEDGE);
			messageConsumer = session.createConsumer(destination);
			connection.start();
			messageConsumer.setMessageListener(new MessageListener() {
				@Override
				public void onMessage(Message message) {
					try {
						ObjectMessage objectMessage = (ObjectMessage) message;
						poil = (ProductOfIntrestLists) objectMessage.getObject();
						System.out.println(poil.toString());
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			});
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					while (true) {
					}
				}
			};
			thread = new Thread(runnable, "runnable");
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			if (context != null) {
				try {
					context.close();
				} catch (NamingException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
		return "faces/popular";
	}
}