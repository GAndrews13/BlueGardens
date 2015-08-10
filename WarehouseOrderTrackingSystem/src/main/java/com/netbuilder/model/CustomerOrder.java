package com.netbuilder.model;

import java.util.ArrayList;

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

	private int customerOrderID;

	private boolean isAssigned;

	private int trackingID;

	private String deliveryType;

	private Customer customer;

	private ArrayList<ProductOrderLine> productOrderLine;

	private WarehouseWorker worker;

	private DeliveryStatus status;

	public CustomerOrder() {

	}

	public CustomerOrder(int trackingID, Customer customer,
			ArrayList<ProductOrderLine> productOrderLine) {
		this.trackingID = trackingID;
		this.customer = customer;
		this.productOrderLine = productOrderLine;
	}

	public CustomerOrder(boolean isAssigned, int trackingID,
			String deliveryType, Customer customer,
			ArrayList<ProductOrderLine> productOrderLine,
			WarehouseWorker worker, DeliveryStatus status) {
		this.isAssigned = isAssigned;
		this.trackingID = trackingID;
		this.deliveryType = deliveryType;
		this.customer = customer;
		this.productOrderLine = productOrderLine;
		this.worker = worker;
		this.status = status;
	}

	public CustomerOrder(Customer inCustomer,
			ArrayList<ProductOrderLine> inProductOrderLines) {
		this.isAssigned = false;
		this.worker = null;
		this.deliveryType = null;

		this.customer = inCustomer;
		this.productOrderLine = inProductOrderLines;
		this.status = DeliveryStatus.ORDER_PLACED;
	}

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

	public ArrayList<ProductOrderLine> getProductOrderLines() {
		return productOrderLine;
	}

	public void addProductOrderLine(ProductOrderLine p) {
		productOrderLine.add(p);
	}

	public void setWorker(WarehouseWorker worker) {
		this.setWorker(worker);
	}

	public WarehouseWorker getWorker() {
		return worker;
	}

	public DeliveryStatus getStatus() {
		return status;
	}

	public void setStatus(DeliveryStatus status) {
		this.status = status;
	}

}