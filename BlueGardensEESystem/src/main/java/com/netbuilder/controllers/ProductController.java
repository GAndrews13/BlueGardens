package com.netbuilder.controllers;

/**
 * Created Controller for the specific product page. The products are found via the products Image link,
 * therefor all products need to have an image or a location for an image in order to follow through to
 * the specific product page. There is also some validation for if the product id does not exist.
 * @author lczornyj
 */
import java.util.ArrayList;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Product;
import com.netbuilder.entitymanagers.ProductManager;

@Named
@Dependent
public class ProductController {

	@Inject
	private ProductManager productmanager;
	@Inject 
	private TrendingProductController tpc;
	
	private ArrayList<Product> trendingProducts;
	private Product product;
	public String errormsg;

	private String id = getProduct().getImageLink();
	
	public ProductController() {
		id = id.replace("www.NBGardens.com/Products/", "");
		try {
			setProduct(productmanager.findById(Integer.parseInt(id)));
		} catch (Exception e) {
			errormsg = "please enter details";
		}
		
		trendingProducts = tpc.trendingProducts;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
