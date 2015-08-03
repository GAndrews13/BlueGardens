package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Product;
import com.netbuilder.entitymanagers.ProductManager;
import com.netbuilder.service.ProductsOfIntrest;
/**
 *  Handles input from the page and passes it to the logic contained within products of intrest
 * @author Jake
 *
 */
@Named
@RequestScoped
public class SearchController 
{
	//private long id;
	//private String name;
	//private boolean stock;
	private ArrayList <Product> results;
	private String searchTerm;
	@Inject
	private ProductManager productManager;
	
	
	public ArrayList<Product> getResults() { return results; }
	public String getSearchTerm() { return searchTerm; }
	public void setResults(ArrayList<Product> results) { this.results = results; }
	public void setSearchTerm(String searchTerm) { this.searchTerm = searchTerm; }
	
	public void searchByTerm() {
		results = productManager.findByName(searchTerm);
	}
}