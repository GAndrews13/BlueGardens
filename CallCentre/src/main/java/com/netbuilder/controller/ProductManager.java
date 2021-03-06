package com.netbuilder.controller;

import java.util.ArrayList;

import com.netbuilder.model.Product;

/**
 * 
 * @author James
 *
 */
public interface ProductManager {

	public void persistProduct(Product product);

	public void persistProducts(ArrayList<Product> products);

	public void updateProduct(Product product);

	public ArrayList<Product> findByName(String name);

	public ArrayList<Product> findByPrice(double price);

	public ArrayList<Product> findByOutStock();

	public Product findById(int id);

	public ArrayList<Product> findAll();

	public ArrayList<Product> findByPriceLessThan(double price);

	public Product findByImageLink(String link);

	/**
	 * @author lczornyj
	 * @param isSale
	 * @return Added the find by sale, poursousware and trending methods to the
	 *         entity manager.
	 */
	public ArrayList<Product> findBySale();

	public ArrayList<Product> findByPourousware(boolean isPourousware);

	public ArrayList<Product> findByTrending();
}