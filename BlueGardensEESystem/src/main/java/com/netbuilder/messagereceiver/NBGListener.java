package com.netbuilder.messagereceiver;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

public class NBGListener implements MessageListener
{

	/**
	* Casts the message to a TextMessage and displays its text.
	*
	* @param message the incoming message
	*/
	public void onMessage(Message message) 
	{
		ObjectMessage msg = null;
		try 
		{
			if (message instanceof ObjectMessage) 
			{
				msg = (ObjectMessage) message;
				
				System.out.println("Reading message: " +
				msg.getObject());
			} 
			else 
			{
				System.out.println("Message of wrong type: " +
				message.getClass().getName());
			}
		} 
		catch (JMSException e) 
		{
			System.out.println("JMSException in onMessage(): " +
			e.toString());
		} 
		catch (Throwable t) 
		{
			System.out.println("Exception in onMessage():" +
			t.getMessage());
		}
	}
}

