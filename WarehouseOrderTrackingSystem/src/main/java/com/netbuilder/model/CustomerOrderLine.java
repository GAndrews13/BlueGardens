package com.netbuilder.model;



/**
 * 
 * @author Jake Customer Order Line Entity
 */

public class CustomerOrderLine {
	public static final String FIND_BY_CO_ID = "CustomerOrderLine.findByCOID";
	public static final String FIND_BY_PRODUCT_ID = "CustomerOrderLine.findByPID";
	public static final String FIND_BY_QUANTITY = "CustomerOrderLine.findByQUANTITY";

	/**
	 * Customer Order Line ID is the primary key for the this table
	 */

	private int CustomerOrderID;

	/**
	 * Product ID will be linked to the product entity
	 */
	private int productId;

	/**
	 * Quantity cannot be null as at least one product must be in the order line
	 */

	private int quantity;

	/**
	 * Quantity cannot be null as at least one product must be in the order line
	 */

	private boolean isPicked;

	public CustomerOrderLine(int productID, int Quantity) {
		this.productId = productID;
		this.quantity = Quantity;
	}

	public CustomerOrderLine(int customerOrderID, int productId, int quantity,
			boolean isPicked) {
		CustomerOrderID = customerOrderID;
		this.productId = productId;
		this.quantity = quantity;
		this.isPicked = isPicked;
	}

	/**
	 * @author Jake Getters and Setters for class variables Initialise class
	 */
	public int getCustomerOrderID() {
		return CustomerOrderID;
	}

	public void setCustomerOrderID(int customerOrderID) {
		CustomerOrderID = customerOrderID;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setIsPicked(boolean picked) {
		isPicked = picked;
	}

	public boolean getIsPicked() {
		return isPicked;
	}

}
