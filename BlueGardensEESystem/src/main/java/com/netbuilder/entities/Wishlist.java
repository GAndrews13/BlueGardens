package com.netbuilder.entities;

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
	 * @param customerID This is an integer that refers to the Customer who has created this wishlist
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
	private ArrayList<Product> products;
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public ArrayList<Product> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	/**
	 * Overrides the toString method so that when returned it provides a list of products provided within the wishlist
	 */
	@Override
	public String toString()
	{
		String returner = "Wishlist for customer "+ customerID +": ";
		for(Product product : products)
		{
			returner += "\n" + product.getProductName() + "(" + product.getProductID() + ")";
		}
		return returner;
	}
	
}
