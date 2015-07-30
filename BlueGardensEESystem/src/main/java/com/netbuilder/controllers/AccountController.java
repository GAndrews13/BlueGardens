package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import com.netbuilder.entities.CustomerOrder;

@Named
@RequestScoped
public class AccountController 
{
	
	private String firstName;
	private String LastName;
	private String address;
	private String contactNumber;
	private String email;
	private ArrayList<CustomerOrder> orders = new ArrayList<CustomerOrder>();
	
	public ArrayList<CustomerOrder> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<CustomerOrder> orders) {
		this.orders = orders;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
/*
	public String showCustomerDetails()
	{
		String line1 = cust.getFirstName() + " " + cust.getLastName();
		String line2 = cust.getAddress();
		String line3 = cust.getContactNUM();
		String line4 = cust.getEmail();
		return line1 + "/r/r" + line2 + "/r/r" + line3 + "/r/r" + line4 + "/r/r"; 
	}
	
	public String showOrders()
	{
		String orderList = null;
		ArrayList<CustomerOrder> list = com.findByCustomer(cust);
		for(CustomerOrder co: list)
		{
			ArrayList<ProductOrderLine> polList = co.getProductOrderLines();
			for(ProductOrderLine pol : polList)
			{
				orderList += pol.getProductID() + "/t/t/t/t" + pol.getQuantity() + "/r/r";
			}
		}
		return orderList;
	}
*/
	
}
