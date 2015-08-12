package com.netbuilder.model;


import com.netbuilder.model.DeliveryStatus;

/**
 * 
 * @author jmander
 * 
 *         Contains information regarding the customer, what they ordered, if a
 *         worker has been assigned to check out the stock, the type of delivery
 *         (first class etc.) that the customer has requested and a means of
 *         tracking the differing states of the order
 *
 **/
public class CustomerOrder {

	public static final String FIND_BY_CUSTOMER_ORDER_ID = "CustomerOrder.findByCustomerOrderId";
	public static final String FIND_BY_ASSIGNED = "CustomerOrder.findByAssigned";
	public static final String FIND_BY_TRACKING_ID = "CustomerOrder.findByTrackingId";
	public static final String FIND_BY_DELIVERY_TYPE = "CustomerOrder.findByDeliveryType";
	public static final String FIND_BY_CUSTOMER = "CustomerOrder.findByCustomer";
	public static final String FIND_BY_WORKER = "CustomerOrder.findByWorker";

	public CustomerOrder() {

	}

	public CustomerOrder(boolean isAssigned, String deliveryType,
			long customerID, long workerID, DeliveryStatus status, double price) {
		this.isAssigned = isAssigned;
		this.deliveryType = deliveryType;
		this.customerID = customerID;
		this.workerID = workerID;
		this.status = status;
		this.price = price;
	}

	public CustomerOrder(int customerOrderID, boolean isAssigned,
			int trackingID, String deliveryType, long customerID,
			long workerID, DeliveryStatus status, double price) {
		this.customerOrderID = customerOrderID;
		this.isAssigned = isAssigned;
		this.trackingID = trackingID;
		this.deliveryType = deliveryType;
		this.customerID = customerID;
		this.workerID = workerID;
		this.status = status;
		this.price = price;
	}

	private int customerOrderID;

	private boolean isAssigned;

	private int trackingID;

	private String deliveryType;

	private long customerID;
	
	private long workerID;

	private DeliveryStatus status;
	
	private double price;

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

	public long getCustomer() {
		return customerID;
	}

	public void setWorker(WarehouseWorker worker) {
		this.setWorker(worker);
	}

	public long getWorker() {
		return workerID;
	}

	public DeliveryStatus getStatus() {
		return status;
	}

	public void setStatus(DeliveryStatus status) {
		this.status = status;
	}

	public double getPrice() {
		return Math.round(price);
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}