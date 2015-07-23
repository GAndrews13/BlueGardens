package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;

import com.netbuilder.entities.Product;
import com.netbuilder.entities.Wishlist;
import com.netbuilder.entitymanagers.WishListManager;

/**
 * 
 * @author Anca
 *	Uses a dummy wishlist object to imitate its real interactions with the system
 */
@Alternative
public class WishlistManagerDummy implements WishListManager {
	ArrayList<Wishlist> wishlists;
	
	public WishlistManagerDummy() {
		wishlists = new ArrayList<Wishlist>();
	}

	@Override
	public void persistWishlist(Wishlist wishList) {
		wishlists.add(wishList);
	}

	@Override
	public void updateWishlist(Wishlist wishList) {
		wishlists.set(wishlists.indexOf(wishList), wishList);
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