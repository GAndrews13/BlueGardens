package com.netbuilder.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.CustomerLogin;
import com.netbuilder.entitymanagers.CustomerLoginManager;
import com.netbuilder.entitymanagers.CustomerManager;
import com.netbuilder.util.CustomerDetails;
import com.netbuilder.util.UserDetails;

@Named
@RequestScoped
public class ForgottenPasswordController {
	@Inject
	private CustomerManager customerManager;
	@Inject
	private CustomerLoginManager customerLoginManager;
	@Inject
	private CustomerDetails customerDetails;
	@Inject
	private UserDetails userDetails;
	public String errormsg;

	public String forgottenPassword() {
		if (userDetails.getUsername().isEmpty() || customerDetails.getEmail().isEmpty()) {
			errormsg = "Please enter details";
			return "forgottenPassword";
		}
		Long uid = customerLoginManager.checkCustomerID(userDetails.getUsername());
		Customer email = customerManager.findByEmail(customerDetails.getEmail());
		if(uid == null)
		{
			errormsg = "Incorrect details";
			return "forgottenPassword";
		}else if(email == null){
			errormsg = "Incorrect details";
			return "forgottenPassword";
		}
		return "resetPasswordEmail/uid";
	}

}
