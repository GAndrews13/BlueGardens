package com.netbuilder.entitymanagers;

import java.util.ArrayList;

import com.netbuilder.BlueGardensEESystem.DeliveryStatus;
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
       
       public CustomerOrder findByCustomerOrderId(int customerOrderId);  //any ID
       public ArrayList<CustomerOrder> findByisAssigned(boolean isAssigned);
       public CustomerOrder findByTrackingId(int trackingId);
       public ArrayList<CustomerOrder> findByDeliveryType(String deliveryType);
       public ArrayList<CustomerOrder> findByCustomer(Customer customer);
       public ArrayList<CustomerOrder> findByWorker(WarehouseWorker worker);
       public ArrayList<CustomerOrder> findByDeliveryStatus(DeliveryStatus status);
              
}