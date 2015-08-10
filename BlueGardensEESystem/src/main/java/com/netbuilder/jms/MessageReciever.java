package com.netbuilder.jms;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MessageReciever implements MessageListener {

	private Context cxt = null;
	private TopicConnectionFactory cF = null;
	private TopicConnection con = null;
	private Topic topic = null;
	private TopicSession session = null;
	private TopicSubscriber tS = null;
	Thread iThread = null;

	public void receiveObjectMessage() {
		try {
			cxt = new InitialContext();
			cF = (TopicConnectionFactory) cxt.lookup("ConnectionFactory");
			topic = (Topic) cxt.lookup("topic1");
			con = cF.createTopicConnection();
			session = con.createTopicSession(false, AUTO_ACKNOWLEDGE);
			tS = session.createSubscriber(topic);
			con.start();
			tS.setMessageListener(new ExampleListener());
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			if (cxt != null) {
				try {
					cxt.close();
				} catch (NamingException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private class ExampleListener implements MessageListener {

		@Override
		public void onMessage(Message arg0) {
			// TODO Auto-generated method stub

		}

	}

	@Override
	public void onMessage(Message arg0) {
		// TODO Auto-generated method stub

	}

}