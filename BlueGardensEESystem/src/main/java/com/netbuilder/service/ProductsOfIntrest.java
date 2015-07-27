package com.netbuilder.service;
/**
 * @author lczornyj
 * 
 * This is the products of interest class inside the service layer.
 * This will contain all the logic behind selecting which products will be displayed on specific pages.
 * 
 */
import java.util.ArrayList;

import com.netbuilder.BlueGardensEESystem.PersistenceManager;
import com.netbuilder.entities.Product;
import com.netbuilder.entitymanagers.Dummy.ProductManagerDummy;

public class ProductsOfIntrest {
    private PersistenceManager pm;
    private ArrayList<Product> products = new ArrayList<Product>();
    private ProductManagerDummy pmd = new ProductManagerDummy();
    private ArrayList<Product> saleList = new ArrayList<Product>();
    private ArrayList<Product> trendingList = new ArrayList<Product>();
    private ArrayList<Product> pourouswareList = new ArrayList<Product>();
    private Product product;
    
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
           ArrayList<ArrayList<Product>> list = new ArrayList<ArrayList<Product>>();
           if (saleList.size() <= pourouswareList.size()) {
                  if(saleList.size() <= trendingList.size()) {
                        list.set(0, saleList);
                        if (pourouswareList.size() <= trendingList.size()) {
                               list.set(1, pourouswareList);
                               list.set(2, trendingList);
                        } else {
                               list.set(1, trendingList);
                               list.set(2, pourouswareList);
                        }
                  } else {
                        list.set(0, trendingList);
                        list.set(1, saleList);
                        list.set(2, pourouswareList);
                  }
           } else { 
                  if (pourouswareList.size() <= trendingList.size()) {
                        list.set(0, pourouswareList);
                        if(saleList.size() <= trendingList.size()) {
                               list.set(1, saleList);
                               list.set(2, trendingList);
                        } else {
                               list.set(1, trendingList);
                               list.set(2, saleList);
                        }
                  } else {
                        list.set(0, trendingList);
                        list.set(1, pourouswareList);
                        list.set(2, saleList);
                  }
           }
           return list;
    }

	public ArrayList<Product> getFourSale() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Product> getThreeNew() {
		// TODO Auto-generated method stub
		return null;
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
