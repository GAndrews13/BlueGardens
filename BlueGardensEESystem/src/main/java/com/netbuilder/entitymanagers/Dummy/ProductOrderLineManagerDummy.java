package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;

import com.netbuilder.entities.ProductOrderLine;
import com.netbuilder.entitymanagers.ProductOrderLineManager;
/**
 * @author Jake
 *	Dummy class for testing the product order line
 */
@Alternative
public class ProductOrderLineManagerDummy implements ProductOrderLineManager 
{
	/**
	 * @author Jake
	 *	product order line array instead of a database
	 *  Create a new product order line
	 */
	ArrayList<ProductOrderLine> pol_Array = new ArrayList<ProductOrderLine>();
	public void persistPOL(ProductOrderLine pol)
	{
		pol_Array.add(pol);
	}
	
	/**
	 * @author Jake
	 *	Find a product order line using its ID
	 */
	public ProductOrderLine findByPOLID(int pol_ID)
	{
		for(ProductOrderLine p : pol_Array)
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
	public ProductOrderLine findByCID(int productID)
	{
		for(ProductOrderLine p : pol_Array)
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
	public ArrayList<ProductOrderLine> findByQuantity(int quantity)
	{
		ArrayList<ProductOrderLine> localLine = new ArrayList<ProductOrderLine>();
			for(ProductOrderLine p : pol_Array)
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
	public void updatePOL(ProductOrderLine pol)
	{
		pol_Array.set(pol_Array.indexOf(pol), pol);
	}
	
	/**
	 * @author Jake
	 *	Return all product order lines
	 */
	public ArrayList <ProductOrderLine> findall()
	{
		return pol_Array;
	}
}
