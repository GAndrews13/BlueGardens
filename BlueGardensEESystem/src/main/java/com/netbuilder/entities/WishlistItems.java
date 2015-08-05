package com.netbuilder.entities;

import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.netbuilder.entitymanagers.ProductManager;

/**
 * Contains all products
 * @author Anca
 * @author jmander
 * This is a list of items that a customer is interested in but are not currently looking to purchase
 */
@Entity
@Table(name="WishlistItems")
@NamedQueries ({@NamedQuery (name = WishlistItems.FIND_BY_CUSTOMER_ID, query = "SELECT * FROM WishlistItems WHERE customerID = :id")})
public class WishlistItems {
	
	public static final String FIND_BY_CUSTOMER_ID = "WishlistItems.findByCustomerId";
	
	public WishlistItems(){
		
	}
	
	@Id
	@ManyToOne
	@JoinColumn(name ="CustomerID", nullable = false)
	@NotNull
	private long customerID;

	@Id
	@ManyToOne
	@JoinColumn(name ="ProductID", nullable = false)
	@NotNull
	private int productID;

	public long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public WishlistItems(long customerID, int productID) {
		this.customerID = customerID;
		this.productID = productID;
	}
	
	@Override
	public String toString() {
		return "product ID:" + productID;
	}
	
}