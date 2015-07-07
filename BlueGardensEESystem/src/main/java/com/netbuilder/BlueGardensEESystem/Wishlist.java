package com.netbuilder.BlueGardensEESystem;

import java.util.ArrayList;

/**
 * 
 * @author gandrews
 *Contains all products
 */

public class Wishlist {
	private int customerID;
	private ArrayList<Products> products;
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public ArrayList<Products> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Products> products) {
		this.products = products;
	}
	
}
