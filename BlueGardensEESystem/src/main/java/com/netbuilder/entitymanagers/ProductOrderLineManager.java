package com.netbuilder.entitymanagers;
/**
 * @author Jake
 *	Entity manager for the product order line
 */
import java.util.ArrayList;

import com.netbuilder.entities.CustomerOrderLine;

public interface ProductOrderLineManager 
{
	/**
	 * @author Jake
	 *	Add a new product order line into the system
	 */
	public void persistPOL(CustomerOrderLine pol);
	
	/**
	 * @author Jake
	 *	Find a product order line by its ID
	 */
	public CustomerOrderLine findByPOLID(int pol_ID);
	
	/**
	 * @author Jake
	 *	Find a product order line by the customer ID
	 */
	public CustomerOrderLine findByCID(int customerID);
	
	/**
	 * @author Jake
	 *	Find all product order lines above a certain quantity
	 */
	public ArrayList<CustomerOrderLine> findByQuantity(int quantity);

	/**
	 * @author Jake
	 *	Update details in a product order line
	 */
	public void updatePOL(CustomerOrderLine pol);
	
	

}
