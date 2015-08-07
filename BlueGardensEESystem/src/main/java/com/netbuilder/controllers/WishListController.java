package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.netbuilder.entities.Product;
import com.netbuilder.entities.WishlistItems;
import com.netbuilder.entitymanagers.ProductManager;
import com.netbuilder.entitymanagers.WishListManager;
import com.netbuilder.util.LoggedInUser;

/**
 * @author abalagel
 * @author jmander
 *
 */
@ManagedBean(name = "wishlistController")
@RequestScoped
public class WishListController {
	@Inject
	private WishListManager wishlistManager;
	@Inject
	private ProductManager productManager;
	@Inject
	private LoggedInUser loggedInUser;
	private ArrayList<WishlistItems> results;
	private ArrayList<Product> realResults = new ArrayList<Product>();
	
	public WishListController() { }

	public String search() {
		this.results = wishlistManager.findForUser(loggedInUser.getUserID());
		for(int i=0; i<results.size();i++) {
			realResults.add(productManager.findById(results.get(i).getProductID()));
		}
		return "wishlist";
	}

	public ArrayList<Product> getRealResults() { return realResults; }
	public ArrayList<WishlistItems> getResults() { return results; }

	public void setRealResults(ArrayList<Product> realResults) { this.realResults = realResults; }
	public void setResults(ArrayList<WishlistItems> results) { this.results = results; }
}