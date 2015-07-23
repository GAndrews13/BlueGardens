package com.netbuilder.service;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.netbuilder.entities.Product;
import com.netbuilder.entitymanagers.CustomerLoginManager;
import com.netbuilder.entitymanagers.WishListManager;

@Stateless
public class WishlistForUser {
	@Inject
	private WishListManager wishListManager;
	@Inject
	private CustomerLoginManager customerLoginManager;
	
	public ArrayList<Product> getProductsForUser(String username) {
		return wishListManager.findForUser(customerLoginManager.checkCustomerID(username));
	}
}