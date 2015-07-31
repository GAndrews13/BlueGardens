package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
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

	public void persistWishlist(Wishlist wishlist) {
		dd.setWishlist(wishlist);	
	}

	public void persistWishlists(ArrayList<Wishlist> wishlists) {
		dd.setWishlists(wishlists);		
	}

	public void updateWishlist(Wishlist wishlist) {
		for(int i=0; i<dd.getWishlists().size(); i++){
			if(wishlist.getCustomerID() == dd.getWishlists().get(i).getCustomerID()){
				dd.setWishlist(wishlist);
			}
		}		
	}

	public void removeProduct(int productID, long customerID) {
		ArrayList<Product> products = new ArrayList<Product>();
		for(Wishlist w : dd.getWishlists()){
			if(w.getCustomerID() == customerID){
				products = w.getProducts();
				for(Product p : products){
					if(p.getProductID()==productID){
						products.remove(p);
					}
				}	
			}
		}
	}

	public Wishlist findForUser(long customerID) {
		ArrayList<Product> products = new ArrayList<Product>();
		Wishlist wishlist = new Wishlist(customerID, products);
		for(Wishlist w : dd.getWishlists()) {
			if (w.getCustomerID() == customerID)
				products.addAll(w.getProducts());
		}
		return wishlist;
	}	
}