package com.netbuilder.service;

import javax.inject.Inject;

import com.netbuilder.entities.Basket;
import com.netbuilder.entities.Customer;
import com.netbuilder.entities.CustomerOrder;
import com.netbuilder.entitymanagers.CustomerManager;
import com.netbuilder.entitymanagers.CustomerOrderManager;
import com.netbuilder.util.UserDetails;

public class BasketProductOrderService {
	@Inject
	private static UserDetails ud;
	@Inject
	private static CustomerManager customerManager;
	@Inject
	private static CustomerOrderManager com;
	
	public static void createBasketOrder(Basket inBasket) {
		Customer customer = customerManager.findByID(ud.getUserID());
		CustomerOrder co = new CustomerOrder(customer,inBasket.getProductOrderLine());
		//create product order line
		com.persistCustomerOrder(co);
	}
}