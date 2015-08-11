package com.netbuilder.entitymanagers;

import java.util.ArrayList;

import com.netbuilder.BlueGardensEESystem.DeliveryStatus;
import com.netbuilder.entities.CustomerOrder;

/**
 * 
 * @author jmander
 * 
 *         Entity manager for Customer Orders
 *
 **/

public interface CustomerOrderManager {

	public void persistCustomerOrder(CustomerOrder customerOrder);

	public void persistCustomerOrders(ArrayList<CustomerOrder> customerOrders);

	public void updateCustomerOrder(CustomerOrder customerOrder);
	
	public ArrayList<CustomerOrder> findAll();

	public CustomerOrder findByCustomerOrderId(int customerOrderId); // any ID

	public ArrayList<CustomerOrder> findByisAssigned(boolean isAssigned);

	public CustomerOrder findByTrackingId(int trackingId);

	public ArrayList<CustomerOrder> findByDeliveryType(String deliveryType);

	public ArrayList<CustomerOrder> findByCustomer(long customerID);

	public ArrayList<CustomerOrder> findByWorker(long workerID);

	public ArrayList<CustomerOrder> findByDeliveryStatus(DeliveryStatus status);

}