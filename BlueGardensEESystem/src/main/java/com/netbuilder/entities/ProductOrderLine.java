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
 * @author Jake
 * Product Order Line entity
 */
@Entity
@Table(name = "Product Order Line")
@NamedQueries
({
	//@NamedQuery(name = Customer.FIND_BY_NAME , query = "SELECT * FROM Customer c"),
	@NamedQuery(name = ProductOrderLine.FIND_BY_POL_ID, query = "SELECT c FROM ProductOrderLine c"),
	@NamedQuery(name = ProductOrderLine.FIND_BY_CUSTOMER_ID, query = "SELECT c FROM ProductOrderLine c WHERE CUSTOMER ID = 1")

})
public class ProductOrderLine 
{	
	public static final String FIND_BY_POL_ID = "ProductOrderLine.findByPOLID";
	public static final String FIND_BY_CUSTOMER_ID = "ProductOrderLine.findByCID";
	/**
	 * @author Jake
	 * Attributes of the Product Order Line
	 * including unique identifier and the quantity of the products 
	 */
	
	/**
	 * Product Order Line ID is the primary key for the this table
	 */
	@Id
	@Column(name = "POLID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int productOrderLineID;
	
	/**
	 *  Product ID will be linked to the product entity, not null
	 */
	@Column(name = "Product ID", nullable = false)
	@NotNull
	private int productID;
	
	/**
	 * Quantity cannot be null as at least one product must be in the order line
	 */
	@Column(name = "Quantity", nullable = false)
	@NotNull
	private int quantity;
	
	
	public ProductOrderLine(int productOrderLineID, int productID, int quantity) 
	{
		this.productOrderLineID = productOrderLineID;
		this.productID = productID;
		this.quantity = quantity;
	}
	/**
	 * @author Jake
	 *	Getters and Setters for class variables
	 *	Initialise class
	 */
	public int getProductOrderLineID() {
		return productOrderLineID;
	}
	public void setProductOrderLineID(int productOrderLineID) {
		this.productOrderLineID = productOrderLineID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
