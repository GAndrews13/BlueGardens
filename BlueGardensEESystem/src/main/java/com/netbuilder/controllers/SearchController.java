package com.netbuilder.controllers;

import java.util.ArrayList;

import com.netbuilder.entities.Product;
import com.netbuilder.service.ProductsOfIntrest;
/**
 *  Handles input from the page and passes it to the logic contained within products of intrest
 * @author Jake
 *
 */
public class SearchController 
{
	//private long id;
	//private String name;
	//private boolean stock;
	private ArrayList <Product> results;
	private Product pResult;
	private ProductsOfIntrest search;
	public String errorMSG;
	
	public SearchController(int ID, String NAME, boolean STOCK)
	{
		try
		{
		results = search.getSearchResults(ID, NAME, STOCK);
		pResult = results.get(0);
		}
		catch(Exception e)
		{
			errorMSG = "Search failed please try again";
		}
	}

	public Product getpResult() {
		return pResult;
	}

	
}
