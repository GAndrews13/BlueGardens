package com.netbuilder.entitymanagers;

import java.util.ArrayList;

import com.netbuilder.entities.Product;

public class ProductManagerDummy implements ProductManager {
ArrayList<Product> products = new ArrayList<Product>();
	
	public void persistProduct(Product product) {
		products.add(product);
	}

	public void persistProducts(ArrayList<Product> products) {
		this.products.addAll(products);
	}

	public void updateProduct(Product product) {
		products.set(products.indexOf(product), product);
	}

	public ArrayList<Product> findByName(String name) {
		ArrayList<Product> list = new ArrayList<Product>();
		for(Product p : products)
		{
			if (p.getProductName().equals(name))
				list.add(p);
		}
			return list;
	}

	public ArrayList<Product> findByPrice(double price) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Product> findByOutStock() {
		// TODO Auto-generated method stub
		return null;
	}

	public Product findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
