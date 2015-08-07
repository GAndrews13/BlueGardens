package com.netbuilder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.netbuilder.util.LoginUtils;

/**
 * 
 * @author gandrews
 *
 */
@Entity
@Table(name = "CustomerLogin")
public class CustomerLogin {
	@Column(name ="email")
	@NotNull
	private String customerEmail;
	
	@Column(name = "password", nullable = false)
	@Size (min = 6, max = 25)
	@NotNull
	private byte[] customerPassword;

	@Column(name = "username", nullable = false)
	@Size(min = 6, max =25)
	@NotNull
	private String customerUsername;
	
	@OneToOne
	@JoinColumn(name ="customerID", nullable = false)
	@NotNull
	private long customerID;
	
	@Column(name="salt",nullable=false)
	@NotNull
	private byte[] salt;
	
	/**
	 * Basic constructor containing both username and password
	 * @param inUsername
	 * @param inPassword
	 */
	public CustomerLogin(long customerID, String inUsername, String inPassword, byte[] inSalt) {
		this.customerID = customerID;
		this.customerUsername = inUsername;
		try {
			this.customerPassword = LoginUtils.hash(inPassword,inSalt);
		} catch (Exception e) { System.out.println(e.toString()); }
		this.salt = inSalt;
	}
	
	public String getCustomerEmail() { return customerEmail; }
	public byte[] getSalt() { return salt; }
	public byte[] getCustomerPassword() { return customerPassword; }
	public String getCustomerUsername() { return customerUsername; }
	public long getCustomerID()	{ return this.customerID; }
	
	public void setSalt(byte[] salt) { this.salt = salt; }
	public void setCustomerPassword(byte[] customerPassword) { this.customerPassword = customerPassword; }
	public void setCustomerUsername(String customerUsername) { this.customerUsername = customerUsername; }
	public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }
}