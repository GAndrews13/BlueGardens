package com.netbuilder.entitymanagers;

import java.util.ArrayList;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.CustomerOrder;
import com.netbuilder.entities.WarehouseWorker;

/**
* 
 * @author jmander
* 
 * Customer Order Manager with dummy data
*
**/

public class CustomerOrderManagerDummy implements CustomerOrderManager {
       ArrayList<CustomerOrder> customerOrders = new ArrayList<CustomerOrder>();

       public void persistCustomerOrder(CustomerOrder customerOrder){
              customerOrders.add(customerOrder);
       };
       public void persistCustomerOrders(ArrayList<CustomerOrder> customerOrders){
              this.customerOrders.addAll(customerOrders);
       };
       
       public void updateCustomerOrder(CustomerOrder customerOrder){
              customerOrders.set(customerOrders.indexOf(customerOrder), customerOrder);
       };
       
       public CustomerOrder findByCustomerOrderId(int CustomerOrderId){
              return null;
       };  //any ID
       public CustomerOrder findByisAssigned(boolean isAssigned){
              return null;
       };
       public CustomerOrder findByTrackingId(int TrackingId){
              return null;
       };
       public CustomerOrder findByDeliveryType(String DeliveryType){
              return null;
       };
       public CustomerOrder findByCustomer(Customer customer){
              return null;
       };
       public CustomerOrder findByWorker(WarehouseWorker worker){
              return null;
       };
       
}