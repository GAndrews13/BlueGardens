package com.netbuilder.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import com.netbuilder.entities.Customer;
import com.netbuilder.entitymanagers.CustomerLoginManager;
import com.netbuilder.entitymanagers.CustomerManager;

/**
 * @author jmander
 **/

@ManagedBean(name = "forgottenUsernameController")
@RequestScoped
public class ForgottenUsernameController {
	@Inject
	private CustomerManager customerManager;
	@Inject
	private CustomerLoginManager customerLoginManager;
	private String email;
	public String errormsg;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}


	public String forgottenUsername() {
		if (email.isEmpty()) {
			errormsg = "Please enter an email";
			return "forgottenUsername";
		}
		
		for (Customer c : customerManager.findAll()) {
			if(c.getEmail().equals(email)){
				errormsg = "Your username is: " + (customerLoginManager.getCustomerUsername(email));
				return "forgottenUsername";
			}
			errormsg = "This email is not registered, please register or re-enter your email";
		}
		return "forgottenUsername";
	}
	
}
