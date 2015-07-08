package com.netbuilder.BlueGardensEESystem;

import java.util.ArrayList;

public class Basket {
/**
 * @author abalagel
 * Attributes for the Basket
 * unique customer id from customer table
 * list of order lines that each contains a product and its required quantity passed from ProductOrderLine.java
*/	
	private int customerId;
	private ArrayList<ProductOrderLine> ProductOrderLine;
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
