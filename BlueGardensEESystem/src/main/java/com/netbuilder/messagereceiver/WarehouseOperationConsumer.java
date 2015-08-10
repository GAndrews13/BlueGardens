package com.netbuilder.messagereceiver;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class WarehouseOperationConsumer implements ExceptionListener, Runnable {
	private ActiveMQConnectionFactory connectionFactory = null;
	private Connection connection = null;
	private Session session = null;
	private Destination destination = null;
	private MessageConsumer consumer = null;
	private Message message = null;
	Thread iThread = null;

	public void run() {
		try {
			connectionFactory = new ActiveMQConnectionFactory("vm://localhost");
			// Create a Connection
			connection = connectionFactory.createConnection();
			connection.start();

			connection.setExceptionListener(this);

			// Create a Session
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// Create the destination (Topic or Queue)
			destination = session.createQueue("TEST.FOO");

			// Create a MessageConsumer from the Session to the Topic or Queue
			consumer = session.createConsumer(destination);

			// Wait for a message
			message = consumer.receive(1000);

			if (message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				String text = textMessage.getText();
				System.out.println("Received: " + text);
			} else {
				System.out.println("Received: " + message);
			}

			consumer.close();
			session.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("Caught: " + e);
			e.printStackTrace();
		}
	}

	@Override
	public void onException(JMSException arg0) {
		// TODO Auto-generated method stub
		System.out.println("JMS Exception occured.  Shutting down client.");
	}

}
