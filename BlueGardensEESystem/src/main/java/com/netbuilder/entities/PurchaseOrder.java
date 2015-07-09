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
	 * @param name A name for the supplier of the purchase order
	 * @param address The address of the supplier
	 */
	public PurchaseOrder(String name, String address)
	{
		pol = new ArrayList<ProductOrderLine>();
		supp = new Supplier(name, address);
	}
	
	/**
	 * @author David Ogbonnah
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
	 * @param s changes the supplier for the purchase order
	 */
	public void Supplier(Supplier s)
	{
		supp = s;
	}
	
	public Supplier getSupplier()
	{
		return supp;
	}
	
	public int getID()
	{
		return id;
	}
	
	public void setID(int id)
	{
		this.id = id; 
	}
	
	public DeliveryLocation getDeliveryLocation()
	{
		return loc;
	}
	
	public void setDeliveryLocation(DeliveryLocation dl)
	{
		loc = dl;
	}
}
