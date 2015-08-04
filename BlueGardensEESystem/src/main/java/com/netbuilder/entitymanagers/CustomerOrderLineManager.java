package com.netbuilder.entitymanagers;

import java.util.ArrayList;

import com.netbuilder.entities.CustomerOrderLine;

public interface CustomerOrderLineManager 
{	
	/**
	 * @author Jake
	 *	Add a new customer order line into the system
	 */
	public void persistCOL(CustomerOrderLine col);
	
	/**
	 * @author Jake
	 *	Find a customer order line by a product ID
	 */
	public ArrayList<CustomerOrderLine> findByPOID(int po_ID);
	
	/**
	 * @author Jake
	 *	Find a customer order line by the customer ID
	 */
	public CustomerOrderLine findByCOID(int customerID);
	
	/**
	 * @author Jake
	 *	Find all customer order lines above a certain quantity
	 */
	public ArrayList<CustomerOrderLine> findByQuantity(int quantity);

	/**
	 * @author Jake
	 *	Update details in a customer order line
	 */
	public void updateCOL(CustomerOrderLine pol);
	
	/**
	 * @author Jake
	 *	Return all customer order lines
	 */
	public ArrayList <CustomerOrderLine> findall();
	
}
