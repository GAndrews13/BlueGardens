package com.netbuilder.controllers;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Customer;
import com.netbuilder.entitymanagers.CustomerManager;
import com.netbuilder.service.ForgottenUsernameEmail;
import com.netbuilder.util.ForgottenUsernameDetails;

/**
 * @author jmander
 **/

@Named
@Dependent
public class ForgottenUsernameController {
	@Inject
	private CustomerManager customerManager;
	//@Inject
	private ForgottenUsernameDetails forgottenUsernameDetails;
	public String errormsg;
	
	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String forgottenUsername() {
		if (forgottenUsernameDetails.getEmail().isEmpty()) {
			errormsg = "Please enter an email";
			return "forgottenUsername";
		}
		Customer email = customerManager.findByEmail(forgottenUsernameDetails.getEmail());
		if(email == null){
			errormsg = "Incorrect details";
			return "forgottenUsername";
		}
		new ForgottenUsernameEmail(forgottenUsernameDetails.getEmail());
		return "login";
	}
}
