package com.netbuilder.entities;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "Basket")
@NamedQueries({ 
	@NamedQuery(name = Basket.FIND_OUT_BY_PRODUCTID, query = "SELECT b FROM Basket WHERE b.productId = 1")	
})
public class Basket {
/**
 * @author abalagel
 * Attributes for the Basket
 * unique customer id from customer table
 * list of order lines that each contains a product and its required quantity passed from CustomerOrderLine.java
*/	
	public static final String FIND_OUT_BY_PRODUCTID = "Basket.findByProductId";
	@Id
	@Column (name = "Customer ID", nullable = false)
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	
	@JoinColumn (name = "POLID", nullable = false)
	@NotNull
	@OneToMany
	private ArrayList<CustomerOrderLine> CustomerOrderLine;
public Basket(int customerId, ArrayList<CustomerOrderLine> customerOrderLine) {
	
		this.customerId = customerId;
		CustomerOrderLine = customerOrderLine;
	}
/**
* @author abalagel
*  getters and setters for class variables
*  initialise class
*/	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public ArrayList<CustomerOrderLine> getCustomerOrderLine() {
		return CustomerOrderLine;
	}
	public void setCustomerOrderLine(ArrayList<CustomerOrderLine> customerOrderLine) {
		CustomerOrderLine = customerOrderLine;
	}
	

}
