package com.netbuilder.entities;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	@OneToMany
	@Column(name = "POLID", nullable = false)
	@NotNull
	private ArrayList<ProductOrderLine> pol;
	@Column(name = "DeliveryLocation", nullable = false)
	@NotNull
	private DeliveryLocation loc;
	@Column(name = "SupplierID", nullable = false)
	@NotNull
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
	
	/**
	 * @author David
	 * 
	 * @param p the ProductOrderLine object to be added to the collection pol
	 */
	public void addProductOrderLine(ProductOrderLine p)
	{
		pol.add(p);
	}
	
	/**
	 * @author David Ogbonnah
	 * 
	 * @return An array list collection of all the Product Order Lines added 
	 * to the current Purchase Order
	 */
	public ArrayList<ProductOrderLine> getProductOrderLines()
	{
		return pol;
	}
	
	/**
	 * @author David Ogbonnah
	 * @param s returns
	 */
	public void Supplier(Supplier s)
	{
		supp = s;
	}
	
	public Supplier getSupplier()
	{
		return supp;
	}
	
}
