package com.netbuilder.BlueGardensEESystem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author jmander
 * 
 * Contains information regarding the customer, what they ordered, if a worker has been assigned to check out the stock,
 * the type of delivery (first class etc.) that the customer has requested and a means of tracking the differing states of the order  
 *
 **/

@Entity
@Table (name = "Customer Order")
/*@NamedQueries ({@NamedQuery (name = Customer.FIND_BY_NAME, query = "SELECT customerID FROM Customer customerID where customerID.Customer = :name"),
	@NamedQuery (name = ProductOrderLine.FIND_BY_NAME, query = "SELECT POLID FROM ProductOrderLine POLID where POLID.ProductOrderLine = :name"),
	@NamedQuery (name = WarehouseWorker.FIND_BY_NAME, query = "SELECT WorkerID FROM WarehouseWorker WorkerID where WorkerID.WarehouseWorker = :name"),})*/
public class CustomerOrder {
	
	
	public CustomerOrder(){
		
	}
	
	
	public CustomerOrder(boolean isAssigned, int trackingID,
			String deliveryType, Customer customer, ProductOrderLine productOrderLine,
			WarehouseWorker worker) {
		this.isAssigned = isAssigned;
		this.trackingID = trackingID;
		this.deliveryType = deliveryType;
		this.customer = customer;
		this.productOrderLine = productOrderLine;
		this.worker = worker;
	}



	@Id
	@Column (name = "COID", nullable = false)
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerOrderID;
	
	@Column (name = "Is_Assigned", nullable = false)
	@NotNull
	private boolean isAssigned;
	
	@Column (name = "Tracking ID", nullable = false)
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trackingID;
	
	@Column (name = "Delivery_Type", nullable = false, length = 45)
	@NotNull
	@Size(min = 3, max = 45)
	private String deliveryType;
	
	@ManyToOne
	@JoinColumn(name ="Customer ID", nullable = false)
	@NotNull
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name ="POLID", nullable = false)
	@NotNull
	private ProductOrderLine productOrderLine;
	
	@ManyToOne
	@JoinColumn(name ="WorkerID", nullable = false)
	@NotNull
	private WarehouseWorker worker;
	
	public int getCustomerOrderID() {
		return customerOrderID;
	}

	
	public boolean getIsAssigned() {
		return isAssigned;
	}
	public void setIsAssigned(boolean isAssigned) {
		this.isAssigned = isAssigned;
	}
	
	
	public int getTrackingID() {
		return trackingID;
	}

	
	public String getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public ProductOrderLine getProductOrderLine() {
		return productOrderLine;
	}
	
	public WarehouseWorker getWorker() {
		return worker;
	}
}