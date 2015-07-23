package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Product;
import com.netbuilder.service.WishlistForUser;
import com.netbuilder.util.UserDetails;

@Named
@Dependent
public class WishListController {
	@Inject
	private WishlistForUser wishlistForUser;
	@Inject
	private UserDetails userDetails;
	public ArrayList<Product> products = new ArrayList<Product>();
	
	public WishListController(){
		products = wishlistForUser.getProductsForUser(userDetails.getUsername());
	}
}
