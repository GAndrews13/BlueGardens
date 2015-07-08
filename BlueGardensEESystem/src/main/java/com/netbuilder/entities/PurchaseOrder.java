package com.netbuilder.entities;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "nbgblue")

/**
 * @author David Ogbonnah
 * This entity is used for generating an purchase order
 **/
public class PurchaseOrder {

	@Id
	@Column(name = "POID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int id;
	private ArrayList<ProductOrderLine> pol;
	private DeliveryLocation loc;
	private Supplier supp;
	
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
