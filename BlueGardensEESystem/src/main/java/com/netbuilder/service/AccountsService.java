package com.netbuilder.service;

import java.util.ArrayList;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.CustomerOrder;
import com.netbuilder.entities.Product;
import com.netbuilder.entities.ProductOrderLine;
import com.netbuilder.entitymanagers.CustomerOrderManager;
import com.netbuilder.entitymanagers.WishListManager;
import com.netbuilder.entitymanagers.Dummy.CustomerOrderManagerDummy;
import com.netbuilder.entitymanagers.Dummy.WishlistManagerDummy;

public class AccountsService {

	/*
	 * @author David Ogbonnah
	 */
	
	private ArrayList<CustomerOrder> openOrders;
	private ArrayList<Product> userWishlist;
	
	public AccountsService()
	{
		
	}
	
	public String showUserWishList(long customerID)
	{
		String wishString = "";
		WishListManager wishlist = new WishlistManagerDummy();
		userWishlist = wishlist.findForUser(customerID);
		for(Product p : userWishlist)
		{
			wishString += p.getProductID() + "/t/t" + p.getProductName() +"/r/r";
		}
		
		return wishString;
	}
	
	public String showOpenOrders(Customer customer)
	{
		String orderString = "";
		CustomerOrderManager com = new CustomerOrderManagerDummy();
		openOrders = com.findByCustomer(customer);
		for(CustomerOrder co : openOrders)
		{
			orderString += co.getCustomerOrderID() + "/r";
			ArrayList<ProductOrderLine> pols = co.getProductOrderLines();
			for(ProductOrderLine p : pols)
			{ 
				orderString += p.getProductID() + "/t/t" + p.getQuantity();
			}
			
			orderString += "/r/r";
		}
		
		return orderString;
	}
}
