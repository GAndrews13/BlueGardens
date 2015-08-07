package com.netbuilder.entities;

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

/**
 * @author Jake
 * Customer Entity
 */
@Entity
@Table(name = "Customer")
@NamedQueries({
	@NamedQuery(name = Customer.FIND_BY_NAME , query = "SELECT * FROM Customer c"),
	@NamedQuery(name = Customer.FIND_BY_OUT_STOCK, query = "SELECT c FROM Customer c WHERE c.name = Jake")
})
public class Customer {
	public static final String FIND_BY_OUT_STOCK = "Customer.findByOutStock";
	public static final String FIND_BY_NAME = "Customer.findByName";

	@Id
	@Column(name = "customerID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private long customerID;
	
	@Column(name = "FirstName", nullable = false, length = 30)
	@NotNull
	@Size(min = 2, max = 30)
	private String firstName;
	
	@Column(name = "LastName", nullable = false, length = 30)
	@NotNull
	@Size(min = 2, max = 30)
	private String lastName;
	
	@Column(name = "Address", nullable = false, length = 45)
	@NotNull
	@Size(min = 5, max = 45)
	private String address;
	
	@Column(name = "Email", nullable = true, length = 45)
	@Size(min = 4, max = 45)
	private String email;
	
	@Column(name = "Contact Number", nullable = false, length = 45)
	@NotNull
	@Size(min = 10, max = 45)
	private String contactNUM;
	
	@Column(name = "Account Status", nullable = false, length = 45)
	@NotNull
	@Size(min = 2, max = 45)
	private String accountSTATUS;
	
	public Customer(String firstname, String lastname, String address, String contactNUM, String email, String accountSTATUS) {
		this.firstName = firstname;
		this.lastName = lastname;
		this.address = address;
		this.contactNUM = contactNUM;
		this.email = email;
		this.accountSTATUS = accountSTATUS;
	}
	
	public Customer(long customerID, String firstName, String lastName, String address, String contactNUM, String email, String accountSTATUS) {
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.contactNUM = contactNUM;
		this.accountSTATUS = accountSTATUS;
	}

	public long getCustomerID() { return customerID; }
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getAddress() { return address; }	
	public String getEmail() { return email; }
	public String getAccountSTATUS() { return accountSTATUS; }
	public String getContactNUM() { return contactNUM; }
	
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	public void setAddress(String address) { this.address = address; }
	public void setEmail(String email) { this.email = email; }
	public void setContactNUM(String contactNUM) { this.contactNUM = contactNUM; }
	public void setAccountSTATUS(String accountSTATUS) { this.accountSTATUS = accountSTATUS; }
}