package com.netbuilder.model;
/**
 * @author Jake
 * Product Order Line entity
 */
public class ProductOrderLine 
{	
	public static final String FIND_BY_POL_ID = "ProductOrderLine.findByPOLID";
	public static final String FIND_BY_CUSTOMER_ID = "ProductOrderLine.findByCID";
	/**
	 * @author Jake
	 * Attributes of the Product Order Line
	 * including unique identifier and the quantity of the products 
	 */
	
	/**
	 * Product Order Line ID is the primary key for the this table
	 */
	private int productOrderLineID;
	private Product product;
	private int quantity;	
	public ProductOrderLine( Product product, int quantity) 
	{
		this.product = product;
		this.quantity = quantity;
	}
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
	public Product getProduct() {
		return product;
	}
	public void setProductID(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * @author GAndrews
	 * @return
	 */
	public double getTotal() {
		double total =quantity*product.getPrice() ;
		return total;
	}
}
