package com.netbuilder.messagereceiver;

import javax.jms.JMSException;
import javax.jms.Session;
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
	private NBGListener topicListener = null;
	Thread iThread = null;
	
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
			topicListener = new NBGListener();
			topicSubscriber =
					topicSession.createSubscriber(topic);
			topicSubscriber.setMessageListener(topicListener);
			topicConnection.start();
			Runnable idleRunnable = new Runnable() {
				@Override public void run() { while (true) { }}};
			iThread = new Thread(idleRunnable, "iThread");
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
