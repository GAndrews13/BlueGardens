package com.netbuilder.BlueGardensEESystem;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Basket {
/**
 * @author abalagel
 * Attributes for the Basket
 * unique customer id from customer table
 * list of order lines that each contains a product and its required quantity passed from ProductOrderLine.java
*/	
	@Id
	@Column (name = "Customer ID", nullable = false)
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	
	@JoinColumn (name = "POLID", nullable = false)
	@NotNull
	@OneToMany
	private ArrayList<ProductOrderLine> ProductOrderLine;
public Basket(int customerId, ArrayList<com.netbuilder.BlueGardensEESystem.ProductOrderLine> productOrderLine) {
	
		this.customerId = customerId;
		ProductOrderLine = productOrderLine;
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
	public ArrayList<ProductOrderLine> getProductOrderLine() {
		return ProductOrderLine;
	}
	public void setProductOrderLine(ArrayList<ProductOrderLine> productOrderLine) {
		ProductOrderLine = productOrderLine;
	}
}
