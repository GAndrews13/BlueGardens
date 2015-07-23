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
	@NotNull
	private int customerID;

	@Column (name = "products")
	@OneToMany
	private ArrayList<Product> products;

	public Wishlist(int customerID, ArrayList<Product> products) {
		this.customerID = customerID;
		this.products = products;
	}
	public int getCustomerID() { return customerID; }
	public void setCustomerID(int customerID) { this.customerID = customerID; }

	public ArrayList<Product> getProducts() { return products; }
	public void setProducts(ArrayList<Product> products) { this.products = products; }
	
	@Override
	public String toString() {
		return "Wishlist [customerID=" + customerID + ", products=" + products + "]";
	}
}