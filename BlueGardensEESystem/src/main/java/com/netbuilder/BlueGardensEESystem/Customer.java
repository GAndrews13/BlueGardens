package com.netbuilder.BlueGardensEESystem;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;;

@Entity
@Table(name = "Customer")
@NamedQueries
({
	@NamedQuery(name = Customer.FIND_BY_OUT_STOCK, query = "SELECT c FROM Customer c WHERE c.name = Jake")
})
public class Customer 
{
	public static final String FIND_BY_OUT_STOCK = "Customer.findByOutStock";
	/**
	 * @author Jake
	 *	Attributes for customer including
	 *	unique ID for customer (int)
	 *	name, address, email and accountSTATUS are all Strings
	 *	contactNUM is string so that String operations can be applied
	 *	
	 */
	
	/**
	 * Customer ID will be the primary key in the customer table/ NOT NULL 
	 */
	@Id
	@Column(name = "customerID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int customerID;
	
	/**
	 * Name represents the customer name in the table, cannot be null
	 */
	@Column(name = "Name", nullable = false, length = 127)
	@NotNull
	@Size(min = 2, max = 127)
	private String name;
	
	/**
	 * Address represents the customer address, length may need to be longer
	 */
	@Column(name = "Address", nullable = false, length = 45)
	@NotNull
	@Size(min = 5, max = 45)
	private String address;
	
	/**
	 * Email can be an optional field to enter, i.e can be null
	 */
	@Column(name = "Email", nullable = true, length = 45)
	@Size(min = 4, max = 45)
	private String email;
	
	/**
	 * Contact number for the customer, cannot be null 
	 */
	@Column(name = "Contact Number", nullable = false, length = 45)
	@NotNull
	@Size(min = 10, max = 45)
	private String contactNUM;
	
	/**
	 * Account status cannot be null but can have a value like N/A for not active 
	 */
	@Column(name = "Account Status", nullable = false, length = 45)
	@NotNull
	@Size(min = 2, max = 45)
	private String accountSTATUS;
	
	/**
	 * Initialize customer so instances of customer cannot have null values 
	 */
	public Customer(int customerID, String name, String address, String contactNUM, String accountSTATUS)
	{
		this.customerID = customerID;
		this.name = name;
		this.address = address;
		this.contactNUM = contactNUM;
		this.accountSTATUS = accountSTATUS;
	}
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
