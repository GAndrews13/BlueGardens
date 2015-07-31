package com.netbuilder.entities;

import java.util.ArrayList;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Contains all products
 * @author Anca
 * This is a list of items that a customer is interested in but are not currently looking to purchase
 */
@Entity
@Table(name="Wishlist")
public class Wishlist {
	@Id
	@Column (name="CustomerID", nullable=false)
	@OneToOne
	@NotNull
	private long customerID;

	@Id
	@Column (name = "productID")
	@OneToOne
	private ArrayList<Product> products;

	public Wishlist(long customerID2, ArrayList<Product> products) {
		this.customerID = customerID2;
		this.products = products;
	}
	public long getCustomerID() { return customerID; }
	public void setCustomerID(int customerID) { this.customerID = customerID; }

	public ArrayList<Product> getProducts() { return products; }
	public void setProducts(ArrayList<Product> products) { this.products = products; }
	
	@Override
	public String toString() {
		return "Wishlist [customerID=" + customerID + ", products=" + products + "]";
	}
	
}