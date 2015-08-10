package com.netbuilder.controllers;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.netbuilder.entities.Customer;
import com.netbuilder.entitymanagers.CustomerLoginManager;
import com.netbuilder.entitymanagers.CustomerManager;
import com.netbuilder.util.LoggedInUser;

/**
 * @author abalagel
 * @author jmander
 *
 */
@ManagedBean(name = "accountController")
@RequestScoped
public class AccountController {
	@Inject
	private CustomerManager customerManager;
	@Inject
	private LoggedInUser loggedInUser;
	@Inject
	private CustomerLoginManager customerLoginManager;
	private String username;
	private String password;
	private String confirmPassword;
	private String errmsg;

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errormsg) {
		this.errmsg = errormsg;
	}

	private Customer customer;

	public AccountController() {
	}

	public String search() {
		this.customer = customerManager.findByID(loggedInUser.getUserID());
		this.username = loggedInUser.getUsername();
		if (customer.getCustomerID() < 1 || username == null) {
			return "account";
		}
		return "account";
	}

	public String changePassword() {
		if (password.isEmpty() || confirmPassword.isEmpty()) {
			errmsg = "Please enter a password";
			return "account";
		}
		if (password.matches(confirmPassword)) {
			errmsg = "Password Saved!";
			try {
				customerLoginManager.updateCustomerPassword(
						loggedInUser.getUserID(), password);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "account";
		}
		errmsg = "Passwords do not match, please try again";
		return "account";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}