package com.netbuilder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.netbuilder.model.Utility.LoginUtils;

@Entity
@Table(name = "CustomerLogin")
/**
 * 
 * @author gandrews
 *
 */
public class CustomerLogin {

	@Column(name = "email")
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
	@Column(name = "password", nullable = false)
	@Size(min = 6, max = 25)
	@NotNull
	private byte[] customerPassword;
	/**
	 * The username that is provided on the website
	 */
	@Column(name = "username", nullable = false)
	@Size(min = 6, max = 25)
	@NotNull
	private String customerUsername;

	@OneToOne
	@JoinColumn(name = "customerID", nullable = false)
	@NotNull
	private long customerID;

	@Column(name = "salt", nullable = false)
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

	public long getCustomerID() {
		return this.customerID;
	}

	/**
	 * Basic constructor containing both username and password
	 * 
	 * @param inUsername
	 * @param inPassword
	 */
	public CustomerLogin(long customerID, String inUsername, String inEmail, String inPassword,
			byte[] inSalt) {
		this.customerEmail = inEmail;
		this.customerID = customerID;
		this.customerUsername = inUsername;
		try {
			this.customerPassword = LoginUtils.hash(inPassword, inSalt);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		this.salt = inSalt;
	}
}
