package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Product;
import com.netbuilder.service.ProductsOfIntrest;

@Named
@RequestScoped
public class SaleProductController {
	@Inject
	private ProductsOfIntrest poi;
	public ArrayList<Product> saleProducts;
	
	public SaleProductController() {
		saleProducts = poi.getFourSale();
	}
}