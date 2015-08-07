package com.netbuilder.service;
import javax.inject.Inject;

import com.netbuilder.BlueGardensEESystem.DeliveryStatus;
import com.netbuilder.controllers.LoginController;
import com.netbuilder.entities.Basket;
import com.netbuilder.entities.Customer;
import com.netbuilder.entities.CustomerOrder;
import com.netbuilder.entitymanagers.CustomerManager;
import com.netbuilder.entitymanagers.CustomerOrderManager;
import com.netbuilder.entitymanagers.ProductOrderLineManager;
import com.netbuilder.util.LoggedInUser;
import com.netbuilder.util.LoginUtils;
import com.netbuilder.util.UserDetails;


public class BasketProductOrderService {
	@Inject
	private static LoggedInUser loggedInUser;
	@Inject
	private static CustomerManager customerManager;
	@Inject
	private static CustomerOrderManager com;
	public static void createBasketOrder(Basket inBasket)
	{
		CustomerOrder co = new CustomerOrder(false,
				"standard", loggedInUser.getUserID(),
				0, DeliveryStatus.ORDER_PLACED) ;
		
		//create product order line
		com.persistCustomerOrder(co);
	}
}
