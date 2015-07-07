package com.netbuilder.BlueGardensEESystem;

public class Customer {
	/**
	 * @author Jake
	 *	Attributes for customer including
	 *	unique ID for customer (int)
	 *	name, address, email and accountSTATUS are all Strings
	 *	contactNUM is string so that String operations can be applied
	 *	
	 */
	private int customerID;
	private String name;
	private String address;
	private String email;
	private String contactNUM;
	private String accountSTATUS;
	
	//Put new customer info into database
	private void Register()
	{
		
	}
	/*
	private bool CheckRegistration(int customer_id)
	{	
		//return true if customer is registered else false
		return false; 
	}*/
	/**
	 * @author Jake
	 *	Getters and Setter for class variables
	 *	
	 */
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNUM() {
		return contactNUM;
	}

	public void setContactNUM(String contactNUM) {
		this.contactNUM = contactNUM;
	}

	public String getAccountSTATUS() {
		return accountSTATUS;
	}

	public void setAccountSTATUS(String accountSTATUS) {
		this.accountSTATUS = accountSTATUS;
	}
	
	
	
	

}
