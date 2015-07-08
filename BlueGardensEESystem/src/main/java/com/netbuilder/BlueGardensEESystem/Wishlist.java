package com.netbuilder.BlueGardensEESystem;

import java.util.ArrayList;

/**
 * Contains all products
 * @author gandrews
 * This is a list of items that a customer is interested in but are not currently looking to purchase
 */
public class Wishlist {
	/**
	 * ID of the customer who has created the wishlist
	 */
	private int customerID;
	/**
	 * The list of products that have been added and are tracked by the wishlist
	 */
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
