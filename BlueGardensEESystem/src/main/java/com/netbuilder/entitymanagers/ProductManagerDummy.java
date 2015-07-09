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
		ArrayList<Product> list = new ArrayList<Product>();
		for(Product p : products)
		{
			if(p.getPrice() == price)
			{
				list.add(p);
			}
		}
		return list;
	}

	public ArrayList<Product> findByOutStock() {
		ArrayList<Product> list = new ArrayList<Product>();
		for(Product p : products)
		{
			if(p.getStockLevel() == 0)
			{
				list.add(p);
			}
		}
		return list;
	}

	public Product findById(long id) {
		for(Product p : products)
		{
			if(p.getProductID() == id)
			{
				return p;
			}
		}
		return null;
	}

	public ArrayList<Product> findAll() {
		return products;
	}

	public ArrayList<Product> findByPriceLessThan(double price)
	{
		ArrayList<Product> list = new ArrayList<Product>();
		for(Product p : products)
		{
			if(p.getPrice() <= price)
			{
				list.add(p);
			}
		}
		return list;
	}
}
