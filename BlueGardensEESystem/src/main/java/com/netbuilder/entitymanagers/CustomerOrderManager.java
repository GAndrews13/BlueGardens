package com.netbuilder.entitymanagers;

import java.util.ArrayList;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.CustomerOrder;
import com.netbuilder.entities.WarehouseWorker;

/**
* 
 * @author jmander
* 
 * Entity manager for Customer Orders
*
**/

public interface CustomerOrderManager {

       public void persistCustomerOrder(CustomerOrder customerOrder);
       public void persistCustomerOrders(ArrayList<CustomerOrder> customerOrders);
       
       public void updateCustomerOrder(CustomerOrder customerOrder);
       
       public CustomerOrder findByCustomerOrderId(int CustomerOrderId);  //any ID
       public CustomerOrder findByisAssigned(boolean isAssigned);
       public CustomerOrder findByTrackingId(int TrackingId);
       public CustomerOrder findByDeliveryType(String DeliveryType);
       public CustomerOrder findByCustomer(Customer customer);
       public CustomerOrder findByWorker(WarehouseWorker worker);
       
}