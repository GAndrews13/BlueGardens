package com.netbuilder.controllers;
/**
 * @author lczornyj
 * 
 * This is the trending products controller which is used in the landing page.
 * The logic used behind this method can be found in the service layer.
 */
import java.util.ArrayList;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Product;
import com.netbuilder.service.ProductsOfIntrest;

@Named
@Dependent
public class TrendingProductController {
	@Inject
	private ProductsOfIntrest poi;
	public ArrayList<Product> trendingProducts;
	public ArrayList<Product> catalogueTrending;

	public TrendingProductController() {
		trendingProducts = poi.getThreeTrending();
		
		//Get three products that are currently trending
		catalogueTrending = poi.getThreeTrending();
	}
}