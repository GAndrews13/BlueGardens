package com.netbuilder.model;


/**
 * @author Jake Customer Entity
 */

public class Customer {
	public static final String FIND_BY_OUT_STOCK = "Customer.findByOutStock";
	public static final String FIND_BY_NAME = "Customer.findByName";

	/**
	 * @author Jake Attributes for customer including unique ID for customer
	 *         (int) name, address, email and accountSTATUS are all Strings
	 *         contactNUM is string so that String operations can be applied
	 *
	 */

	/**
	 * Customer ID will be the primary key in the customer table/ NOT NULL
	 */
	private long customerID;

	/**
	 * First Name represents the customer name in the table, cannot be null
	 */

	private String firstName;

	/**
	 * Name represents the customer name in the table, cannot be null
	 */

	private String lastName;

	/**
	 * Address represents the customer address, length may need to be longer
	 */

	private String address;

	/**
	 * Email can be an optional field to enter, i.e can be null
	 */
	private String email;

	/**
	 * Contact number for the customer, cannot be null
	 */

	private String contactNUM;

	/**
	 * Account status cannot be null but can have a value like N/A for not
	 * active
	 */

	private String accountSTATUS;

	/**
	 * Initialize customer so instances of customer cannot have null values
	 */
	public Customer(String firstname, String lastname, String address,
			String contactNUM, String email, String accountSTATUS) {
		this.firstName = firstname;
		this.lastName = lastname;
		this.address = address;
		this.contactNUM = contactNUM;
		this.email = email;
		this.accountSTATUS = accountSTATUS;
	}

	public Customer(long customerID, String firstName, String lastName,
			String address, String contactNUM, String email,
			String accountSTATUS) {
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.contactNUM = contactNUM;
		this.accountSTATUS = accountSTATUS;
	}

	/**
	 * @author Jake Getters and Setter for class variables
	 *
	 */
	public long getCustomerID() {
		return customerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
