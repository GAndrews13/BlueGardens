package com.netbuilder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Jake Customer Entity
 */
@Entity
@Table(name = "Customer")
@NamedQueries({
		@NamedQuery(name = Customer.FIND_BY_NAME, query = "SELECT * FROM Customer c"),
		@NamedQuery(name = Customer.FIND_BY_OUT_STOCK, query = "SELECT c FROM Customer c WHERE c.name = Jake") })
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
	@Id
	@Column(name = "customerID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private long customerID;

	/**
	 * First Name represents the customer name in the table, cannot be null
	 */
	@Column(name = "FirstName", nullable = false, length = 30)
	@NotNull
	@Size(min = 2, max = 30)
	private String firstName;

	/**
	 * Name represents the customer name in the table, cannot be null
	 */
	@Column(name = "LastName", nullable = false, length = 30)
	@NotNull
	@Size(min = 2, max = 30)
	private String lastName;

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
	 * Account status cannot be null but can have a value like N/A for not
	 * active
	 */
	@Column(name = "Account Status", nullable = false, length = 45)
	@NotNull
	@Size(min = 2, max = 45)
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
