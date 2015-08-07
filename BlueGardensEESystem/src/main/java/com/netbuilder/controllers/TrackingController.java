package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.netbuilder.entities.CustomerOrder;
import com.netbuilder.entities.CustomerOrderLine;
import com.netbuilder.entitymanagers.CustomerOrderLineManager;
import com.netbuilder.entitymanagers.CustomerOrderManager;
import com.netbuilder.util.LoggedInUser;

/**
 * @author jmander
 * **/

@ManagedBean(name = "trackingController")
@RequestScoped
public class TrackingController {
	@Inject
	private CustomerOrderManager customerOrderManager;
	@Inject
	private LoggedInUser loggedInUser;
	//@Inject
	//private CustomerOrderLineManager customerOrderLineManager;
	private ArrayList<ArrayList<CustomerOrderLine>> customerOrderLines = new ArrayList<ArrayList<CustomerOrderLine>>();
	private ArrayList<CustomerOrder> customerOrders = new ArrayList<CustomerOrder>();
	
	public ArrayList<CustomerOrder> getCustomerOrders() {
		return customerOrders;
	}

	public void setCustomerOrders(ArrayList<CustomerOrder> customerOrders) {
		this.customerOrders = customerOrders;
	}
	
	
	public TrackingController(){
	} 
	
	public String search() {
		customerOrders = customerOrderManager.findByCustomer(loggedInUser.getUserID());
		/*for(CustomerOrder co : customerOrders){
			if(co.getCustomerOrderID() == ){
				
			}
		}*/
		return "tracking";
	}
	
}
