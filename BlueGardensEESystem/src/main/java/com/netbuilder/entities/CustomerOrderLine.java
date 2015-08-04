package com.netbuilder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Jake
 *	Customer Order Line Entity
 */
@Entity
@Table(name = "CustomerOrderLine")
@NamedQueries
({
	@NamedQuery(name = CustomerOrderLine.FIND_BY_CO_ID, query = "SELECT * FROM CustomerOrderLine where COID = :id"),
	@NamedQuery(name = CustomerOrderLine.FIND_BY_PRODUCT_ID, query = "SELECT c FROM CustomerOrderLine c WHERE CUSTOMER ID = :productid")
})
public class CustomerOrderLine 
{
	public static final String FIND_BY_CO_ID = "CustomerOrderLine.findByCOID";
	public static final String FIND_BY_PRODUCT_ID = "CustomerOrderLine.findByPID";
	
	/**
	 * Customer Order Line ID is the primary key for the this table
	 */
	@Id
	@Column(name = "COID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int CustomerOrderLineID;
	
	/**
	 *  Product ID will be linked to the product entity
	 */
	@Column(name = "ProductID", nullable = false)
	private int productId;
	
	/**
	 * Quantity cannot be null as at least one product must be in the order line
	 */
	@Column(name = "Quantity", nullable = false)
	@NotNull
	private int quantity;
	
	public CustomerOrderLine(int productID, int Quantity)
	{
		this.productId = productID;
		this.quantity = Quantity;
	}
	/**
	 * @author Jake
	 *	Getters and Setters for class variables
	 *	Initialise class
	 */
	public int getCustomerOrderLineID() {
		return CustomerOrderLineID;
	}

	public void setCustomerOrderLineID(int customerOrderLineID) {
		CustomerOrderLineID = customerOrderLineID;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
