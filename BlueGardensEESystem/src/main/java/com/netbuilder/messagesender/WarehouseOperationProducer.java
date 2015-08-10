package com.netbuilder.messagesender;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

public class WarehouseOperationProducer implements Runnable
{
	private ActiveMQConnectionFactory connectionFactory = null;
	private Connection connection = null;
	private Session session = null;
	private MessageProducer producer = null;
	private TextMessage message = null;
	private Destination destination = null;
	
	public void run()
	{
		try 
		{
			// Create a ConnectionFactory
            connectionFactory = new ActiveMQConnectionFactory("vm://localhost");

            // Create a Connection
            connection = connectionFactory.createConnection();
            connection.start();

            // Create a Session
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (Topic or Queue)
            destination = session.createQueue("TEST.FOO");

            // Create a MessageProducer from the Session to the Topic or Queue
            producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            // Create a messages
            String text = "Hello world! From: " + Thread.currentThread().getName() + " : " + this.hashCode();
            message = session.createTextMessage(text);

            // Tell the producer to send the message
            System.out.println("Sent message: "+ message.hashCode() + " : " + Thread.currentThread().getName());
            producer.send(message);

            // Clean up
            session.close();
            connection.close();
		}
		catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
	}
}
