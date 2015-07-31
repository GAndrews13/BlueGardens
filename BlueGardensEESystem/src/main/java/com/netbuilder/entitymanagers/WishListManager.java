package com.netbuilder.entitymanagers;

import java.util.ArrayList;

import com.netbuilder.entities.Wishlist;

/**
 * 
 * @author Anca
 *
 */
public interface WishListManager {

	public void persistWishlist(Wishlist wishlist);
	public void persistWishlists(ArrayList<Wishlist> wishlists);

	public void updateWishlist(Wishlist wishList);
	public void updateWishlists(ArrayList<Wishlist> wishlists);
	
	public void removeProduct(Wishlist wishlist);

	public Wishlist findForUser(long customerID);
	
}
