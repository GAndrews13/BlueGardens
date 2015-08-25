package com.netbuilder.controller.Dummy;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;

import com.netbuilder.model.Product;
import com.netbuilder.controller.ProductManager;
import com.netbuilder.model.Utility.DummyData;
import com.netbuilder.service.DummyDataLoader;

/**
 * 
 * @author gandrews Uses a list of products to mimic database behaviour
 */
@Alternative
public class ProductManagerDummy implements ProductManager {

	public void persistProduct(Product product) {
		DummyDataLoader.dd().setProduct(product);
	}

	public void persistProducts(ArrayList<Product> products) {
		DummyDataLoader.dd().setProducts(products);
	}

	public void updateProduct(Product product) {
		for (int i = 0; i < DummyDataLoader.dd().getProducts().size(); i++) {
			if (product.getProductID() == DummyDataLoader.dd().getProducts().get(i)
					.getProductID()) {
				DummyDataLoader.dd().setProduct(product);
			}
		}
	}

	public ArrayList<Product> findByName(String name) {
		ArrayList<Product> list = new ArrayList<Product>();
		for (Product p : DummyDataLoader.dd().getProducts()) {
			if (p.getProductName().equals(name))
				list.add(p);
		}
		return list;
	}

	public ArrayList<Product> findByPrice(double price) {
		ArrayList<Product> list = new ArrayList<Product>();
		for (Product p : DummyDataLoader.dd().getProducts()) {
			if (p.getPrice() == price) {
				list.add(p);
			}
		}
		return list;
	}

	public ArrayList<Product> findByOutStock() {
		ArrayList<Product> list = new ArrayList<Product>();
		for (Product p : DummyDataLoader.dd().getProducts()) {
			if (p.getStockLevel() == 0) {
				list.add(p);
			}
		}
		return list;
	}

	public Product findById(int id) {
		for (Product p : DummyDataLoader.dd().getProducts()) {
			if (p.getProductID() == id) {
				return p;
			}
		}
		return null;
	}

	public ArrayList<Product> findAll() {
		return DummyDataLoader.dd().getProducts();
	}

	public ArrayList<Product> findByPriceLessThan(double price) {
		ArrayList<Product> list = new ArrayList<Product>();
		for (Product p : DummyDataLoader.dd().getProducts()) {
			if (p.getPrice() <= price) {
				list.add(p);
			}
		}
		return list;
	}

	/**
	 * Added methods for dummy connection to find whether a product is in the
	 * sale or not
	 * 
	 * @author lczornyj
	 * 
	 */
	public ArrayList<Product> findBySale() {
		ArrayList<Product> list = new ArrayList<Product>();
		for (Product p : DummyDataLoader.dd().getProducts()) {
			if (p.isSale() == true) {
				list.add(p);
			}
		}
		return list;
	}

	/**
	 * Added method for dummy connection to find whether a product contains
	 * pourousware or not.
	 * 
	 * @author lczornyj
	 */

	public ArrayList<Product> findByPourousware(boolean isPourousware) {
		ArrayList<Product> list = new ArrayList<Product>();
		for (Product p : DummyDataLoader.dd().getProducts()) {
			if (p.isPorousware() == isPourousware) {
				list.add(p);
			}
		}
		return list;
	}

	/**
	 * Added method for dummy connection to find whether or not product is
	 * trending
	 * 
	 * @author lczornyj
	 */
	public ArrayList<Product> findByTrending() {

		ArrayList<Product> list = new ArrayList<Product>();
		for (Product p : DummyDataLoader.dd().getProducts()) {
			if (p.isTrending() == true) {
				list.add(p);
			}
		}
		return list;
	}

	public Product findByImageLink(String link) {
		for (Product p : DummyDataLoader.dd().getProducts()) {
			if (p.getImageLink().equals(link)) {
				return p;
			}
		}
		return null;
	}
}
