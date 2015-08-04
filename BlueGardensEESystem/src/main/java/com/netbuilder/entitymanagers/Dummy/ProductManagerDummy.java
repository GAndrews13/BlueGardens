package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import com.netbuilder.entities.Product;
import com.netbuilder.entitymanagers.ProductManager;
import com.netbuilder.util.DummyData;

/**
 * 
 * @author gandrews
 * Uses a list of products to mimic database behaviour
 */
@Alternative
public class ProductManagerDummy implements ProductManager {

	@Inject
	private DummyData dd;

	public void persistProduct(Product product) {
		dd.setProduct(product);
	}

	public void persistProducts(ArrayList<Product> products) {
		dd.setProducts(products);
	}

	public void updateProduct(Product product) {	
		for(int i=0; i<dd.getProducts().size(); i++){
			if(product.getProductID() == dd.getProducts().get(i).getProductID()){
				dd.setProduct(product);
			}
		}
	}

	public ArrayList<Product> findByName(String name) {
		ArrayList<Product> list = new ArrayList<Product>();
		for(Product p : dd.getProducts())
		{
			if (p.getProductName().equals(name))
				list.add(p);
		}	
		return list;
	}

	public ArrayList<Product> findByPrice(double price) {
		ArrayList<Product> list = new ArrayList<Product>();
		for(Product p : dd.getProducts())
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
		for(Product p : dd.getProducts())
		{
			if(p.getStockLevel() == 0)
			{
				list.add(p);
			}
		}
		return list;
	}

	public Product findById(int id) {
		for(Product p : dd.getProducts())
		{
			if (p.getProductID()==id){
				return p;
			}
		}	
		return null;
	}

	public ArrayList<Product> findAll() {
		return dd.getProducts();
	}

	public ArrayList<Product> findByPriceLessThan(double price)
	{
		ArrayList<Product> list = new ArrayList<Product>();
		for(Product p : dd.getProducts())
		{
			if(p.getPrice() <= price)
			{
				list.add(p);
			}
		}
		return list;
	}

	/**
	 * Added methods for dummy connection to find whether a product is in the sale or not
	 * @author lczornyj
	 * 
	 */
	public ArrayList<Product> findBySale() {
		ArrayList<Product> list = new ArrayList<Product>();
		for (Product p : dd.getProducts())
		{
			if(p.isSale() == true){
				list.add(p);				
			}
		}
		return list;
	}
	
	/**
	 * Added method for dummy connection to find whether a product contains pourousware or not.
	 * @author lczornyj
	 */
	
	public ArrayList<Product> findByPourousware(boolean isPourousware) {
		ArrayList<Product> list = new ArrayList<Product>();
		for (Product p : dd.getProducts())
		{
			if(p.isPorousware() == isPourousware){
				list.add(p);				
			}
		}
		return list;
	}
	/**
	 * Added method for dummy connection to find whether or not  product is trending
	 * @author lczornyj
	 */
	public ArrayList<Product> findByTrending() {
		
		ArrayList<Product> list = new ArrayList<Product>();
		for (Product p : dd.getProducts()){
			if(p.isTrending() == true){
				list.add(p);
			}
		}
		return list;
	}
}
