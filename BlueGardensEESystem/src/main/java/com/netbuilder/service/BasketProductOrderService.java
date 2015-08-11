package com.netbuilder.service;

import javax.inject.Inject;

import com.netbuilder.BlueGardensEESystem.DeliveryStatus;
import com.netbuilder.entities.Basket;
import com.netbuilder.entities.CustomerOrder;
import com.netbuilder.entitymanagers.CustomerManager;
import com.netbuilder.entitymanagers.CustomerOrderManager;
import com.netbuilder.util.LoggedInUser;

public class BasketProductOrderService {
	@Inject
	private static LoggedInUser loggedInUser;
	@Inject
	private static CustomerManager customerManager;
	@Inject
	private static CustomerOrderManager com;

	public static void createBasketOrder(Basket inBasket) {
		CustomerOrder co = new CustomerOrder(false, "standard",
				loggedInUser.getUserID(), 0, DeliveryStatus.ORDER_PLACED, 1);

		// create product order line
		com.persistCustomerOrder(co);
	}
}
