package com.netbuilder.util;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * @author jmander
 * Utility used to capture the information related to registering a customer  
 **/
@Named
@RequestScoped
public class CustomerDetails {
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String confirmPassword;
	private String email;
	private String confirmEmail;
	private String address;
	private String contactNumber;
	
	public CustomerDetails(String firstName, String lastName, String username, String password, String confirmPassword, String email, String confirmEmail, String address, String contactNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.email = email;
		this.confirmEmail = confirmEmail;
		this.address = address;
		this.contactNumber = contactNumber;
	}

	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getUsername() { return username; }
	public String getPassword() { return password; }
	public String getConfirmPassword() { return confirmPassword; }
	public String getEmail() { return email; }
	public String getConfirmEmail() { return confirmEmail; }
	public String getAddress() { return address; }	
	public String getContactNumber() { return contactNumber; }
	
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	public void setUsername(String username) { this.username = username; }
	public void setPassword(String password) { this.password = password; }
	public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }
	public void setEmail(String email) { this.email = email; }
	public void setConfirmEmail(String confirmEmail) { this.confirmEmail = confirmEmail; }
	public void setAddress(String address) { this.address = address; }
	public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
}