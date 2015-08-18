package com.netbuilder.controller;
 
/**
 * @author jmander
 * **/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class CustomerController {
	String message = "Customer 1:";
	private CustomerManager customerManager;
 
	@RequestMapping("/customer")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "Clark Kent") String name) { 
		ModelAndView mv = new ModelAndView("customerPage");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}
}