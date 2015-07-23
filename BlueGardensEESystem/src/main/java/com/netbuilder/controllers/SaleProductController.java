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