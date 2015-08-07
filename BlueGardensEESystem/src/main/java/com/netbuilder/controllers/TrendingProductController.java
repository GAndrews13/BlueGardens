package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Product;
import com.netbuilder.service.ProductsOfIntrest;

/**
 * @author lczornyj
 * 
 * This is the trending products controller which is used in the landing page.
 * The logic used behind this method can be found in the service layer.
 */
@Named
@Dependent
public class TrendingProductController {
	@Inject
	private ProductsOfIntrest poi;
	private ArrayList<Product> trendingProducts;

	public TrendingProductController() { trendingProducts = poi.getTrending(); }

	public ArrayList<Product> getTrendingProducts() { return trendingProducts; }
}