package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Product;
import com.netbuilder.service.ProductsOfIntrest;

@Named
@Dependent
public class ProductCatalogController 
{
	@Inject
	private ProductsOfIntrest ProductCatalog;
	
	private ArrayList <Product> pwProducts;
	
	public ProductCatalogController()
	{
		//get three products that have porousware
		pwProducts = ProductCatalog.getThreePorousware();
	}
}
