package com.netbuilder.controller;
 
/**
 * @author jmander
 * @author GAndrews
 * **/


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.netbuilder.controller.Dummy.CustomerLoginManagerDummy;
import com.netbuilder.controller.Dummy.CustomerManagerDummy;
import com.netbuilder.model.Customer;
 
@Controller
public class CustomerController {
	String message = "Customer 1:";
 
	@RequestMapping("/customer")
	public ModelAndView showMessage(@RequestParam (required=true) Map<String,String> requestParams)
	{ 
		ModelAndView mv = new ModelAndView("customerPage");
		
		CustomerManagerDummy customerManagerDummy = new CustomerManagerDummy();
		CustomerLoginManagerDummy customerLoginDummy = new CustomerLoginManagerDummy();
		Customer customer = new Customer();
		long id = 0;
		try
		{ //Check parameters passed through query strings
			String idParam,nameParam,usernameParam;
			idParam =requestParams.get("id"); 
			usernameParam = requestParams.get("username");
			
			if(idParam!=null)
			{
				id = Long.parseLong(idParam);
			}
			else if(usernameParam != null)
			{
				id = customerLoginDummy.checkCustomerID(usernameParam);
			}
			customer = customerManagerDummy.findByID(id);
			if(customer!= null)
			{
			//String surName ="Error",firstName ="Error",accountStatus ="Error",email ="Error",contactNumber ="Error",address ="Error";
			mv.addObject("surName",customer.getLastName());
			mv.addObject("firstName",customer.getFirstName());
			mv.addObject("accountStatus",customer.getAccountSTATUS());
			mv.addObject("id",id);
			mv.addObject("email",customer.getEmail());
			mv.addObject("contactNumber",customer.getContactNUM());
			mv.addObject("address",customer.getAddress());
			}
			else
			{
				throw new Exception("Customer Not Found");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		return mv;
	}
	
}