package com.netbuilder.controllers;
/**
 * @author lczornyj
 * 
 * This is the sale products controller, this contains the sale items used in the landing page.
 */
import java.util.ArrayList;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Product;
import com.netbuilder.service.ProductsOfIntrest;

@Named
@Dependent
public class PourouswareProductController {
	@Inject
	private ProductsOfIntrest poi;
	private ArrayList<Product> pourouswareProducts;
	
	public ArrayList<Product> getPourouswareProducts() {
		return pourouswareProducts;
	}

	public PourouswareProductController() {
		pourouswareProducts = poi.getPourous();
	}
}