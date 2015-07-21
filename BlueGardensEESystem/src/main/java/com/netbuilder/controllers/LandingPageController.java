package com.netbuilder.controllers;
/**
 * Created controller for landing page, currently not working due to requiring the service layer to
 * do the logic behind finding the products and ensuring that no duplicates occur.
 * @author lczornyj
 */
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Product;
import com.netbuilder.service.ProductsOfIntrest;




@Named
@RequestScoped
public class LandingPageController {
	
	@Inject
	private ProductsOfIntrest poi;
	public ArrayList<Product> saleProducts;
	public ArrayList<Product> newProducts;

	
	public LandingPageController () {
		saleProducts = poi.getFourSale();
		newProducts = poi.getThreeNew();
		
	}
}