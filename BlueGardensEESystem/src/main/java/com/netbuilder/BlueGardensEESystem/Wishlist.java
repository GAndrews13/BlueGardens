package com.netbuilder.BlueGardensEESystem;

import java.util.ArrayList;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Contains all products
 * @author gandrews
 * This is a list of items that a customer is interested in but are not currently looking to purchase
 */
public class Wishlist {
	
	/**
	 * A default constructor that replies on being provided a customer ID
	 */
	public Wishlist(int customerID)
	{
		this.customerID = customerID;
	}
	
	/**
	 * Creates an instance using a test variable of Customer ID 0
	 */
	public Wishlist()
	{
		this(0);
	}
	
	@Id
	@Column (name="CustomerID", nullable=false)
	@NotNull
	/**
	 * ID of the customer who has created the wishlist
	 */
	private int customerID;
	/**
	 * The list of products that have been added and are tracked by the wishlist
	 */
	@Column (name = "products")
	@OneToMany
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
