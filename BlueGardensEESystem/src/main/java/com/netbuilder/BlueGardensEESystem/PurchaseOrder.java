package com.netbuilder.BlueGardensEESystem;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "nbgblue")

/**
 * @author David Ogbonnah
 * This entity is used for generating an purchase order
 **/
public class PurchaseOrder {

	private int id;
	private ArrayList<ProductOrderLine> pol;
	private DeliveryLocation
	public Supplier supp;
	
	/**
	 * This is the preferred constructor implementation as it forces us to specify all of the values that are not nullable
	 * @param id A unique id for the supplier
	 * @param name The name of the supplier
	 */
	public PurchaseOrder(String id, String name)
	{
		pol = new ArrayList<ProductOrderLine>();
		supp = new Supplier(id, name);
	}
	
	public void addProductOrderLine(ProductOrderLine p)
	{
		pol.add(p);
	}
	
	public ArrayList<ProductOrderLine> getProductOrderLines()
	{
		return pol;
	}
	public ProductOrderLine getProductOrderLine(ProductOrderLine p)
	{
		int i = 0;
	    ProductOrderLine polInstance = null;
	    while (i < pol.size())
	    {
	    	polInstance = pol.get(i);
	    	if(polInstance.equals(p))
	    	{
	    		return p;
	    	}
	    	
	    	i++;
	    }
	    
	    return null;
	}
	
	public void Supplier(Supplier s)
	{
		supp = s;
	}
	
	public Supplier getSupplier()
	{
		return supp;
	}
	
}
