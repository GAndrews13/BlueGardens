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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

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
	private int currentID;
	
	public ProductController(){
	}

	@GET
	@Path("wishlist.xhtml")
	public String getProductByID
		(@QueryParam("id") String pid){
		//System.out.println(pid);
		String temp = pid.replace("http://localhost:8080/BlueGardensEESystem/productPage.xhtml?product=", "");
		product= productManager.findById(Integer.parseInt(temp));
		//System.out.println(temp);
		currentID = product.getProductID();
		//System.out.println(currentID);
		return pid;
	}
	
	//public void getcurrentProduct()
	
	public int getCurrentID() {
		return currentID;
	}

	public void setCurrentID(int currentID) {
		//System.out.println(currentID);
		this.currentID = currentID;
		System.out.println(this.currentID);
	}

	public void search(int inID) {
		//System.out.println(this.link.substring(1, this.link.length()-1));
		//this.product = productManager.findByImageLink(this.link.substring(1, this.link.length()-1));
		System.out.println(inID);
		this.product=productManager.findById(inID);
		//System.out.println(product);
		//return "productPage";
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
