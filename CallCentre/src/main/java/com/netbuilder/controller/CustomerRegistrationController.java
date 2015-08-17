package com.netbuilder.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.CustomerLogin;
import com.netbuilder.entitymanagers.CustomerLoginManager;
import com.netbuilder.entitymanagers.CustomerManager;
import com.netbuilder.service.RegistrationEmail;
import com.netbuilder.util.LoginUtils;

/**
 * @author jmander
 **/

@ManagedBean(name = "customerRegistrationController")
@RequestScoped
public class CustomerRegistrationController {
	@Inject
	private CustomerManager customerManager;
	@Inject
	private CustomerLoginManager customerLoginManager;
	private Customer newCustomer;
	private CustomerLogin newCustomerLogin;
	private byte[] customerSalt;
	public String errormsg;
	
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String confirmPassword;
	private String email;
	private String confirmEmail;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmEmail() {
		return confirmEmail;
	}

	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	private String address;
	private String contactNumber;

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<String> usernames = new ArrayList<String>();

	public String registeredCustomer() {

		if (firstName.isEmpty()) {
			errormsg = "Please enter a first name";
			return "registeredCustomer";
		}
		if (lastName.isEmpty()) {
			errormsg = "Please enter a last name";
			return "registeredCustomer";
		}
		if (username.isEmpty()) {	
			errormsg = "Please enter a username";
			return "registeredCustomer";
		}
		for (CustomerLogin cl : customerLoginManager.findAll()) {	
			usernames.add(cl.getCustomerUsername());
		}
		for (String username : usernames) {	
			if (this.username.equals(username)) {
				errormsg = "This username already exists";
				return "registeredCustomer";
			}
		}
		if (password.isEmpty()) {
			errormsg = "Please enter a password";
			return "registeredCustomer";
		}
		if (confirmPassword.isEmpty()) {
			errormsg = "Please confirm your password";
			return "registeredCustomer";
		}
		if (email.isEmpty()) {
			errormsg = "Please enter an email";
			return "registeredCustomer";
		}
		for (Customer c : customerManager.findAll()) {	
			customers.add(c);
		}
		for (Customer c : customers) {
			if (this.email.equals(c.getEmail())) {
				errormsg = "This email already exists";
				return "registeredCustomer";
			}
		}
		if (confirmEmail.isEmpty()) {
			errormsg = "Please confirm your email";
			return "registeredCustomer";
		}
		if (address.isEmpty()) {
			errormsg = "Please enter an address";
			return "registeredCustomer";
		}
		if (contactNumber.isEmpty()) {
			errormsg = "Please enter a contact number";
			return "registeredCustomer";
		}
		if (confirmPassword.equals(password)) {
			if (confirmEmail.equals(email)) {
			}else{
				errormsg = "The emails do not match";
				return "registeredCustomer";
			}
		}else{
			errormsg = "The passwords do not match";
			return "registeredCustomer";
		}

		newCustomer = new Customer((customerManager.findAll().size()+1), firstName, lastName, address, contactNumber, email, "ACTIVE");

		customerSalt = LoginUtils.getNextSalt();

		newCustomerLogin = new CustomerLogin((customerLoginManager.findAll().size()+1),
				username, email, password,
				customerSalt);

		customerManager.persistCustomer(newCustomer);
		customerLoginManager.persistCustomerLogin(newCustomerLogin);
		
		//new RegistrationEmail(email,
		//		firstName, username);
		
		return "login";
		
	}

}
