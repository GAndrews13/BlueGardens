package com.netbuilder.BlueGardensEESystem;

/**
 * 
 * @author jmander
 * 
 * Contains information regarding the customer, what they ordered, if a worker has been assigned to check out the stock,
 * the type of delivery (first class etc.) that the customer has requested and a means of tracking the differing states of the order  
 *
 **/
public class CustomerOrder {
	
	private int customerOrderID;
	private boolean isAssigned;
	private int trackingID;
	private String deliveryType;
	private int customerID;
	private int productOrderLineID;
	private int workerID;
	
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
	
	public int getCustomerID() {
		return customerID;
	}
	
	public int getProductOrderLineID() {
		return productOrderLineID;
	}
	
	
	public int getWorkerID() {
		return workerID;
	}


}
