package com.netbuilder.entities;

import java.util.ArrayList;

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
@NamedQueries ({@NamedQuery (name = CustomerOrder.FIND_BY_CUSTOMER_ORDER_ID, query = "SELECT co FROM CustomerOrder co WHERE co.customerOrderID = :id"),
	@NamedQuery (name = CustomerOrder.FIND_BY_ASSIGNED, query = "SELECT co FROM CustomerOrder co WHERE co.isAssigned = :assigned"),
	@NamedQuery (name = CustomerOrder.FIND_BY_TRACKING_ID, query = "SELECT co FROM CustomerOrder co WHERE co.trackingID = :id"),
	@NamedQuery (name = CustomerOrder.FIND_BY_DELIVERY_TYPE, query = "SELECT co FROM CustomerOrder co WHERE co.DeliveryType = :deliveryType"),
	@NamedQuery (name = CustomerOrder.FIND_BY_CUSTOMER, query = "SELECT co FROM CustomerOrder co WHERE co.customer = :customer"),
	@NamedQuery (name = CustomerOrder.FIND_BY_WORKER, query = "SELECT co FROM CustomerOrder co WHERE co.worker = :worker")})
public class CustomerOrder {
	
	public static final String FIND_BY_CUSTOMER_ORDER_ID = "CustomerOrder.findByCustomerOrderId";
	public static final String FIND_BY_ASSIGNED = "CustomerOrder.findByAssigned";
	public static final String FIND_BY_TRACKING_ID = "CustomerOrder.findByTrackingId";
	public static final String FIND_BY_DELIVERY_TYPE = "CustomerOrder.findByDeliveryType";
	public static final String FIND_BY_CUSTOMER = "CustomerOrder.findByCustomer";
	public static final String FIND_BY_WORKER = "CustomerOrder.findByWorker";
	
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