package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Product;
import com.netbuilder.service.ProductsOfIntrest;

@Named
@Dependent
public class SaleProductController {
	@Inject
	private ProductsOfIntrest poi;
	public ArrayList<Product> saleProducts;
	public ArrayList<Product> catalogueSale;
	
	public SaleProductController() {
		saleProducts = poi.getFourSale();
		
		//Get three products that are one sale
		catalogueSale = poi.getThreeSale();
	}
}