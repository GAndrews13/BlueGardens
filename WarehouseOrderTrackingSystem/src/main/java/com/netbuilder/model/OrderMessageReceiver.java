package com.netbuilder.model;

import java.io.File;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;

@Component
public class OrderMessageReceiver {
	/**
	 * Get a copy of the application context
	 */
	public ArrayList<CustomerOrder> orders = new ArrayList<CustomerOrder>();
	public ArrayList<ProductOrderLine> pol = new ArrayList<ProductOrderLine>();

	@Autowired
	ConfigurableApplicationContext context;

	/**
	 * When you receive a message, print it out, then shut down the application.
	 * Finally, clean up any ActiveMQ server stuff.
	 */
	@JmsListener(destination = "mailbox-destination", containerFactory = "myJmsContainerFactory")
	public void receiveMessage(String message) {
		pol.add(new ProductOrderLine(new Product("gnome1", 12, 5, 10, false,
				10.5, false, "a", "little", "gnome", "in", "the garden",
				"test", false), 12));
		pol.add(new ProductOrderLine(new Product("gnome2", 7, 5, 10, false,
				10.5, false, "a", "little", "gnome", "in", "the garden",
				"test", false), 7));
	
		orders.add(new CustomerOrder(1, true, 10001, "standard", 1, 1, DeliveryStatus.PROCESSING, 19.99));
				System.out.println("Received <" + message + ">");

		context.close();
		FileSystemUtils.deleteRecursively(new File("activemq-data"));
	}
}
