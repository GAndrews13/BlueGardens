package com.netbuilder.entitymanagers.Database;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.netbuilder.BlueGardensEESystem.PersistenceManager;
import com.netbuilder.entities.Customer;
import com.netbuilder.entities.Product;
import com.netbuilder.entitymanagers.WishListManager;

/**
 * 
 * @author gandrews
 *
 */
@Alternative
public class WishListManagerDB implements WishListManager {
@Inject
private PersistenceManager pm;
	
	public void persistWishlist(Customer inCustomer) {
		// TODO Auto-generated method stub
		
	}

	public void updateWishlist(Product inProduct) {
		// TODO Auto-generated method stub

	}

	public void updateWishlist(ArrayList<Product> inProductList) {
		// TODO Auto-generated method stub

	}

	public void removeProduct(Product inProduct) {
		// TODO Auto-generated method stub

	}

	public void removeProducts(ArrayList<Product> inProductList) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Product> findProductByName(String inName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Product findProductByID(int inID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
