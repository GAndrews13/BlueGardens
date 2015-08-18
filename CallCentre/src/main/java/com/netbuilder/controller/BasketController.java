package com.netbuilder.controller;
 
/**
 * @author jmander
 * **/


import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.netbuilder.controller.Dummy.CustomerManagerDummy;
import com.netbuilder.controller.Dummy.CustomerOrderManagerDummy;
import com.netbuilder.controller.Dummy.ProductManagerDummy;
import com.netbuilder.model.Customer;
import com.netbuilder.model.Product;
 
@Controller
public class BasketController { 
	private ArrayList<Product> products;
	
	@RequestMapping("/basket")
	public ModelAndView showMessage(@RequestParam (value = "id", required = false, defaultValue = "0") String id)
	{ 
		CustomerManagerDummy customerManagerDummy = new CustomerManagerDummy();
		CustomerOrderManagerDummy customerOrderManagerDummy = new CustomerOrderManagerDummy();
		ProductManagerDummy productManagerDummy = new ProductManagerDummy();
		Customer customer = new Customer();
		customer = customerManagerDummy.findByID(Long.parseLong(id));
		products = new ArrayList<Product>();
		products = productManagerDummy.findAll();
		
		ModelAndView mv = new ModelAndView("basket");
		
		//String surName ="Error",firstName ="Error",accountStatus ="Error",email ="Error",contactNumber ="Error",address ="Error";
		mv.addObject("surName",customer.getLastName().toUpperCase());
		mv.addObject("firstName",customer.getFirstName());
		mv.addObject("customerID",id);
		mv.addObject("customerOrderID",(customerOrderManagerDummy.findAll().size()+1));
		mv.addObject("products", products);
		return mv;
	}
	
}