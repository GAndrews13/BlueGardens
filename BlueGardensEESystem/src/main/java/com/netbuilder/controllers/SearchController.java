package com.netbuilder.controllers;

import java.util.ArrayList;

import com.netbuilder.entities.Product;
import com.netbuilder.service.ProductsOfIntrest;

public class SearchController 
{
	private int id;
	private String name;
	private boolean stock;
	private ArrayList <Product> results;
	private Product pResult;
	private ProductsOfIntrest search;
	public String errorMSG;
	
	public SearchController()
	{
		try
		{
		results = search.getSearchResults(id, name, stock);
		pResult = results.get(0);
		}
		catch(Exception e)
		{
			errorMSG = "Search failed please try again";
		}
	}
	
}
