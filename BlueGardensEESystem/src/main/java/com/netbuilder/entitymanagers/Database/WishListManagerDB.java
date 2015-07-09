package com.netbuilder.entitymanagers.Database;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.netbuilder.BlueGardensEESystem.PersistenceManager;
import com.netbuilder.entities.Customer;
import com.netbuilder.entities.Product;
import com.netbuilder.entitymanagers.WishListManager;

/**
 * 
 * @author gandrews
 *	Interfaces the database and the Wishlist entity
 */
@Alternative
public class WishListManagerDB implements WishListManager {
@Inject
private PersistenceManager pm;
	
	public void persistWishlist(Customer inCustomer) {
		// TODO Auto-generated method stub
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		
		//TODO
		
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	public void updateWishlist(Product inProduct) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		
		em.persist(p);
		
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	public void updateWishlist(ArrayList<Product> inProductList) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();

		for(Product p : inProductList)
		{
			em.persist(p);
		}
		
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	public void removeProduct(Product inProduct) {
		// TODO Auto-generated method stub
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();

		em.remove(inProduct);
		
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	public void removeProducts(ArrayList<Product> inProductList) {
		// TODO Auto-generated method stub
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();

		for(Product p : inProductList)
		{
			em.remove(p);
		}
		
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	public ArrayList<Product> findProductByName(String inName) {
		ArrayList<Product> pr = new ArrayList<Product>();
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();

		pr = (ArrayList<Product>) em.createQuery("SELECT * FROM Product WHERE inName=Product.ProductName ",Product.class).getResultList();
		
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
		return pr;
	}

	public Product findProductByID(int inID) {
		// TODO Auto-generated method stub
		Product pr = null;
		EntityManager em = pm.CreateEntityManager();

		pr = em.createNamedQuery("SELECT * FROM Product.ProductID where ID=inID", Product.class).getSingleResult();
		
		pm.CloseEntityManager(em);
		return pr;
	}

	public ArrayList<Product> findAll() {
		ArrayList<Product> pr = new ArrayList<Product>();
		EntityManager em = pm.CreateEntityManager();
		
		pr = (ArrayList<Product>) em.createQuery("SELECT * FROM wishlist",Product.class).getResultList();
		
		pm.CloseEntityManager(em);
		return pr;
	}

}
