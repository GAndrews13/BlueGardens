package com.netbuilder.service;

import java.util.ArrayList;
import java.util.Random;

import javax.ejb.Singleton;
import javax.inject.Inject;

import com.netbuilder.entities.Product;
import com.netbuilder.entitymanagers.ProductManager;

/**
 * used to create and hold the 'hot' products.
 * This is the products of interest class inside the service layer.
 * This will contain all the logic behind selecting which products will be displayed on specific pages.
 * 
 * @author jthompson & lczornyj
 *
 */
@Singleton
public class ProductsOfIntrest {

	@Inject
	private ProductManager productManager;
	private ArrayList<Product> saleList;
	private ArrayList<Product> trendingList;
	private ArrayList<Product> pourouswareList;
	private ArrayList<Product> sale = new ArrayList<Product>();
	private ArrayList<Product> pourous = new ArrayList<Product>();
	private ArrayList<Product> trending = new ArrayList<Product>();
	private String[] order = new String[3];
	
	public ProductsOfIntrest() {
		saleList = productManager.findBySale();
		trendingList = productManager.findByTrending();
		pourouswareList = productManager.findByPourousware(true);
		getProducts();
	}
	
	/**
	 * creates 3 lists of three unique products for products on sale, pourous and trending that can be accessed through getters :
	 * getSale(), getPourous() and getTrending().
	 */
	public void getProducts() {	
		ArrayList<ArrayList<Product>> lists = listSizes();
		for (int i = 0; i <3; i++) {
			switch(order[i].toString()) {
				case "sale" :
					for (int j = 0; j < 3; j++) {
						sale.add(lists.get(0).get(chosen(lists)));
					}
					break;
				case "pourous" :
					for (int j = 0; j < 3; j++) {
						pourous.add(lists.get(0).get(chosen(lists)));
					}
					break;
				case "trending" :
					for (int j = 0; j < 3; j++) {
						trending.add(lists.get(0).get(chosen(lists)));
					}
					break;
			}
		}
	}
	
	private int chosen(ArrayList<ArrayList<Product>> lists) {
		Random generator = new Random();
		boolean unique = true;
		int a;
		do {
			unique = true;
			a = generator.nextInt(lists.get(0).size());
			for (Product sp : sale) {
				if (lists.get(0).get(a).getProductID() == sp.getProductID())
					unique = false;
			}
			for (Product pp : pourous) {
				if (lists.get(0).get(a).getProductID() == pp.getProductID())
					unique = false;
			}
			for (Product tp : trending) {
				if (lists.get(0).get(a).getProductID() == tp.getProductID())
					unique = false;
			}						
		} while (unique);
		return a;
	}
	
	/**
	 * This method determines which determines which of the 3 lists are the smallest and returns them in ascending order.
	 * index 0 = the smallest array
	 * index 1 = the second smallest array
	 * index 2 = the largest array
	 * (if they are all the same length then the order will be saleList, newList, trendingList)
	 * 
	 * @return returns an Array list of array lists of products.
	 */
	private ArrayList<ArrayList<Product>> listSizes(){
		ArrayList<ArrayList<Product>> list = new ArrayList<ArrayList<Product>>();
		if (saleList.size() <= pourouswareList.size()) {
			if(saleList.size() <= trendingList.size()) {
				list.set(0, saleList);
				order[0] = "sale";
				if (pourouswareList.size() <= trendingList.size()) {
					list.set(1, pourouswareList);
					order[1] = "pourous";
					list.set(2, trendingList);
					order[2] = "trending";
				} else {
					list.set(1, trendingList);
					order[1] = "trending";
					list.set(2, pourouswareList);
					order[2] = "pourous";
				}
			} else {
				list.set(0, trendingList);
				order[0] = "trending";
				list.set(1, saleList);
				order[1] = "sale";
				list.set(2, pourouswareList);
				order[2] = "pourous";
			}
		} else { 
			if (pourouswareList.size() <= trendingList.size()) {
				list.set(0, pourouswareList);
				order[0] = "pourous";
				if(saleList.size() <= trendingList.size()) {
					list.set(1, saleList);
					order[1] = "sale";
					list.set(2, trendingList);
					order[2] = "trending";
				} else {
					list.set(1, trendingList);
					order[1] = "trending";
					list.set(2, saleList);
					order[2] = "sale";
				}
			} else {
				list.set(0, trendingList);
				order[0] = "trending";
				list.set(1, pourouswareList);
				order[1] = "pourous";
				list.set(2, saleList);
				order[2] = "sale";
			}
		}
		return list;
	}

	public ArrayList<Product> getSale() { return sale; }
	public ArrayList<Product> getPourous() { return pourous; }
	public ArrayList<Product> getTrending() { return trending; }
	
	/**
	 * @author Jake
	 *  Check which fields are entered by the user and return the one with the most results first
	 *  In stock = most results
	 *  name = fewer results
	 *  id = only one result
	 */
	public ArrayList<Product> getSearchResults(long id, String name, boolean stock) 
		{
		ArrayList<Product> searchResults = new ArrayList<Product>();
		if(stock == true)
			{
				searchResults = productManager.findByOutStock();
				return searchResults;
			}
			else
			if(name != null)
			{
				searchResults = productManager.findByName(name);
				return searchResults;

			}
			else
				searchResults.set(0, productManager.findById(id));
				return searchResults;
		}
}