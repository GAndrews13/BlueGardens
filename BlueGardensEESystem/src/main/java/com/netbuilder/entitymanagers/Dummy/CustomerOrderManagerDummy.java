package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;

import com.netbuilder.BlueGardensEESystem.DeliveryStatus;
import com.netbuilder.entities.Customer;
import com.netbuilder.entities.CustomerOrder;
import com.netbuilder.entities.WarehouseWorker;
import com.netbuilder.entitymanagers.CustomerOrderManager;

/**
* 
 * @author jmander
* 
 * Customer Order Manager with dummy data
*
**/
@Alternative
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
       
       public CustomerOrder findByCustomerOrderId(int customerOrderId){
   		for(CustomerOrder co : customerOrders)
   		{
   			if(co.getCustomerOrderID() == customerOrderId )
   			{
   				return co;
   			}
   		}
              return null;
       };
       
       public ArrayList<CustomerOrder> findByisAssigned(boolean isAssigned){
    	   ArrayList<CustomerOrder> list = new ArrayList<CustomerOrder>();
    	   for(CustomerOrder co : customerOrders)
      		{
      			if(co.getIsAssigned() == isAssigned)
      			{
      				list.add(co);
      			}
      		}
    	   return list;
       }
       
       public CustomerOrder findByTrackingId(int trackingId){
      		for(CustomerOrder co : customerOrders)
       		{
       			if(co.getTrackingID() == trackingId )
       			{
       				return co;
       			}
       		}
      		return null;
       };
       public ArrayList<CustomerOrder> findByDeliveryType(String deliveryType){
      		ArrayList<CustomerOrder> list = new ArrayList<CustomerOrder>();
       		for(CustomerOrder co : customerOrders)
       		{
       			if(co.getDeliveryType() == deliveryType)
       			{
       				list.add(co);
       			}
       		}
       		return list;
       };
       public ArrayList<CustomerOrder> findByCustomer(Customer customer){
      		ArrayList<CustomerOrder> list = new ArrayList<CustomerOrder>();
       		for(CustomerOrder co : customerOrders)
       		{
       			if(co.getCustomer() == customer)
       			{
       				list.add(co);
       			}
       		}
       		return list;
       };
       public ArrayList<CustomerOrder> findByWorker(WarehouseWorker worker){
      		ArrayList<CustomerOrder> list = new ArrayList<CustomerOrder>();
       		for(CustomerOrder co : customerOrders)
       		{
       			if(co.getWorker() == worker)
       			{
       				list.add(co);
       			}
       		}
       		return list;
       };
       
       public ArrayList<CustomerOrder> findByDeliveryStatus(DeliveryStatus status){
     		ArrayList<CustomerOrder> list = new ArrayList<CustomerOrder>();
       		for(CustomerOrder co : customerOrders)
       		{
       			if(co.getStatus() == status)
       			{
       				list.add(co);
       			}
       		}
       		return list;
       }
       
}