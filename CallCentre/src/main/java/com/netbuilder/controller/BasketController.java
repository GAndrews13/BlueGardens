package com.netbuilder.controller;
 
/**
 * @author jmander
 * **/


import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.netbuilder.controller.Dummy.CustomerManagerDummy;
import com.netbuilder.controller.Dummy.CustomerOrderManagerDummy;
import com.netbuilder.controller.Dummy.ProductManagerDummy;
import com.netbuilder.model.Customer;
import com.netbuilder.model.CustomerOrderLine;
import com.netbuilder.model.Product;
 
@Controller
public class BasketController { 
	static private ArrayList<CustomerOrderLine> products = new ArrayList<CustomerOrderLine>();
	static private Customer customer;
	@RequestMapping("/basket")
	public ModelAndView showMessage(@RequestParam (required = false) Map<String,String> requestParams)
	{ 
		CustomerManagerDummy customerManager = new CustomerManagerDummy();
		CustomerOrderManagerDummy customerOrderManager = new CustomerOrderManagerDummy();
		ProductManagerDummy productManager = new ProductManagerDummy();
		ModelAndView mv = new ModelAndView("basket");
		int quantity = 1;
		if(requestParams.containsKey("clear"))
		{
			clearBasket();
		}
		else
		{
			if(requestParams.containsKey("userId"))
			{
				products.clear();
				customer = customerManager.findByID(Long.parseLong(requestParams.get("userId")));
			}
			else
			{
				if(customer == null)
				{
					mv.addObject("errorMessage","No Customer Detected");
				}
			}
			
			if(requestParams.containsKey("productId"))
			{
				if(requestParams.containsKey("qnt"))
				{
					quantity = Integer.parseInt(requestParams.get("qnt"));
				}
				addProduct(Integer.parseInt(requestParams.get("productId")), quantity);
			}
		}
		mv.addObject("customer",customer);
		mv.addObject("customerOrderID",(customerOrderManager.findAll().size()+1));
		mv.addObject("products", products);
		System.out.println(products.size());
		return mv;
	}
	
	private void addProduct(int inProductId, int inQuantity)
	{
		CustomerOrderLine col;
		int count = -1;
		for(int i = 0;i<products.size();i++)
		{
			col = products.get(i);
			if(col.getProductId() == inProductId)
			{
				count = i;
				break;
			}
			/*
			CustomerOrderLine col = products.get(i);
			if(col.getProductId() == inProductId)
			{
				col.setQuantity(col.getQuantity()+inQuantity);
				products.set(i, col);
			}
			else
			{
				products.add(new CustomerOrderLine(inProductId, inQuantity));
			}
			*/
		}
		
		if(count == -1)
		{
			products.add(new CustomerOrderLine(inProductId,inQuantity));
		}
		else
		{
			col = products.get(count);
			col.setQuantity(col.getQuantity()+inQuantity);
			products.set(count,col);
		}
	}
	
	public void clearBasket()
	{
		products.clear();
	}
}