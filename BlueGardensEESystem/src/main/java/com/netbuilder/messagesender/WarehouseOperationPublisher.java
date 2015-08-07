package com.netbuilder.messagesender;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.netbuilder.BlueGardensEESystem.WarehouseOperation;

public class WarehouseOperationPublisher 
{
	private String topicName = null;
	private Context jndiContext = null;
	private TopicConnectionFactory topicConnectionFactory = null;
	private TopicConnection topicConnection = null;
	private TopicSession topicSession = null;
	private Topic topic = null;
	private TopicPublisher topicPublisher = null;
	private ObjectMessage message = null;
	
	public void sendMessage()
	{
		try 
		{
			topicName = "ump45topic";
			jndiContext = new InitialContext();
			topicConnectionFactory = (TopicConnectionFactory)
					jndiContext.lookup("ACR1.8ConnectionFactory");
			topic = (Topic) jndiContext.lookup(topicName);
			topicConnection =
					topicConnectionFactory.createTopicConnection();
			topicSession =
					topicConnection.createTopicSession(false,
					Session.AUTO_ACKNOWLEDGE);
			topicPublisher = topicSession.createPublisher(topic);
			WarehouseOperation woMessage = new WarehouseOperation();
			message = topicSession.createObjectMessage(woMessage);
			message.setObject(woMessage);
			topicConnection.start();
			topicPublisher.publish(message);
		}
		catch (NamingException e) 
		{
			e.printStackTrace();
		}
		catch(JMSException jmse)
		{
			jmse.printStackTrace();
		}
		finally {
			if (jndiContext != null) {
				try {
					jndiContext.close();
				} catch (NamingException e) {
					e.printStackTrace();
				}
			}
			if (topicConnection != null) {
				try {
					topicConnection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
