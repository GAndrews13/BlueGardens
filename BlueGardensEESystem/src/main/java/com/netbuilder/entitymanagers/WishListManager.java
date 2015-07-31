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
	
	public void removeProduct(int productID, long customerID);

	public Wishlist findForUser(long customerID);
	
}
