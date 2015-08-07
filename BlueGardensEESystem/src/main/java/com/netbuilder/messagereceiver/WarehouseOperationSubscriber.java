package com.netbuilder.messagereceiver;

import java.awt.event.TextListener;
import java.io.InputStreamReader;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class WarehouseOperationSubscriber {
	private String topicName = null;
	private Context jndiContext = null;
	private TopicConnectionFactory topicConnectionFactory = null;
	private TopicConnection topicConnection = null;
	private TopicSession topicSession = null;
	private Topic topic = null;
	private TopicSubscriber topicSubscriber = null;
	private TextListener topicListener = null;
	private TextMessage message = null;
	private InputStreamReader inputStreamReader = null;
	
	public void recieveMessage()
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
			topicSubscriber =
					topicSession.createSubscriber(topic);
			topicSubscriber.setMessageListener(new NBGListener());
			topicConnection.start();
			Runnable idleRunnable = new Runnable() {
				@Override public void run() { while (true) { }}};
			Thread iThread = new Thread(idleRunnable, "iThread");
		}
		catch (NamingException e) 
		{
			e.printStackTrace();
		} 
		catch (JMSException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			if (jndiContext != null) 
			{ 
				try 
				{
					jndiContext.close();
				} 
				catch (NamingException e) 
				{
					e.printStackTrace();
				}
			}
			if (topicConnection != null) 
			{ 
				try 
				{
					topicConnection.close();
				} 
				catch (JMSException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
}
