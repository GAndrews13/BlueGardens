package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.netbuilder.BlueGardensEESystem.PersistenceManager;
import com.netbuilder.entities.Product;
import com.netbuilder.entitymanagers.ProductManager;

/**
 * 
 * @author gandrews
 * Uses a list of products to mimic database behaviour
 */
@Default
public class ProductManagerDummy implements ProductManager {
ArrayList<Product> products = new ArrayList<Product>();
	@Inject
	private PersistenceManager pm;

	public void persistProduct(Product product) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		products.add(product);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	public void persistProducts(ArrayList<Product> products) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		
		this.products.addAll(products);
		
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	public void updateProduct(Product product) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		
		products.set(products.indexOf(product), product);

		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	public ArrayList<Product> findByName(String name) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		
		ArrayList<Product> list = new ArrayList<Product>();
		for(Product p : products)
		{
			if (p.getProductName().equals(name))
				list.add(p);
		}

		em.getTransaction().commit();
		pm.CloseEntityManager(em);
			
		return list;
	}

	public ArrayList<Product> findByPrice(double price) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		
		ArrayList<Product> list = new ArrayList<Product>();
		for(Product p : products)
		{
			if(p.getPrice() == price)
			{
				list.add(p);
			}
		}

		em.getTransaction().commit();
		pm.CloseEntityManager(em);
		
		return list;
	}

	public ArrayList<Product> findByOutStock() {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		
		ArrayList<Product> list = new ArrayList<Product>();
		for(Product p : products)
		{
			if(p.getStockLevel() == 0)
			{
				list.add(p);
			}
		}

		em.getTransaction().commit();
		pm.CloseEntityManager(em);
		
		return list;
	}

	public Product findById(long id) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		
		for(Product p : products)
		{
			if(p.getProductID() == id)
			{
				return p;
			}
		}

		em.getTransaction().commit();
		pm.CloseEntityManager(em);
		
		return null;
	}

	public ArrayList<Product> findAll() {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		
		return products;
	}

	public ArrayList<Product> findByPriceLessThan(double price)
	{
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		
		ArrayList<Product> list = new ArrayList<Product>();
		for(Product p : products)
		{
			if(p.getPrice() <= price)
			{
				list.add(p);
			}
		}

		em.getTransaction().commit();
		pm.CloseEntityManager(em);
		
		return list;
	}
}
