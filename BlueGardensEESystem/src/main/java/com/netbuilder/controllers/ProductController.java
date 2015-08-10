package com.netbuilder.controllers;

/**
 * Created Controller for the specific product page. The products are found via the products Image link,
 * therefor all products need to have an image or a location for an image in order to follow through to
 * the specific product page. There is also some validation for if the product id does not exist.
 * @author lczornyj
 */

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;

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
	private ArrayList<Product> trendingProducts;
	private ArrayList<Product> porousProducts;
	private ArrayList<Product> saleProducts;
	public ArrayList<Product> getTrendingProducts() {
		return trendingProducts;
	}

	public void setTrendingProducts(ArrayList<Product> trendingProducts) {
		this.trendingProducts = trendingProducts;
	}

	public ArrayList<Product> getPorousProducts() {
		return porousProducts;
	}

	public void setPorousProducts(ArrayList<Product> porousProducts) {
		this.porousProducts = porousProducts;
	}

	public ArrayList<Product> getSaleProducts() {
		return saleProducts;
	}

	public void setSaleProducts(ArrayList<Product> saleProducts) {
		this.saleProducts = saleProducts;
	}

	public void pullCatalog() {
		trendingProducts = new ArrayList<Product>();
		porousProducts = new ArrayList<Product>();
		saleProducts = new ArrayList<Product>();
		for(int i=0; i<3; i++){
			trendingProducts.add(productManager.findByTrending().get(i));
			porousProducts.add(productManager.findByPourousware(true).get(i));
		}
		for(int i=0; i<4; i++){
			saleProducts.add(productManager.findBySale().get(i));
		}
	}

	public ProductController() {
	}

	@GET
	// @Path("productPage.xhtml")
	public void getProductByID() {
		HttpServletRequest hsr = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		String pid = hsr.getQueryString();
		System.out.println(pid);
		pid = pid.replace("[", "");
		pid = pid.replace("]", "");
		pid = pid.replace("product=", "");
		product = productManager.findById(Integer.parseInt(pid));
		pullCatalog();
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
