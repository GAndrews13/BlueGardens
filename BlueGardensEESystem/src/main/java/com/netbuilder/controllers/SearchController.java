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
	private ArrayList<Product> results;
	private String msg = "Please enter a product name to search for";
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
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
		
		results = new ArrayList<Product>();
		
		for(Product p: productManager.findAll()){

			if(p.getProductName().toLowerCase().contains(searchTerm.toLowerCase())){
				results.add(p);
			}
			
			if(results.size()>30){
				return "jsearch";
			}
		}
		
		if(results.isEmpty()) {
			msg = "No product found please enter a product name";
			return"jsearch";
		}
		
		msg = results.size() + " result(s) found";
		
		return "jsearch";
	}


}