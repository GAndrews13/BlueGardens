package com.netbuilder.controller;
 
/**
 * @author jmander
 * @author GAndrews
 * **/

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.netbuilder.model.Customer;
import com.netbuilder.model.Utility.DummyData;
 
@Controller
public class CustomerController {
	String message = "Customer 1:";
	@Autowired
	private CustomerManager customerManager;
	
	
	@RequestMapping("/customer")
	public ModelAndView showMessage(
			@RequestParam(value = "id", required = false, defaultValue = "0") String id) { 
		ModelAndView mv = new ModelAndView("customerPage");
		mv.addObject("id", id);
		
		//Get all details needed from the database
		String surName ="Error",firstName ="Error",accountStatus ="Error",email ="Error",contactNumber ="Error",address ="Error";
		try
		{
			Customer customer = customerManager.findByID(Long.parseLong(id));
			try
			{
				if(customer!= null)
				{
					mv.addObject("surName",customer.getLastName());
					mv.addObject("firstName",customer.getFirstName());
					mv.addObject("accountStatus",customer.getAccountSTATUS());
					mv.addObject("email",customer.getEmail());
					mv.addObject("contactNumber",customer.getContactNUM());
					mv.addObject("address",customer.getAddress());
				}
			}
			catch (Exception e)
			{
				System.out.println(e.toString());
			}
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		return mv;
	}
	
}