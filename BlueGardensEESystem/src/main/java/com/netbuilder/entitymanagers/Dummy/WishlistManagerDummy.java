package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.Product;
import com.netbuilder.entities.Wishlist;
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
	
	public void persistWishlist(ArrayList<Product> wishlist) {
		dd.setWishlist(wishlist);
	}

	public void persistWishlists(ArrayList<ArrayList<Product>> wishlists) {
		dd.setWishlists(wishlists);
	}

	public void updateWishlist(ArrayList<Product> wishlist) {	
		for(int i=0; i<dd.getWishlists().size(); i++){
			if(wishlist.getCustomerID == dd.getWishlists().get(i).getCustomerID()){
				dd.setWishlist(wishlist);
			}
		}
	}

	@Override
	public void updateWishlists(ArrayList<Wishlist> wishlists) {
		for(Wishlist w : wishlists) {
			this.wishlists.set(this.wishlists.indexOf(w), w);
		}
	}

	@Override
	public void removeProduct(Wishlist wishList) {
		wishlists.remove(wishlists.indexOf(wishList));
	}

	@Override
	public void removeProducts(ArrayList<Wishlist> wishlists) {
		for(Wishlist w : wishlists) {
			this.wishlists.remove(this.wishlists.indexOf(w));
		}
	}

	@Override
	public ArrayList<Product> findForUser(long customerID) {
		ArrayList<Product> products = new ArrayList<Product>();
		for(Wishlist w : wishlists) {
			if (w.getCustomerID() == customerID)
				products.addAll(w.getProducts());
		}
		return products;
	}
}