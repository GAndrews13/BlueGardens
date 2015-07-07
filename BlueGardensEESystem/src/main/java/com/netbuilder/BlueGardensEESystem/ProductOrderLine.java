package com.netbuilder.BlueGardensEESystem;
/**
 * @author Jake
 *
 */
public class ProductOrderLine 
{	
	/**
	 * @author Jake
	 * Attributes of the Product Order Line
	 * including unique identifier and the quantity of the products 
	 */
	private int productOrderLineID;
	private int productID;
	private int quantity;
	
	
	
	/**
	 * @author Jake
	 *	Getters and Setters for class variables
	 *	Initialise class
	 */
	public int getProductOrderLineID() {
		return productOrderLineID;
	}
	public void setProductOrderLineID(int productOrderLineID) {
		this.productOrderLineID = productOrderLineID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
