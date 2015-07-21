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

@Entity
@Table(name = "CustomerLogin")
/**
 * 
 * @author gandrews
 *
 */
public class CustomerLogin {

	/**
	 * The password a user on the website provides
	 */
	@Column(name = "password")
	@Size (min = 6, max = 25)
	private String customerPassword;
	/**
	 * The username that is provided on the website
	 */
	@Column(name = "username")
	@Size(min = 6, max =25)
	private String customerUsername;
	
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private long customerID;
	
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public String getCustomerUsername() {
		return customerUsername;
	}
	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}
	public long getCustomerID()	{
		return this.customerID;
	}
	public void serCustomerID(long customerID){
		this.customerID = customerID;
	}
	
	/**
	 * Basic constructor containing both username and password
	 * @param inUsername
	 * @param inPassword
	 */
	public CustomerLogin(String inUsername, String inPassword)
	{
		this.customerUsername = inUsername;
		this.customerPassword = inPassword;
	}
}