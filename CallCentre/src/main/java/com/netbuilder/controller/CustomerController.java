package com.netbuilder.controller;
 
/**
 * @author jmander
 * @author GAndrews
 * **/

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class CustomerController {
	String message = "Customer 1:";
	private CustomerManager customerManager;
 
	
	@RequestMapping("/customer")
	public ModelAndView showMessage(@RequestParam (required=true) Map<String,String> requestParams)
	{ 
		ModelAndView mv = new ModelAndView("customerPage");
		String surName ="Error",firstName ="Error",accountStatus ="Error",id ="Error",email ="Error",contactNumber ="Error",address ="Error";
		mv.addObject("surName",requestParams.get("surName"));
		mv.addObject("firstName",requestParams.get("firstName"));
		mv.addObject("accountStatus",requestParams.get("accountStatus"));
		mv.addObject("id",requestParams.get("id"));
		mv.addObject("email",requestParams.get("email"));
		mv.addObject("contactNumber",requestParams.get("contactNumber"));
		mv.addObject("address",requestParams.get("address"));
		return mv;
	}
	
}