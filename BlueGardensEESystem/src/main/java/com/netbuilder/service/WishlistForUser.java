package com.netbuilder.service;

import java.util.ArrayList;

import javax.inject.Inject;

import com.netbuilder.entities.Product;
import com.netbuilder.entities.WishlistItems;
import com.netbuilder.entitymanagers.ProductManager;
import com.netbuilder.entitymanagers.WishListManager;

/**
 * @author abalagel
 */

// @Stateless
public class WishlistForUser {
	@Inject
	private WishListManager wishListManager;
	@Inject
	private ProductManager productManager;

	public ArrayList<Product> getProductsForUser(String username) {
		ArrayList<WishlistItems> wli = wishListManager.findForUser(1);
		ArrayList<Product> ap = productManager.findAll();
		ArrayList<Product> wl = new ArrayList<Product>();
		for (WishlistItems w : wli) {
			for (int i = 0; i < ap.size(); i++)
				if (w.getProductID() == ap.get(i).getProductID()) {
					wl.add(productManager.findById(w.getProductID()));
				}
		}
		return wl;
	}

}