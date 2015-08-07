package com.netbuilder.controllers;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Customer;
import com.netbuilder.entitymanagers.CustomerLoginManager;
import com.netbuilder.entitymanagers.CustomerManager;
import com.netbuilder.service.ForgottenPasswordEmail;
import com.netbuilder.util.ForgottenPasswordDetails;

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
	private ForgottenPasswordDetails forgottenPasswordDetails;
	private String customerEmail;
	public String errormsg;

	public String forgottenPassword() {
		if (forgottenPasswordDetails.getUsername().isEmpty() || forgottenPasswordDetails.getEmail().isEmpty()) {
			errormsg = "Please enter details";
			return "forgottenPassword";
		}
		Long uid = customerLoginManager.checkCustomerID(forgottenPasswordDetails.getUsername());
		Customer customer = customerManager.findByEmail(forgottenPasswordDetails.getEmail());
		if(uid == null) {
			errormsg = "Incorrect details";
			return "forgottenPassword";
		} else { if(customer == null) {
				errormsg = "Incorrect details";
				return "forgottenPassword";
			} if(forgottenPasswordDetails.getUsername().isEmpty())
				customerEmail = forgottenPasswordDetails.getEmail();
			else { if(forgottenPasswordDetails.getEmail().isEmpty()) {
					customerEmail = customer.getEmail();
				}
			}
		}
		new ForgottenPasswordEmail(customerEmail);		
		return "login";
	}

	public String getErrormsg() { return errormsg; }

	public void setErrormsg(String errormsg) { this.errormsg = errormsg; }
}