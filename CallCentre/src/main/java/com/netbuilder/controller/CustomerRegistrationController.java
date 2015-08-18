package com.netbuilder.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.netbuilder.model.Customer;
import com.netbuilder.model.CustomerLogin;
import com.netbuilder.controller.CustomerLoginManager;
import com.netbuilder.controller.CustomerManager;
import com.netbuilder.controller.Dummy.CustomerLoginManagerDummy;
import com.netbuilder.controller.Dummy.CustomerManagerDummy;
import com.netbuilder.service.RegistrationEmail;
import com.netbuilder.model.Utility.LoginUtils;

/**
 * @author jmander
 **/

@Controller
public class CustomerRegistrationController {

	@RequestMapping("/customerRegistration")
	public ModelAndView customerSearchTest(){
		
		ModelAndView mv = new ModelAndView("customerRegistration");
		return mv;
		
	}
	
	@RequestMapping("/registeredCustomer")
	public ModelAndView showNewMessage(@RequestParam (required=true) Map<String,String> requestParams)
	{ 	
	  	
		System.out.println("we here");
		
		CustomerManagerDummy customerManagerDummy = new CustomerManagerDummy();
		CustomerLoginManagerDummy customerLoginManagerDummy = new CustomerLoginManagerDummy();
		Customer customer = new Customer((customerManagerDummy.findAll().size()+1), requestParams.get("firstName"), requestParams.get("lastName"),
				requestParams.get("address"), requestParams.get("contactNumber"), requestParams.get("email"), "ACTIVE");
		CustomerLogin customerLogin = new CustomerLogin((customerManagerDummy.findAll().size()+1), requestParams.get("username"), requestParams.get("email"),
				requestParams.get("password"), LoginUtils.getNextSalt());


		
		ModelAndView mv = new ModelAndView("registeredCustomer");
		mv.addObject("lastName",requestParams.get("lastName").toUpperCase());
		mv.addObject("firstName",requestParams.get("firstName"));
		mv.addObject("accountStatus","ACTIVE");
		mv.addObject("username", requestParams.get("username"));
		mv.addObject("id",(customerManagerDummy.findAll().size()+1));
		mv.addObject("email",requestParams.get("email"));
		mv.addObject("contactNumber",requestParams.get("contactNumber"));
		mv.addObject("address",requestParams.get("address"));
		
		customerManagerDummy.persistCustomer(customer);
		customerLoginManagerDummy.persistCustomerLogin(customerLogin);
		
		 return mv;
		 		
	}
	/*
	private CustomerManager customerManager;
	private CustomerLoginManager customerLoginManager;
	private Customer newCustomer;
	private CustomerLogin newCustomerLogin;
	private byte[] customerSalt;
	public String errormsg;
	
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String confirmPassword;
	private String email;
	private String confirmEmail;
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmEmail() {
		return confirmEmail;
	}

	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	private String address;
	private String contactNumber;

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<String> usernames = new ArrayList<String>();

	public String registeredCustomer() {

		if (firstName.isEmpty()) {
			errormsg = "Please enter a first name";
			return "registeredCustomer";
		}
		if (lastName.isEmpty()) {
			errormsg = "Please enter a last name";
			return "registeredCustomer";
		}
		if (username.isEmpty()) {	
			errormsg = "Please enter a username";
			return "registeredCustomer";
		}
		for (CustomerLogin cl : customerLoginManager.findAll()) {	
			usernames.add(cl.getCustomerUsername());
		}
		for (String username : usernames) {	
			if (this.username.equals(username)) {
				errormsg = "This username already exists";
				return "registeredCustomer";
			}
		}
		if (password.isEmpty()) {
			errormsg = "Please enter a password";
			return "registeredCustomer";
		}
		if (confirmPassword.isEmpty()) {
			errormsg = "Please confirm your password";
			return "registeredCustomer";
		}
		if (email.isEmpty()) {
			errormsg = "Please enter an email";
			return "registeredCustomer";
		}
		for (Customer c : customerManager.findAll()) {	
			customers.add(c);
		}
		for (Customer c : customers) {
			if (this.email.equals(c.getEmail())) {
				errormsg = "This email already exists";
				return "registeredCustomer";
			}
		}
		if (confirmEmail.isEmpty()) {
			errormsg = "Please confirm your email";
			return "registeredCustomer";
		}
		if (address.isEmpty()) {
			errormsg = "Please enter an address";
			return "registeredCustomer";
		}
		if (contactNumber.isEmpty()) {
			errormsg = "Please enter a contact number";
			return "registeredCustomer";
		}
		if (confirmPassword.equals(password)) {
			if (confirmEmail.equals(email)) {
			}else{
				errormsg = "The emails do not match";
				return "registeredCustomer";
			}
		}else{
			errormsg = "The passwords do not match";
			return "registeredCustomer";
		}

		newCustomer = new Customer((customerManager.findAll().size()+1), firstName, lastName, address, contactNumber, email, "ACTIVE");

		customerSalt = LoginUtils.getNextSalt();

		newCustomerLogin = new CustomerLogin((customerLoginManager.findAll().size()+1),
				username, email, password,
				customerSalt);

		customerManager.persistCustomer(newCustomer);
		customerLoginManager.persistCustomerLogin(newCustomerLogin);
		
		//new RegistrationEmail(email,
		//		firstName, username);
		
		return "login";
		
	}*/

}
