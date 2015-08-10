package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.netbuilder.entities.CustomerOrder;
import com.netbuilder.entities.CustomerOrderLine;
import com.netbuilder.entitymanagers.CustomerOrderLineManager;
import com.netbuilder.entitymanagers.CustomerOrderManager;
import com.netbuilder.entitymanagers.ProductManager;
import com.netbuilder.service.DisplayOrderLine;
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
	@Inject
	private CustomerOrderLineManager customerOrderLineManager;
	@Inject
	private ProductManager productManager;
	private ArrayList<DisplayOrderLine> displayOrderLines;
	private DisplayOrderLine currentDisplayOrderLine;
	private ArrayList<ArrayList<CustomerOrderLine>> customerOrderLines = new ArrayList<ArrayList<CustomerOrderLine>>();
	private ArrayList<CustomerOrderLine> currentCustomerOrderLine = new ArrayList<CustomerOrderLine>();
	private ArrayList<CustomerOrder> customerOrders = new ArrayList<CustomerOrder>();
	private int orderLineCount = 0;
	private int totalPrice;

	public ArrayList<CustomerOrder> getCustomerOrders() {
		return customerOrders;
	}

	public void setCustomerOrders(ArrayList<CustomerOrder> customerOrders) {
		this.customerOrders = customerOrders;
	}

	public TrackingController() {
	}

	public String search() {
		customerOrders = customerOrderManager.findByCustomer(loggedInUser
				.getUserID());
		for (int i = 0; i < customerOrders.size(); i++) {
			customerOrderLines.add(customerOrderLineManager
					.findByCustomerOrderID(customerOrders.get(i)
							.getCustomerOrderID()));
		}
		return "tracking";
	}

	public String customerOrderLineSearch() {
		totalPrice = 0;
		displayOrderLines = new ArrayList<DisplayOrderLine>();
		currentCustomerOrderLine = customerOrderLines.get(orderLineCount);
		for (int i = 0; i < currentCustomerOrderLine.size(); i++) {
			currentDisplayOrderLine = new DisplayOrderLine(
					productManager.findById(currentCustomerOrderLine.get(i)
							.getProductId()), currentCustomerOrderLine.get(i)
							.getQuantity());
			displayOrderLines.add(currentDisplayOrderLine);
		}
		for (int i = 0; i < displayOrderLines.size(); i++) {
			totalPrice += (displayOrderLines.get(i).getQuantity() * displayOrderLines
					.get(i).getProduct().getPrice());
		}
		// find product from id
		// store product as current customer order line product
		// print product instead of product ID
		orderLineCount++;
		return "tracking";
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public ArrayList<DisplayOrderLine> getDisplayOrderLines() {
		return displayOrderLines;
	}

	public void setDisplayOrderLines(
			ArrayList<DisplayOrderLine> displayOrderLines) {
		this.displayOrderLines = displayOrderLines;
	}

	public ArrayList<CustomerOrderLine> getCurrentCustomerOrderLine() {
		return currentCustomerOrderLine;
	}

	public void setCurrentCustomerOrderLine(
			ArrayList<CustomerOrderLine> currentCustomerOrderLine) {
		this.currentCustomerOrderLine = currentCustomerOrderLine;
	}

	public ArrayList<ArrayList<CustomerOrderLine>> getCustomerOrderLines() {
		return customerOrderLines;
	}

	public void setCustomerOrderLines(
			ArrayList<ArrayList<CustomerOrderLine>> customerOrderLines) {
		this.customerOrderLines = customerOrderLines;
	}

}
