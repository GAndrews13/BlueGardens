package com.netbuilder.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.netbuilder.model.Customer;
import com.netbuilder.model.CustomerLogin;
import com.netbuilder.controller.Dummy.CustomerLoginManagerDummy;
import com.netbuilder.controller.Dummy.CustomerManagerDummy;
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
		
		CustomerManagerDummy customerManagerDummy = new CustomerManagerDummy();
		CustomerLoginManagerDummy customerLoginManagerDummy = new CustomerLoginManagerDummy();

		if (requestParams.get("firstName").isEmpty()) {
			ModelAndView mv = new ModelAndView("failedCustomer");
			mv.addObject("errorMessage","A first name was not entered, please try again");
			return mv;
		}
		
		if (requestParams.get("lastName").isEmpty()) {
			ModelAndView mv = new ModelAndView("failedCustomer");	
			mv.addObject("errorMessage","A last name was not entered, please try again");
			return mv;
		}
		
		if (requestParams.get("username").isEmpty()) {
			ModelAndView mv = new ModelAndView("failedCustomer");
			mv.addObject("errorMessage","A username was not entered, please try again");
			return mv;
		}
		
		for(CustomerLogin cl : customerLoginManagerDummy.findAll()){
			if(cl.getCustomerUsername().equals(requestParams.get("username"))){
				ModelAndView mv = new ModelAndView("failedCustomer");
				mv.addObject("errorMessage","This username is already taken, please try again");
				return mv;
			}
		}
		
		if (requestParams.get("password").isEmpty()) {
			ModelAndView mv = new ModelAndView("failedCustomer");
			mv.addObject("errorMessage","A password was not entered, please try again");
			return mv;
		}
		
		if (requestParams.get("confirmPassword").isEmpty()) {
			ModelAndView mv = new ModelAndView("failedCustomer");
			mv.addObject("errorMessage","The password was not confirmed, please try again");
			return mv;
		}
		
		if(requestParams.get("password").equals(requestParams.get("confirmPassword")) == false){
			ModelAndView mv = new ModelAndView("failedCustomer");
			mv.addObject("errorMessage","The passwords do not match, please try again");
			return mv;
		}
		
		if (requestParams.get("email").isEmpty()) {
			ModelAndView mv = new ModelAndView("failedCustomer");
			mv.addObject("errorMessage","An email address was not entered, please try again");
			return mv;
		}
		
		for(Customer c : customerManagerDummy.findAll()){
			if(c.getEmail().equals(requestParams.get("email"))){
				ModelAndView mv = new ModelAndView("failedCustomer");
				mv.addObject("errorMessage","This email address is already taken, please try again");
				return mv;
			}
		}
		
		if (requestParams.get("confirmEmail").isEmpty()) {
			ModelAndView mv = new ModelAndView("failedCustomer");
			mv.addObject("errorMessage","The email address was not confirmed, please try again");
			return mv;
		}
		
		if(requestParams.get("email").equals(requestParams.get("confirmEmail")) == false){
			ModelAndView mv = new ModelAndView("failedCustomer");
			mv.addObject("errorMessage","The email addresses do not match, please try again");
			return mv;
		}
		
		if (requestParams.get("address").isEmpty()) {
			ModelAndView mv = new ModelAndView("failedCustomer");
			mv.addObject("errorMessage","An address was not entered, please try again");
			return mv;
		}
		
		if (requestParams.get("contactNumber").isEmpty()) {
			ModelAndView mv = new ModelAndView("failedCustomer");
			mv.addObject("errorMessage","A contact number was not entered, please try again");
			return mv;
		}

		
		ModelAndView mv = new ModelAndView("registeredCustomer");
		mv.addObject("lastName",requestParams.get("lastName").toUpperCase());
		mv.addObject("firstName",requestParams.get("firstName"));
		mv.addObject("accountStatus","ACTIVE");
		mv.addObject("username", requestParams.get("username"));
		mv.addObject("id",(customerManagerDummy.findAll().size()+1));
		mv.addObject("email",requestParams.get("email"));
		mv.addObject("contactNumber",requestParams.get("contactNumber"));
		mv.addObject("address",requestParams.get("address"));
		
		customerManagerDummy.persistCustomer(new Customer((customerManagerDummy.findAll().size()+1), requestParams.get("firstName"), requestParams.get("lastName"),
				requestParams.get("address"), requestParams.get("contactNumber"), requestParams.get("email"), "ACTIVE"));
		customerLoginManagerDummy.persistCustomerLogin(new CustomerLogin((customerManagerDummy.findAll().size()+1), requestParams.get("username"), requestParams.get("email"),
				requestParams.get("password"), LoginUtils.getNextSalt()));
		
		 return mv;
		 		
	}
	/*

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
