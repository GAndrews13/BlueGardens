package com.netbuilder.controllers;

import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import com.netbuilder.entities.Customer;
import com.netbuilder.entitymanagers.CustomerLoginManager;
import com.netbuilder.entitymanagers.CustomerManager;

/**
 * @author jmander
 **/

@ManagedBean(name = "forgottenUsernameController")
@Dependent
public class ForgottenUsernameController {
	@Inject
	private CustomerManager customerManager;
	@Inject
	private CustomerLoginManager customerLoginManager;
	private String email;
	public String ermsg;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getErmsg() {
		return ermsg;
	}

	public void setErmsg(String ermsg) {
		this.ermsg = ermsg;
	}

	public String forgottenUsername() {
		System.out.println(email);
		if (email.isEmpty()) {
			System.out.println("here");
			ermsg = "Please enter an email";
			return "forgottenUsername";
		}
		
		for (Customer c : customerManager.findAll()) {
			if(c.getEmail().equals(email)){
				System.out.println("Hello");
				ermsg = customerLoginManager.getCustomerUsername(email);
				System.out.println(ermsg);
				return "forgottenUsername";
			}
			ermsg = "This email is not registered, please register or re-enter your email";
		}
		return "forgottenUsername";
	}
	
}
