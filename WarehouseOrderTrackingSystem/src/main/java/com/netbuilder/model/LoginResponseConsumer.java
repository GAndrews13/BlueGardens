package com.netbuilder.model;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.NamingException;
import org.apache.activemq.ActiveMQConnectionFactory;

public class LoginResponseConsumer implements MessageListener, ExceptionListener{
	
	public final static String QUEUE="JMSQueue";
	
	private ActiveMQConnectionFactory connectionFactory = null;
	private Connection connection = null; 
	private Session session = null;
	private Destination destination = null;
	private MessageConsumer consumer = null;
	private int id = -1;
	private String password;
	private static String response;
	private boolean quit = false;
	
	 /**
	  * Creates all the necessary objects for receiving
	  * messages from a JMS queue.
	  *
	  * @param   ctx    JNDI initial context
	  * @param    queueName    name of queue
	  * @exception NamingException if operation cannot be performed
	  * @exception JMSException if JMS fails to initialize due to internal error
	  */
	public void init() throws NamingException, JMSException
	{
		connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
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
	
	    // Create a MessageConsumer from the Session to the Topic or Queue
	    consumer.setMessageListener(this);
	    
	}

	public void close() throws JMSException
	{
		consumer.close();
		session.close();
		connection.close();
	}

	public void onMessage(Message msg)
	{
	    try {
	     String msgText;
	     if (msg instanceof TextMessage) {
	       msgText = ((TextMessage)msg).getText();
	     } else {
	       msgText = msg.toString();
	     }
	     
	     if (msgText.startsWith("Password")) {
		       synchronized(this) {
		    	   String[]temp = null;
		    	 System.out.println("Message Received: "+ msgText );
		    	 temp = msgText.split("Password:");
		    	 password = temp[1];
		         this.notifyAll(); // Notify main thread to quit
		       }
		     }
	     if (msgText.startsWith("ID")) {
		       synchronized(this) {
		    	   String[]temp = null;
		    	 System.out.println("Message Received: "+ msgText );
		    	 temp = msgText.split("Password:");
		    	 id = Integer.parseInt(temp[1]);
		         this.notifyAll(); // Notify main thread to quit
		       }
		     }

	     if (msgText.equalsIgnoreCase("quit")) {
	       synchronized(this) {
	         quit = true;
	         this.notifyAll(); // Notify main thread to quit
	       }
	     }
	    } catch (JMSException jmse) {
	     System.err.println("An exception occurred: "+jmse.getMessage());
	    }
	}
	
	 public static void main(String[] args) throws Exception {
		   // if (args.length != 1) {
		   //  System.out.println("Usage: java examples.jms.queue.QueueReceive WebLogicURL");
		   //  return;
		   // }
		    
		    LoginResponseConsumer qr = new LoginResponseConsumer();
		    qr.init();

		    System.out.println(
		        "JMS Ready To Receive Messages (To quit, send a \"quit\" message).");

		    // Wait until a "quit" message has been received.
		    synchronized(qr) {
		     while (! qr.quit) {
		       try {
		         qr.wait();
		       } catch (InterruptedException ie) {}
		     }
		    }
		    qr.close();
		    System.out.println(
			        "Exited system");
	}

	 public static String getResponse()
	 {
		 return response;
	 }
	 
	@Override
	public void onException(JMSException arg0) {
		// TODO Auto-generated method stub
		System.out.println("JMS Exception occured.  Shutting down client.");
	}

}
