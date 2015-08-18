package com.netbuilder.controller;
 
/**
 * @author jmander
 * @author GAndrews
 * **/


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.netbuilder.controller.Dummy.CustomerManagerDummy;
import com.netbuilder.model.Customer;
 
@Controller
public class CustomerController {
	String message = "Customer 1:";
 
	
	@RequestMapping("/customer")
	public ModelAndView showMessage(@RequestParam (value = "id", required = false, defaultValue = "0") String id)
	{ 
		CustomerManagerDummy customerManagerDummy = new CustomerManagerDummy();
		Customer customer = new Customer();
		customer = customerManagerDummy.findByID(Long.parseLong(id));
		
		ModelAndView mv = new ModelAndView("customerPage");
		//String surName ="Error",firstName ="Error",accountStatus ="Error",email ="Error",contactNumber ="Error",address ="Error";
		mv.addObject("surName",customer.getLastName());
		mv.addObject("firstName",customer.getFirstName());
		mv.addObject("accountStatus",customer.getAccountSTATUS());
		mv.addObject("id",id);
		mv.addObject("email",customer.getEmail());
		mv.addObject("contactNumber",customer.getContactNUM());
		mv.addObject("address",customer.getAddress());
		return mv;
	}
	
}