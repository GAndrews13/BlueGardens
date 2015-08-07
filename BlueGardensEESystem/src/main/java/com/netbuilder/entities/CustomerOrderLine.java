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
	
	@Id
	@Column(name = "COID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int CustomerOrderID;
	
	@Column(name = "ProductID", nullable = false)
	private int productId;
	
	@Column(name = "Quantity", nullable = false)
	@NotNull
	private int quantity;
	
	@Column(name = "IsPicked", nullable = false)
	@NotNull
	private boolean isPicked;
	
	public CustomerOrderLine(int productID, int Quantity) {
		this.productId = productID;
		this.quantity = Quantity;
	}

	public int getCustomerOrderLineID() { return CustomerOrderID; }
	public int getProductId() { return productId; }
	public int getQuantity() { return quantity; }
	public boolean getIsPicked() { return isPicked; }	
	public void setCustomerOrderLineID(int customerOrderID) { CustomerOrderID = customerOrderID; }
	public void setProductId(int productId) { this.productId = productId; }
	public void setQuantity(int quantity) {this.quantity = quantity; }
	public void setIsPicked(boolean picked) { isPicked = picked; }	
}