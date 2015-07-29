package com.netbuilder.controllers;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Customer;
import com.netbuilder.entitymanagers.CustomerLoginManager;
import com.netbuilder.entitymanagers.CustomerManager;
import com.netbuilder.service.ForgottenPasswordEmail;
import com.netbuilder.util.CustomerDetails;
import com.netbuilder.util.UserDetails;

/**
 * @author jmander
 **/

@Named
@Dependent
public class ForgottenPasswordController {
	@Inject
	private CustomerManager customerManager;
	@Inject
	private CustomerLoginManager customerLoginManager;
	//@Inject
	private CustomerDetails customerDetails;
	//@Inject
	private UserDetails userDetails;
	private ForgottenPasswordEmail forgottenPasswordEmail;
	public String errormsg;
	
	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

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
		forgottenPasswordEmail = new ForgottenPasswordEmail(customerDetails.getEmail());
		return "login";
	}

}
