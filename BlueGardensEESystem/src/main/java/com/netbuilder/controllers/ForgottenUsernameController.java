package com.netbuilder.controllers;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Customer;
import com.netbuilder.entitymanagers.CustomerManager;
import com.netbuilder.service.ForgottenUsernameEmail;
import com.netbuilder.util.CustomerDetails;

@Named
@Dependent
public class ForgottenUsernameController {
	@Inject
	private CustomerManager customerManager;
	//@Inject
	private CustomerDetails customerDetails;
	private ForgottenUsernameEmail forgottenUsernameEmail;
	public String errormsg;

	public String forgottenUsername() {
		if (customerDetails.getEmail().isEmpty()) {
			errormsg = "Please enter an email";
			return "forgottenUsername";
		}
		Customer email = customerManager.findByEmail(customerDetails.getEmail());
		if(email == null){
			errormsg = "Incorrect details";
			return "forgottenUsername";
		}
		forgottenUsernameEmail = new ForgottenUsernameEmail(customerDetails.getEmail());
		return "login";
	}
}
