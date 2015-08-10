package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.CustomerLogin;
import com.netbuilder.entitymanagers.CustomerLoginManager;
import com.netbuilder.entitymanagers.CustomerManager;
import com.netbuilder.service.RegistrationEmail;
import com.netbuilder.util.CustomerDetails;
import com.netbuilder.util.LoginUtils;

/**
 * @author jmander
 **/

@Named
@Dependent
public class CustomerRegistrationController {
	// @Inject
	private CustomerDetails customerDetails;
	@Inject
	private CustomerManager customerManager;
	@Inject
	private CustomerLoginManager customerLoginManager;
	private String confirmPassword;
	private String confirmEmail;
	private Customer newCustomer;
	private CustomerLogin newCustomerLogin;
	private byte[] customerSalt;
	public String errormsg;

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<String> usernames = new ArrayList<String>();

	public String registeredCustomer() {
		if (customerDetails.getFirstName().isEmpty()) {
			errormsg = "Please enter a first name";
			return "registeredCustomer";
		}
		if (customerDetails.getLastName().isEmpty()) {
			errormsg = "Please enter a last name";
			return "registeredCustomer";
		}
		if (customerDetails.getUsername().isEmpty()) {
			errormsg = "Please enter a username";
			return "registeredCustomer";
		}
		for (CustomerLogin cl : customerLoginManager.findAll()) {
			usernames.add(cl.getCustomerUsername());
		}
		for (String username : usernames) {
			if (customerDetails.getUsername() == username) {
				errormsg = "This username already exists";
				return "registeredCustomer";
			}
		}
		if (customerDetails.getPassword().isEmpty()) {
			errormsg = "Please enter a password";
			return "registeredCustomer";
		}
		if (confirmPassword.isEmpty()) {
			errormsg = "Please confirm your password";
			return "registeredCustomer";
		}
		if (confirmPassword != customerDetails.getPassword()) {
			errormsg = "The passwords do not match";
			return "registeredCustomer";
		}
		if (customerDetails.getEmail().isEmpty()) {
			errormsg = "Please enter an email";
			return "registeredCustomer";
		}
		customers = customerManager.findAll();
		for (Customer c : customers) {
			if (customerDetails.getEmail() == c.getEmail()) {
				errormsg = "This email already exists";
				return "registeredCustomer";
			}
		}
		if (confirmEmail.isEmpty()) {
			errormsg = "Please confirm your email";
			return "registeredCustomer";
		}
		if (confirmEmail != customerDetails.getUsername()) {
			errormsg = "The emails do not match";
			return "registeredCustomer";
		}
		if (customerDetails.getAddress().isEmpty()) {
			errormsg = "Please enter an address";
			return "registeredCustomer";
		}
		if (customerDetails.getContactNumber().isEmpty()) {
			errormsg = "Please enter a contact number";
			return "registeredCustomer";
		}

		newCustomer = new Customer(customerDetails.getFirstName(),
				customerDetails.getLastName(), customerDetails.getAddress(),
				customerDetails.getContactNumber(), customerDetails.getEmail(),
				"ACTIVE");

		customerSalt = LoginUtils.getNextSalt();

		newCustomerLogin = new CustomerLogin(newCustomer.getCustomerID(),
				customerDetails.getUsername(), customerDetails.getPassword(),
				customerSalt);

		customerManager.persistCustomer(newCustomer);
		customerLoginManager.persistCustomerLogin(newCustomerLogin);

		new RegistrationEmail(customerDetails.getEmail(),
				customerDetails.getFirstName(), customerDetails.getUsername());

		return "login";
	}

}
