package com.netbuilder.controllers;
/**
 * @author lczornyj
 * 
 * Implemented new product controller. This controller will be used in the service layer to determine the
 * products used throughout the webpage based on the logic in the service layer.
 */
import java.util.ArrayList;

import javax.enterprise.context.Dependent;
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