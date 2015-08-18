package com.netbuilder.controller;
 
/**
 * @author jmander
 * **/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class CustomerSearchController {
	String message = "Customer Search:";
	String name = "Clark Kent";
	
	@RequestMapping("/customerSearch")
	public ModelAndView customerSearchTest(){
		
		System.out.println("we made it");
		ModelAndView mv = new ModelAndView("customerSearch");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
		
	}
	
}