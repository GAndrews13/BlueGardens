package com.netbuilder.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.netbuilder.model.Product;
import com.netbuilder.controller.ProductManager;
import com.netbuilder.controller.Dummy.ProductManagerDummy;

/**
 * Handles input from the page and passes it to the logic contained within
 * products of intrest
 * 
 * @author Jake
 *
 */
@Controller
public class SearchController {
	private ProductManagerDummy productManager;
	private String searchTerm;
	private ArrayList<Product> results;
	private String msg = "Please enter a product name to search for";

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public SearchController() {
	}

	public SearchController(String searchTerm) {
		this.searchTerm = searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setResults(ArrayList<Product> results) {
		this.results = results;
	}

	public ArrayList<Product> getResults() {
		return results;
	}

	public String search() {

		results = new ArrayList<Product>();

		for (Product p : productManager.findAll()) {

			if (p.getProductName().toLowerCase()
					.contains(searchTerm.toLowerCase())) {
				results.add(p);
			}

			if (results.size() > 30) {
				return "jsearch";
			}
		}

		if (results.isEmpty()) {
			msg = "No product found please enter a product name";
			return "jsearch";
		}

		msg = results.size() + " result(s) found";

		return "jsearch";
	}

	@RequestMapping("/productSearch")
	public ModelAndView productSearch(@RequestParam (required=false) Map<String,String> requestParams){
		ModelAndView mv = new ModelAndView("productSearch");

		try
		{
			results = new ArrayList<Product>();
			results = productManager.findAll();
			String infoRequest;
		
			ArrayList<Product> returnList = new ArrayList<Product>();
			
			if(requestParams.containsKey("productName"))
			{
				infoRequest = requestParams.get("productName");
				for(Product p : results)
				{
					if(p.getProductName().contains(infoRequest))
					{
						returnList.add(p);
					}
				}
			}
			else if(requestParams.containsKey("productID"))
			{
				infoRequest=requestParams.get("productID");
				for(Product p : results)
				{
					if(p.getProductID() == Long.parseLong(infoRequest))
					{
						returnList.add(p);
						break;
					}
				}
			}
			
			for(Product p: returnList)
			{
				//add all products to the MV
				
			}
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
		return mv;
	}

}