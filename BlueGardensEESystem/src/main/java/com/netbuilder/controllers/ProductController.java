package com.netbuilder.controllers;

/**
 * Created Controller for the specific product page. The products are found via the products Image link,
 * therefor all products need to have an image or a location for an image in order to follow through to
 * the specific product page. There is also some validation for if the product id does not exist.
 * @author lczornyj
 */
import java.util.ArrayList;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Product;
import com.netbuilder.entitymanagers.ProductManager;

@Named
@Dependent
public class ProductController {

	@Inject
	private ProductManager productmanager;
	private Product product;
	private ArrayList<Product> products;
	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public String errormsg;

	private String id = getProduct().getImageLink();
	
	public ProductController() {
		id = id.replace("www.NBGardens.com/Products/", "");
		try {
			setProduct(productmanager.findById(Integer.parseInt(id)));
		} catch (Exception e) {
			errormsg = "please enter details";
		}
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
