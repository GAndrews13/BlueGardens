package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;

import com.netbuilder.entities.CustomerOrderLine;
import com.netbuilder.entitymanagers.CustomerOrderLineManager;
/**
 * @author Jake
 *	Dummy class for testing the product order line
 */
public class ProductOrderLineManagerDummy implements CustomerOrderLineManager 
{
	/**
	 * @author Jake
	 *	product order line array instead of a database
	 *  Create a new product order line
	 */
	ArrayList<CustomerOrderLine> pol_Array = new ArrayList<CustomerOrderLine>();
	public void persistPOL(CustomerOrderLine pol)
	{
		pol_Array.add(pol);
	}
	
	/**
	 * @author Jake
	 *	Find a product order line using its ID
	 */
	public CustomerOrderLine findByPOLID(int pol_ID)
	{
		for(CustomerOrderLine p : pol_Array)
		{
			if(p.getProductOrderLineID() == pol_ID)
			{
				return p;
			}
		}
		return null;
	}
	
	/**
	 * @author Jake
	 *	Find a product order line using the product ID
	 */
	public CustomerOrderLine findByCID(int productID)
	{
		for(CustomerOrderLine p : pol_Array)
		{
			if(p.getProductID() == productID)
			{
				return p;
			}
		}
		return null;
	}
	
	/**
	 * @author Jake
	 *	Return array of product order lines that are below a certain quantity
	 */
	public ArrayList<CustomerOrderLine> findByQuantity(int quantity)
	{
		ArrayList<CustomerOrderLine> localLine = new ArrayList<CustomerOrderLine>();
			for(CustomerOrderLine p : pol_Array)
			{
				if(p.getQuantity() <= quantity)
				{
					localLine.add(p);
				}
			}
			return localLine;
	}
	
	/**
	 * @author Jake
	 *	Edit product order line with new information 
	 */
	public void updatePOL(CustomerOrderLine pol)
	{
		pol_Array.set(pol_Array.indexOf(pol), pol);
	}
}
