package com.netbuilder.controllers;

import java.util.ArrayList;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import com.netbuilder.entities.Product;
import com.netbuilder.service.WishlistForUser;

/**
 * @author abalagel
 */
@Named
@Dependent
public class WishListController {
	@Inject
	private WishlistForUser wishlistForUser;
	private LoginController loginController;
	public ArrayList<Product> products = new ArrayList<Product>();	
	
	public ArrayList<Product> getProducts() {
		return products;
	}


	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}


	public WishListController(){
		
		products = wishlistForUser.getProductsForUser(loginController.getUsername());
		
	}
}
