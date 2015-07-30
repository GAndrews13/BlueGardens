package com.netbuilder.entitymanagers;
/**
 * @author Jake
 *	Entity manager for the product order line
 */
import java.util.ArrayList;

import com.netbuilder.entities.ProductOrderLine;

public interface ProductOrderLineManager 
{
	/**
	 * @author Jake
	 *	Add a new product order line into the system
	 */
	public void persistPOL(ProductOrderLine pol);
	
	/**
	 * @author Jake
	 *	Find a product order line by its ID
	 */
	public ProductOrderLine findByPOLID(int pol_ID);
	
	/**
	 * @author Jake
	 *	Find a product order line by the customer ID
	 */
	public ProductOrderLine findByCID(int customerID);
	
	/**
	 * @author Jake
	 *	Find all product order lines above a certain quantity
	 */
	public ArrayList<ProductOrderLine> findByQuantity(int quantity);

	/**
	 * @author Jake
	 *	Update details in a product order line
	 */
	public void updatePOL(ProductOrderLine pol);
	
	/**
	 * @author Jake
	 *	Return all product order lines
	 */
	public ArrayList <ProductOrderLine> findall();
	

}
