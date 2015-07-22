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
public class NewProductController {
	@Inject
	private ProductsOfIntrest poi;
	public ArrayList<Product> newProducts;
	
	public NewProductController() {
		newProducts = poi.getThreeNew();
	}
}