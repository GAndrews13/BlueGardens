package com.netbuilder.controller;
 
/**
 * @author jmander
 * @author GAndrews
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
 
/**
 * Initial control method run when the user first accesses the basket page
 * @author gandrews
 *
 */
@Controller
public class BasketController { 
	/**
	 * The array containing the customer order line refering to the products that the customer wish to purchase
	 */
	static private ArrayList<CustomerOrderLine> products = new ArrayList<CustomerOrderLine>();
	/**
	 * The customer which the basket is being assigned to
	 */
	static private Customer customer;

	/**
	 * The method that is run when the basket page is navigated to
	 * @param requestParams
	 * @return
	 */
	@RequestMapping("/basket")
	public ModelAndView showMessage(@RequestParam (required = false) Map<String,String> requestParams)
	{ 
		//These contain the methods and data that will be required 
		CustomerManagerDummy customerManager = new CustomerManagerDummy();
		CustomerOrderManagerDummy customerOrderManager = new CustomerOrderManagerDummy();
		ProductManagerDummy productManager = new ProductManagerDummy();
		
		//ModelAndView contains all the information that can be passed back to the JSP pages
		ModelAndView mv = new ModelAndView("basket");
		
		int quantity = 1;
		//If the basket has a clear command within the query string the basket is emptied
		if(requestParams.containsKey("clear"))
		{
			clearBasket();
		}
		else
		{
			//if the basket contains a userId assign it, if not check that the user is assigned or alert the sales person that the basket has no assigned customer
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
			//If the basket contains a product Id then add this to the basket
			if(requestParams.containsKey("productId"))
			{
				//If the basket contains a quantity then overwrite the inital value of 1
				if(requestParams.containsKey("qnt"))
				{
					quantity = Integer.parseInt(requestParams.get("qnt"));
				}
				
				addProduct(Integer.parseInt(requestParams.get("productId")), quantity);
			}
		}
		//Adding items to the mv means that they can accessed by the web page
		//Format: mv.addObject(items name that can be placed on the JSP to access, the actual data that is assigned to the name);
		mv.addObject("customer",customer);
		mv.addObject("customerOrderID",(customerOrderManager.findAll().size()+1));
		mv.addObject("products", products);
		System.out.println(products.size());
		return mv;
	}
	
	/**
	 * Adds a product to the basket, if the basket already contains the product it amends the quantity
	 * @param inProductId The ID given to the product that wants to be added/amended within the basket
	 * @param inQuantity the quantity by which the products will be added to the basket
	 */
	private void addProduct(int inProductId, int inQuantity)
	{
		CustomerOrderLine col;
		int count = -1;
		
		//Searches through the customer order lines that are stored and assigns count the id of the item in regards to the array list size
		for(int i = 0;i<products.size();i++)
		{
			col = products.get(i);
			if(col.getProductId() == inProductId)
			{
				count = i;
				break;
			}
		}
		//if the count is -1 it means the item has no customer order line and requires a new one 
		//if the code returns something equal to or greater than 0 then the customer order line adjusts the quantity
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
	
	/**
	 * Clears the basket of all Customer order lines
	 * WARNING: cannot be undone
	 */
	public void clearBasket()
	{
		products.clear();
	}
}