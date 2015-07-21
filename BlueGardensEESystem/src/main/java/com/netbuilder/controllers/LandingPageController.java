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
	private ArrayList<Product> saleProducts;
	private ArrayList<Product> newProducts;
	private ArrayList<Product> trendingProducts;
	@Inject
	private NewProductController npc;
	@Inject
	private SaleProductController spc;
	@Inject
	private TrendingProductController tpc;
	
	public LandingPageController () {
		saleProducts = spc.saleProducts;
		newProducts = npc.newProducts;
		trendingProducts = tpc.trendingProducts;
	}
}