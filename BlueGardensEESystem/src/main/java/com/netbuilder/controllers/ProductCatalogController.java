package com.netbuilder.controllers;
import java.util.ArrayList;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Product;
import com.netbuilder.service.ProductsOfIntrest;
/**
 * @author Jake
 * Product Catalogue Controller to handle fetching the data 
 * from each group of products available
 */
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
