package com.netbuilder.service;
/**
 * @author lczornyj
 * 
 * This is the products of interest class inside the service layer.
 * This will contain all the logic behind selecting which products will be displayed on specific pages.
 * 
 */
import java.util.ArrayList;
import java.util.Random;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import com.netbuilder.BlueGardensEESystem.PersistenceManager;
import com.netbuilder.entities.Product;
import com.netbuilder.entitymanagers.Dummy.ProductManagerDummy;

public class ProductsOfIntrest {

	@Inject
	private PersistenceManager pm;
	private ArrayList<Product> products = new ArrayList<Product>();
	private ProductManagerDummy pmd = new ProductManagerDummy();
	private ArrayList<Product> saleList = new ArrayList<Product>();
	private ArrayList<Product> trendingList = new ArrayList<Product>();
	private ArrayList<Product> pourouswareList = new ArrayList<Product>();
	private Product product;
	private ArrayList<ArrayList<Product>> list = new ArrayList<ArrayList<Product>>();
	private Random generator = new Random();
	
	private int sale;
	private int pw;
	private int trending;
	
	public void  createLists(){
		for (int i = 0; i < products.size(); i++){
			if(product.isSale() == true){
				saleList.add(product);	
			}
			if(product.isTrending() == true){
				trendingList.add(product);
			}
			if(product.isPorousware() == true){
				pourouswareList.add(product);
			}
		}
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
	public ArrayList<ArrayList<Product>> listSizes(){
		if (saleList.size() <= pourouswareList.size()) {
			if(saleList.size() <= trendingList.size()) {
				list.set(0, saleList);
				sale = 0;
				if (pourouswareList.size() <= trendingList.size()) {
					list.set(1, pourouswareList);
					pw = 1;
					list.set(2, trendingList);
					trending = 2;
				} else {
					list.set(1, trendingList);
					trending = 1;
					list.set(2, pourouswareList);
					pw = 2;
				}
			} else {
				list.set(0, trendingList);
				trending = 0;
				list.set(1, saleList);
				sale = 1;
				list.set(2, pourouswareList);
				pw = 2;
			}
		} else { 
			if (pourouswareList.size() <= trendingList.size()) {
				list.set(0, pourouswareList);
				pw = 0;
				if(saleList.size() <= trendingList.size()) {
					list.set(1, saleList);
					sale = 1;
					list.set(2, trendingList);
					trending = 2;
				} else {
					list.set(1, trendingList);
					trending = 1;
					list.set(2, saleList);
					sale = 2;
				}
			} else {
				list.set(0, trendingList);
				trending = 0;
				list.set(1, pourouswareList);
				pw = 1;
				list.set(2, saleList);
				sale = 2;
			}
		}
		return list;
	}
	
	public void deleteDuplicate(ArrayList<Product> chosenList, int category) {
		
		
		
		
		
		int j = 0;
			for (int i = 0; i < list.get(i).size(); i++) {
				String currentname = list.get(j).get(i).getProductName();
				
						for(int a = 0; a < list.get(j+1).size(); a++) {
							if(list.get(j+1).get(i).getProductName() == currentname)
							{
								list.get(j+1).remove(i);
							}
							if(list.get(j+2).get(i).getProductName() == currentname)
							{
								list.get(j+2).remove(i);
							}
						}
					}
			j=j+1;
			for (int i = 0; i < list.get(i).size(); i++) {
				String currentname = list.get(j).get(i).getProductName();
				
						for(int a = 0; a < list.get(j+1).size(); a++) {
							if(list.get(j+1).get(i).getProductName() == currentname)
							{
			 					list.get(j+1).remove(i);
							}
					}
			}
	}
		
	
	public ArrayList<Product> getFourSale() {
		ArrayList<Product> chosen = new ArrayList<Product>();
		Product num1;
		for(int i = 0; i < 3; i++) {
			int randomProduct = generator.nextInt(list.get(sale).size());
			num1 = list.get(sale).get(randomProduct);
			
			chosen.add(num1);
		}
		deleteDuplicate(chosen,1);
		return chosen;
	}

	public ArrayList<Product> getThreeTrending() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Product> getThreePorousware() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Product> getThreeSale() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Product> getSearchResults(int id, String Name, boolean stock) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
