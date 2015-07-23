package com.netbuilder.entitymanagers;

import java.util.ArrayList;

import com.netbuilder.entities.Product;
import com.netbuilder.entities.Wishlist;

/**
 * 
 * @author gandrews
 *
 */
public interface WishListManager {

	public void persistWishlist(Wishlist wishList);

	public void updateWishlist(Wishlist wishList);
	public void updateWishlists(ArrayList<Wishlist> wishlists);
	
	public void removeProduct(Wishlist wishList);
	public void removeProducts(ArrayList<Wishlist> wishlists);

	public ArrayList<Product> findForUser(long customerID);
}
