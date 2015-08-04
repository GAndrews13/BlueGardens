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
		System.out.println(searchTerm);
		this.results = productManager.findByName(searchTerm);
		System.out.println(results);
			return "jsearch";
	}


}