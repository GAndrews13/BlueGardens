package com.netbuilder.entitymanagers;

import java.util.ArrayList;

import com.netbuilder.entities.Product;

public interface ProductManager {

	public void persistProduct(Product product);
	public void persistProducts(ArrayList<Product> products);
	
	public void updateProduct(Product product);
	
	public ArrayList<Product> findByName(String name);
	public ArrayList<Product> findByPrice(double price);
	public ArrayList<Product> findByOutStock();
	public Product findById(long id);
	public ArrayList<Product> findAll();
}