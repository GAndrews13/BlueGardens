package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Customer;
import com.netbuilder.entitymanagers.CustomerLoginManager;
import com.netbuilder.entitymanagers.CustomerManager;
import com.netbuilder.util.CustomerDetails;
import com.netbuilder.util.UserDetails;

@Named
@Dependent
public class CustomerRegistrationController {
	//@Inject
	private CustomerDetails customerDetails;
	//@Inject
	private UserDetails userDetails;
	@Inject
	private CustomerManager customerManager;
	@Inject
	private CustomerLoginManager customerLoginManager;
	private String confirmPassword;
	private String confirmEmail;
	public String errormsg;
	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<String> usernames = new ArrayList<String>();
	
	public String registeredCustomer(){
		if (customerDetails.getFirstName().isEmpty()) {
			errormsg = "Please enter a first name";
			return "registeredCustomer";
		}
		if (customerDetails.getLastName().isEmpty()) {
			errormsg = "Please enter a last name";
			return "registeredCustomer";
		}
		if (userDetails.getUsername().isEmpty()) {
			errormsg = "Please enter a username";
			return "registeredCustomer";
		}
		usernames = customerLoginManager.findAll();
		for(String username: usernames){
			if(customerDetails.getUsername() == username){
				errormsg = "This username already exists";
				return "registeredCustomer";
			}
		}
		if (userDetails.getPassword().isEmpty()) {
			errormsg = "Please enter a password";
			return "registeredCustomer";
		}
		if (confirmPassword.isEmpty()) {
			errormsg = "Please confirm your password";
			return "registeredCustomer";
		}
		if(confirmPassword != userDetails.getPassword()){
			errormsg = "The passwords do not match";
			return "registeredCustomer";
		}
		if (customerDetails.getEmail().isEmpty()) {
			errormsg = "Please enter an email";
			return "registeredCustomer";
		}
		customers = customerManager.findAll();
		for(Customer c: customers){
			if(customerDetails.getEmail() == c.getEmail()){
				errormsg = "This email already exists";
				return "registeredCustomer";
			}
		}
		if (confirmEmail.isEmpty()) {
			errormsg = "Please confirm your email";
			return "registeredCustomer";
		}
		if(confirmEmail != userDetails.getUsername()){
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
		return "login";
	}

}
