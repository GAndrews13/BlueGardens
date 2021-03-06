package com.netbuilder.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.ActiveMQConnectionFactory;

public class LoginProducer
{
	// Defines the queue.
	 public final static String QUEUE="JMSQueue";
	
	 private QueueConnectionFactory qconFactory;
	 private QueueConnection qcon;
	 private QueueSession qsession;
	 private QueueSender qsender;
	 private Queue queue;
	 private TextMessage msg;
	 private ActiveMQConnectionFactory connectionFactory = null;
	 private Connection connection = null; 
	 private Session session = null;
	 private Destination destination = null;
	 private MessageProducer producer = null;
	 private Message message = null;
	 private static int id;
	 private static String password;
	 Context ctx;

	 /**
	  * Creates all the necessary objects for sending
	  * messages to a JMS queue.
	  *
	  * @param ctx JNDI initial context
	  * @param queueName name of queue
	  * @exception NamingException if operation cannot be performed
	  * @exception JMSException if JMS fails to initialize due to internal error
	  */
	 public void init() throws NamingException, JMSException
	 {
		// Create a ConnectionFactory
         connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

         // Create a Connection
         connection = connectionFactory.createConnection();

         // Create a Session
         session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

         // Create the destination (Topic or Queue)
         destination = session.createQueue("TEST.FOO");

         // Create a MessageProducer from the Session to the Topic or Queue
         producer = session.createProducer(destination);
         producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		 message = session.createTextMessage();
		 connection.start();
	 }

	 /**
	  * Sends a message to a JMS queue.
	  *
	  * @param message  message to be sent
	  * @exception JMSException if JMS fails to send message due to internal error
	  */
	 public void send(String message) throws JMSException {
	    ((TextMessage) this.message).setText(message);
	    producer.send(this.message);
	 }

	 /**
	  * Closes JMS objects.
	  * @exception JMSException if JMS fails to close objects due to internal error
	  */
	 public void close() throws JMSException {
	    producer.close();
	    session.close();
	    connection.close();
	 }
	/** main() method.
	 *
	 * @param args WebLogic Server URL
	 * @exception Exception if operation fails
	 */
	 public static void main(String[] args) throws Exception 
	 {
	    LoginProducer qs = new LoginProducer();
	    qs.init();
		    readAndSend(qs);
		    qs.close();
	 }
	 
	 private static void readAndSend(LoginProducer qs)throws IOException, JMSException
	 {
		 String ID=String.valueOf(id);
		 
	     if (ID != null && ID.trim().length() != 0) 
	     {
	    	 qs.send("ID:"+ ID);
	    	 System.out.println("ID: "+ID+"\n");
	     }
	     if (password != null && password.trim().length() != 0) {
	    	 qs.send("Password:"+password);
	    	 System.out.println("Password: "+password+"\n");
	     }
	 }
	 
	 public void setPassword(String pass)
	 {
		 this.password = pass;
	 }
	 
	 public String getPassword()
	 {
		 return password;
	 }
	 
	 public void setID(int id)
	 {
		 this.id = id;
	 }
	 
	 public int getID()
	 {
		 return id;
	 }
/*
	 private static void readAndSend(LoginProducer qs)
	    throws IOException, JMSException
	 {
	    BufferedReader msgStream = new BufferedReader(new InputStreamReader(System.in));
	    String line=null;
	    boolean quitNow = false;
	    do {
	     System.out.print("Enter message (\"quit\" to quit): \n");
	     line = msgStream.readLine();
	     if (line != null && line.trim().length() != 0) {
	       qs.send(line);
	       System.out.println("ID: "+line+"\n");
	       quitNow = line.equalsIgnoreCase("quit");
	     }
	    } while (! quitNow);

	 }
	 */

}
