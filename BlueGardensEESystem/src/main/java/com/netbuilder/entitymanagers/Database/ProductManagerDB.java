package com.netbuilder.entitymanagers.Database;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.netbuilder.BlueGardensEESystem.PersistenceManager;
import com.netbuilder.customannotations.MethodAuthor;
import com.netbuilder.entities.Product;
import com.netbuilder.entitymanagers.ProductManager;
/**
 * 
 * @author gandrews
 * Allows products from the database to be interacted with within the system
 */
@Alternative
public class ProductManagerDB implements ProductManager {
	@Inject
	private PersistenceManager pm;
	
	@MethodAuthor (name = "Gandrews")
	public void persistProduct(Product product) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		
		em.persist(product);
		
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	@MethodAuthor (name = "Gandrews")
	public void persistProducts(ArrayList<Product> products) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		
		for(Product product : products)
		{
			em.persist(product);
		}
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	@MethodAuthor (name = "Gandrews")
	public void updateProduct(Product product) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		
		em.merge(product);
		
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}
	
	@MethodAuthor (name = "Gandrews")
	public ArrayList<Product> findByName(String name) {
		EntityManager em = pm.CreateEntityManager();
		ArrayList<Product> products = (ArrayList<Product>) em.createQuery("",Product.class).getResultList();
		pm.CloseEntityManager(em);
		try
		{
			return products;
		}
		catch (Exception e)
		{
			return null;
		}
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

	public ArrayList<Product> findByPriceLessThan(double price) {
		// TODO Auto-generated method stub
		return null;
	}

}
