package com.netbuilder.controllers;

/**
 * Created Controller for the specific product page. The products are found via the products Image link,
 * therefor all products need to have an image or a location for an image in order to follow through to
 * the specific product page. There is also some validation for if the product id does not exist.
 * @author lczornyj
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import com.netbuilder.entities.Product;
import com.netbuilder.entitymanagers.ProductManager;

@ManagedBean(name = "productController")
@SessionScoped
public class ProductController {
	@Inject
	private ProductManager productManager;
	@Inject
	WishListController wishlistController;
	public String link;
	private Product product;
	
	public ProductController(){
	}

	public String search() {
		System.out.println(this.link.substring(1, this.link.length()-1));
		this.product = productManager.findByImageLink(this.link.substring(1, this.link.length()-1));
		System.out.println(product);
		return "productPage";
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


}
