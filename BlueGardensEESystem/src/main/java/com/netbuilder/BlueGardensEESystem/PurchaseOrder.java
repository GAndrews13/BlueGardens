package com.netbuilder.BlueGardensEESystem;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "nbgblue")

/**
 * @author David Ogbonnah
 **/
public class PurchaseOrder {

	
	private ArrayList<ProductOrderLine> pol;
	public Supplier supp;
	
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
