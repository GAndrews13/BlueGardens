package com.netbuilder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.netbuilder.controller.ProductManager;
import com.netbuilder.controller.Dummy.ProductManagerDummy;

/**
 *  
 * @author Jake Customer Order Line Entity
 */
@Entity
@Table(name = "CustomerOrderLine")
@NamedQueries({
		@NamedQuery(name = CustomerOrderLine.FIND_BY_CO_ID, query = "SELECT * FROM CustomerOrderLine where COID = :id"),
		@NamedQuery(name = CustomerOrderLine.FIND_BY_QUANTITY, query = "SELECT * FROM CustomerOrderLine where QUANTITY = quantity"),
		@NamedQuery(name = CustomerOrderLine.FIND_BY_PRODUCT_ID, query = "SELECT c FROM CustomerOrderLine c WHERE CUSTOMER ID = :productid") })
public class CustomerOrderLine {
	public static final String FIND_BY_CO_ID = "CustomerOrderLine.findByCOID";
	public static final String FIND_BY_PRODUCT_ID = "CustomerOrderLine.findByPID";
	public static final String FIND_BY_QUANTITY = "CustomerOrderLine.findByQUANTITY";

	/**
	 * Customer Order Line ID is the primary key for the this table
	 */
	@Id
	@Column(name = "COID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int CustomerOrderID;

	/**
	 * Product ID will be linked to the product entity
	 */
	@Column(name = "ProductID", nullable = false)
	private int productId;

	/**
	 * Quantity cannot be null as at least one product must be in the order line
	 */
	@Column(name = "Quantity", nullable = false)
	@NotNull
	private int quantity;

	/**
	 * Quantity cannot be null as at least one product must be in the order line
	 */
	@Column(name = "IsPicked", nullable = false)
	@NotNull
	private boolean isPicked;

	public CustomerOrderLine(int productID, int Quantity) {
		this.productId = productID;
		this.quantity = Quantity;
	}

	public CustomerOrderLine(int customerOrderID, int productId, int quantity,
			boolean isPicked) {
		CustomerOrderID = customerOrderID;
		this.productId = productId;
		this.quantity = quantity;
		this.isPicked = isPicked;
	}

	/**
	 * @author Jake Getters and Setters for class variables Initialise class
	 */
	public int getCustomerOrderID() {
		return CustomerOrderID;
	}

	public void setCustomerOrderID(int customerOrderID) {
		CustomerOrderID = customerOrderID;
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

	public void setIsPicked(boolean picked) {
		isPicked = picked;
	}

	public boolean getIsPicked() {
		return isPicked;
	}
	
	/**
	 * @author GAndrews
	 */
	public Product getProduct()
	{
		ProductManager pm = new ProductManagerDummy();
		return pm.findById(getProductId());
	}
	
	/**
	 * Returns the total cost of the product order line (quantity * product cost) 
	 * @return
	 */
	public double getTotalCost()
	{
		ProductManager pm = new ProductManagerDummy();
		Product p = pm.findById(getProductId()); 
		return p.getPrice() * getQuantity(); 
	}
}
