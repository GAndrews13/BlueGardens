package com.netbuilder.entitymanagers;

import java.util.ArrayList;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.Product;

public interface WishListManager {

	public void persistWishlist(Customer inCustomer);
	
	public void updateWishlist(Product inProduct);
	public void updateWishlist(ArrayList<Product> inProductList);
	
	public void removeProduct(Product inProduct);
	public void removeProducts(ArrayList<Product> inProductList);
	
	public ArrayList<Product> findProductByName (String inName);
	public Product findProductByID (int inID);
	public ArrayList<Product> findAll();
}
