package com.netbuilder.entities;

import java.util.ArrayList;

public class Basket {
	/**
	 * @author abalagel Attributes for the Basket unique customer id from
	 *         customer table list of order lines that each contains a product
	 *         and its required quantity passed from CustomerOrderLine.java
	 */

	private long customerId;
	private ArrayList<CustomerOrderLine> customerOrderLines;
	private int customerOrderID;

	public Basket(int customerOrderID, long customerId, ArrayList<CustomerOrderLine> customerOrderLines) {
		this.customerOrderID = customerOrderID;
		this.customerId = customerId;
		this.customerOrderLines = customerOrderLines;
	}

	public int getCustomerOrderID() {
		return customerOrderID;
	}

	public void setCustomerOrderID(int customerOrderID) {
		this.customerOrderID = customerOrderID;
	}

	/**
	 * @author abalagel getters and setters for class variables initialise class
	 */
	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public ArrayList<CustomerOrderLine> getCustomerOrderLines() {
		return customerOrderLines;
	}

	public void setCustomerOrderLines(
			ArrayList<CustomerOrderLine> customerOrderLine) {
		this.customerOrderLines = customerOrderLine;
	}

}
