package com.netbuilder.entitymanagers.Dummy;
import java.util.ArrayList;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.netbuilder.entities.WishlistItems;
import com.netbuilder.entitymanagers.WishListManager;
import com.netbuilder.util.DummyData;

/**
 * 
 * @author Anca
 *	Uses a dummy wishlist object to imitate its real interactions with the system
 */
@Alternative
public class WishlistManagerDummy implements WishListManager {
	@Inject
	private DummyData dd;
	
	public void persistWishlistItem(WishlistItems wishlistitem) {
		dd.setWishlistItems(wishlistitem);
	}

	public void persistWishlistItems(ArrayList<WishlistItems> wishlistitems) {
		dd.setWishlistProducts(wishlistitems);
	}

	public void removeProduct(int productID, long customerID) {
		for(int i=0; i<dd.getWishlistProducts().size(); i++) {
			if(productID == dd.getWishlistProducts().get(i).getProductID() && customerID == dd.getWishlistProducts().get(i).getCustomerID())
				dd.getWishlistProducts().remove(i);
		}
	}

	public ArrayList<WishlistItems> findForUser(long customerID) {
		ArrayList<WishlistItems> list = new ArrayList<WishlistItems>();
		for(int i=0; i<dd.getWishlistProducts().size(); i++) {
			if(customerID == dd.getWishlistProducts().get(i).getCustomerID())
				list.add(dd.getWishlistProducts().get(i));
		}		
		return list;
	}
}