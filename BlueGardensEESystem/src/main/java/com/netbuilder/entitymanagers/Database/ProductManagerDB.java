package com.netbuilder.entitymanagers.Database;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.netbuilder.BlueGardensEESystem.PersistenceManager;
import com.netbuilder.customannotations.MethodAuthor;
import com.netbuilder.entities.Product;
import com.netbuilder.entitymanagers.ProductManager;

/**
 * 
 * @author gandrews Allows products from the database to be interacted with
 *         within the system
 */
@Alternative
public class ProductManagerDB implements ProductManager {
	@Inject
	private PersistenceManager pm;

	@MethodAuthor(name = "Gandrews")
	public void persistProduct(Product product) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();

		em.persist(product);

		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	@MethodAuthor(name = "Gandrews")
	public void persistProducts(ArrayList<Product> products) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();

		for (Product product : products) {
			em.persist(product);
		}
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	@MethodAuthor(name = "Gandrews")
	public void updateProduct(Product product) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();

		em.merge(product);

		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	@MethodAuthor(name = "Gandrews")
	public ArrayList<Product> findByName(String name) {
		EntityManager em = pm.CreateEntityManager();
		ArrayList<Product> products = (ArrayList<Product>) em.createQuery(
				Product.FIND_BY_NAME, Product.class).getResultList();
		pm.CloseEntityManager(em);
		try {
			return products;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 
	 * @author jmander
	 * 
	 */
	public ArrayList<Product> findByPrice(double price) {
		ArrayList<Product> p = new ArrayList<Product>();
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();

		p = (ArrayList<Product>) em.createQuery(
				"SELECT * FROM Product WHERE Price = price", Product.class)
				.getResultList();

		em.getTransaction().commit();
		pm.CloseEntityManager(em);
		return p;
	}

	public ArrayList<Product> findByOutStock() {
		ArrayList<Product> p = new ArrayList<Product>();
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();

		p = (ArrayList<Product>) em.createQuery(
				"SELECT * FROM Product WHERE Stock = 0", Product.class)
				.getResultList();

		em.getTransaction().commit();
		pm.CloseEntityManager(em);
		return p;
	}

	public Product findById(int id) {
		EntityManager em = pm.CreateEntityManager();
		TypedQuery<Product> tq = em.createNamedQuery(
				Product.FIND_BY_PRODUCT_ID, Product.class);
		pm.CloseEntityManager(em);
		tq.setParameter("id", id);
		try {
			return tq.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	public ArrayList<Product> findAll() {
		ArrayList<Product> p = new ArrayList<Product>();
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();

		p = (ArrayList<Product>) em.createQuery("SELECT * FROM Product ",
				Product.class).getResultList();

		em.getTransaction().commit();
		pm.CloseEntityManager(em);
		return p;
	}

	public ArrayList<Product> findByPriceLessThan(double price) {
		ArrayList<Product> p = new ArrayList<Product>();
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();

		p = (ArrayList<Product>) em.createQuery(
				"SELECT * FROM Product WHERE Price < price", Product.class)
				.getResultList();

		em.getTransaction().commit();
		pm.CloseEntityManager(em);
		return p;
	}

	/**
	 * Added finding by sale method
	 * 
	 * @author lczornyj
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Product> findBySale() {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		ArrayList<Product> p = (ArrayList<Product>) em.createNamedQuery(
				Product.FIND_BY_SALE).getResultList();
		em.getTransaction().commit();
		pm.CloseEntityManager(em);

		return p;
	}

	/**
	 * Added finding by pourousware method
	 * 
	 * @author lczornyj
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Product> findByPourousware(boolean isPourousware) {
		ArrayList<Product> p = new ArrayList<Product>();
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();

		p = (ArrayList<Product>) em.createNamedQuery(
				Product.FIND_BY_POUROUSWARE).getResultList();

		em.getTransaction().commit();
		pm.CloseEntityManager(em);

		return p;
	}

	/**
	 * Added finding by trending method
	 * 
	 * @author lczornyj
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Product> findByTrending() {
		ArrayList<Product> p = new ArrayList<Product>();
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		p = (ArrayList<Product>) em.createNamedQuery(Product.FIND_BY_TRENDING)
				.getResultList();
		em.getTransaction().commit();
		pm.CloseEntityManager(em);

		return p;
	}

	public Product findByImageLink(String link) {
		EntityManager em = pm.CreateEntityManager();
		TypedQuery<Product> tq = em.createNamedQuery(
				Product.FIND_BY_IMAGE_LINK, Product.class);
		pm.CloseEntityManager(em);
		tq.setParameter("imageLink", link);
		try {
			return tq.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

}
