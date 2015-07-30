package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.CustomerOrder;
import com.netbuilder.entities.Product;
import com.netbuilder.entities.ProductOrderLine;
import com.netbuilder.entitymanagers.CustomerOrderManager;
import com.netbuilder.entitymanagers.ProductOrderLineManager;
import com.netbuilder.entitymanagers.WishListManager;

@Named
@RequestScoped
public class AccountController 
{
	//@Inject
	private Customer cust;
	private WishListManager wishListManager;
	private CustomerOrderManager com;
	
	public String showCustomerDetails()
	{
		String line1 = cust.getFirstName() + " " + cust.getLastName();
		String line2 = cust.getAddress();
		String line3 = cust.getContactNUM();
		String line4 = cust.getEmail();
		return line1 + "/r/r" + line2 + "/r/r" + line3 + "/r/r" + line4 + "/r/r"; 
	}
	
	public String showOrders()
	{
		String orderList = null;
		ArrayList<CustomerOrder> list = com.findByCustomer(cust);
		for(CustomerOrder co: list)
		{
			ArrayList<ProductOrderLine> polList = co.getProductOrderLines();
			for(ProductOrderLine pol : polList)
			{
				orderList += pol.getProduct().getProductID() + "/t/t/t/t" + pol.getQuantity() + "/r/r";
			}
		}
		return orderList;
	}
	
}
