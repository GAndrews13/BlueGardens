package com.netbuilder.examplejms;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.netbuilder.util.ProductOfIntrestLists;


public class ExampleListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			ObjectMessage objectMessage = (ObjectMessage) message;
			ProductOfIntrestLists poil = (ProductOfIntrestLists) objectMessage.getObject();
			System.out.println(poil.toString());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}