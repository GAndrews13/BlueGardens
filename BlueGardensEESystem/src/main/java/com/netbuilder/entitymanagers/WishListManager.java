package com.netbuilder.entitymanagers;

import java.util.ArrayList;
import com.netbuilder.entities.WishlistItems;

/**
 * 
 * @author Anca
 * @author jmander
 *
 */
public interface WishListManager {
	public void persistWishlistItem(WishlistItems wishlistitem);
	public void persistWishlistItems(ArrayList<WishlistItems> wishlistitems);
	public void removeProduct(int productID, long customerID);
	public ArrayList<WishlistItems> findForUser(long customerID);	
}