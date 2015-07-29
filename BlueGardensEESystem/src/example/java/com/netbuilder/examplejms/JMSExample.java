package com.netbuilder.examplejms;

import Messagesenders.SalePourousTrendingSender;

public class JMSExample {

	public static void main(String[] args) {
		MessageReceiver receiver = new MessageReceiver();
		SalePourousTrendingSender sender = new SalePourousTrendingSender();
		receiver.receiveObjectMessage();
		sender.sendObjectMessage();
	}
}