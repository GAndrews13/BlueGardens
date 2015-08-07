package com.netbuilder.controllers;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.CustomerLogin;
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
	private CustomerLogin customerLogin;
	private String username;
	private String password;
	private Customer customer;
	private String confirmPassword;
	private String errmsg;
	
	public AccountController() { }

	public String search() {
		this.customer = customerManager.findByID(loggedInUser.getUserID());
		this.username = loggedInUser.getUsername();
		if(customer.getCustomerID()<1 || username==null)
			return "account";
		return "account";
	}
	
	public String changePassword(){
		if(password.matches(confirmPassword)){
			try {
				System.out.println(customerLogin.getCustomerPassword());
				customerLoginManager.updateCustomerPassword(customer.getCustomerID(), password);
				System.out.println(customerLogin.getCustomerPassword());
			} catch (Exception e) { e.printStackTrace(); }
			return "account";
		}
		errmsg="Passwords do not match, please try again";
		return "account";
	}

	public String getUsername() { return username; }
	public String getPassword() { return password; }
	public String getConfirmPassword() { return confirmPassword; }
	public Customer getCustomer() { return customer; }
	public String getErrmsg() { return errmsg; }
	
	public void setUsername(String username) { this.username = username; }
	public void setPassword(String password) { this.password = password; }	
	public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }
	public void setCustomer(Customer customer) { this.customer = customer; }
	public void setErrmsg(String errormsg) { this.errmsg = errormsg; }
}