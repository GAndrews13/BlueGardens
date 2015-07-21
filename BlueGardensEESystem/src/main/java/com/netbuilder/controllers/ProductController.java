package com.netbuilder.controllers;

/**
 * Created Controller for the specific product page. The products are found via the products Image link,
 * therefor all products need to have an image or a location for an image in order to follow through to
 * the specific product page. There is also some validation for if the product id does not exist.
 * @author lczornyj
 */
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Product;
import com.netbuilder.entitymanagers.ProductManager;

@Named
@RequestScoped
public class ProductController {

	@Inject
	private ProductManager productmanager;

	public Product product;

	private String id = product.getImageLink();

	public ProductController() {
		id = id.replace("www.NBGardens.com/Products/", "");
		try {
			product = productmanager.findById(Integer.parseInt(id));
		} catch (Exception e) {
			String errormsg = "please enter details";

		}
	}
}
