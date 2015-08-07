package com.netbuilder.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.netbuilder.entities.Product;
import com.netbuilder.entitymanagers.ProductManager;

/**
 * Created Controller for the specific product page. The products are found via the products Image link,
 * therefor all products need to have an image or a location for an image in order to follow through to
 * the specific product page. There is also some validation for if the product id does not exist.
 * @author lczornyj
 */
@ManagedBean(name = "productController")
@SessionScoped
public class ProductController {
	@Inject
	private ProductManager productManager;
	@Inject
	WishListController wishlistController;
	@Inject
	private LoginController lc;
	public String link;
	private Product product;
	private int currentID;
	
	public ProductController(){ }

	@GET
	@Path("productPage.xhtml")
	public void getProductByID
		(@DefaultValue("1") @QueryParam("product") String pid) {
		System.out.println("WORKING!");
		pid = pid.replace("[","");
		pid = pid.replace("]","");
		product= productManager.findById(Integer.parseInt(pid));
		System.out.println("WORKING!!!");
	}
	
	public void search(int inID) {
		System.out.println(inID);
		this.product=productManager.findById(inID);
	}

	public String getLink() { return link; }
	public int getCurrentID() { return currentID; }
	public Product getProduct() { return product; }
	
	public void setLink(String link) { this.link = link; }
	public void setCurrentID(int currentID) { this.currentID = currentID; }
	public void setProduct(Product product) { this.product = product; }
}