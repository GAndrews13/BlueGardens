package com.netbuilder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CustomerLogin")
/**
 * 
 * @author gandrews
 *
 */
public class CustomerLogin {

	@Column(name ="email")
	@NotNull
	private String customerEmail;
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	/**
	 * The password a user on the website provides
	 */
	@Column(name = "password")
	@Size (min = 6, max = 25)
	private byte[] customerPassword;
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
	
	@Column(name="salt",nullable=false)
	@NotNull
	private byte[] salt;
	
	public byte[] getSalt() {
		return salt;
	}
	public void setSalt(byte[] salt) {
		this.salt = salt;
	}
	public byte[] getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(byte[] customerPassword) {
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
	public CustomerLogin(String inUsername, byte[] inPassword, byte[] inSalt)
	{
		this.customerUsername = inUsername;
		this.customerPassword = inPassword;
		this.salt = inSalt;
	}
}
