package com.netbuilder.controllers;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Customer;
import com.netbuilder.entitymanagers.CustomerManager;
import com.netbuilder.util.CustomerDetails;

@Named
@Dependent
public class ForgottenUsernameController {
	@Inject
	private CustomerManager customerManager;
	//@Inject
	private CustomerDetails customerDetails;
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
		return "sendUsernameEmail/uid";
	}

}
