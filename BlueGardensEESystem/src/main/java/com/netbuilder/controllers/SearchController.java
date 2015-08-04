package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import com.netbuilder.entities.Product;
import com.netbuilder.entitymanagers.ProductManager;

/**
 *  Handles input from the page and passes it to the logic contained within products of intrest
 * @author Jake
 *
 */
@ManagedBean(name = "searchController")
@RequestScoped
public class SearchController {
	@Inject
	private ProductManager productManager;
	private String searchTerm;
	private String msg = "Please enter a product name to search for";
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	private ArrayList<Product> results;
	
	public SearchController(){
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
		if(searchTerm != null)
		{
			System.out.println(searchTerm + " searchTerm");
			this.results = productManager.findByName(searchTerm);
			System.out.println(results);
			if(results.isEmpty())
			{
				msg = "No product found please enter a product name";
				
			}
		    else
			{
		    	msg = "Product found";
				//searchTerm = "";
				return "jsearch";
			}
			
		}
		else
		{
			msg = "Nothing Entered, Please enter a product";
			//searchTerm = "";
		}
		return "jsearch";
	}


}