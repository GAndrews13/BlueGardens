package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Product;
import com.netbuilder.entitymanagers.WishListManager;

@Named
@Dependent
public class WishListController {
	@Inject
	private WishListManager wishListManager;
	public ArrayList<Product> products = new ArrayList<Product>();
	
	public WishListController(int customerID){
		//get logged in user id to  sent to wishlist manager
		products = wishListManager.findForUser(customerID);
	}
}
