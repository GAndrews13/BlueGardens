package com.netbuilder.entitymanagers.Database;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.ValidationException;

import com.netbuilder.BlueGardensEESystem.PersistenceManager;
import com.netbuilder.entities.ProductOrderLine;
import com.netbuilder.entitymanagers.ProductOrderLineManager;

public class ProductOrderLineDB implements ProductOrderLineManager {
	@Inject
	private PersistenceManager pm;

	/**
	 * @author Jake Add a new product order line into the system
	 */
	public void persistPOL(ProductOrderLine pol) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		em.persist(pol);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	/**
	 * @author Jake Find a product order line by its ID
	 */
	public ProductOrderLine findByPOLID(int pol_ID) {
		EntityManager em = pm.CreateEntityManager();
		TypedQuery<ProductOrderLine> tq = em.createNamedQuery(
				ProductOrderLine.FIND_BY_POL_ID, ProductOrderLine.class);
		pm.CloseEntityManager(em);
		tq.setParameter("POLID", pol_ID);
		try {
			return tq.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * @author Jake Find a product order line by the customer ID
	 */
	public ProductOrderLine findByCID(int customerID) {
		EntityManager em = pm.CreateEntityManager();
		TypedQuery<ProductOrderLine> tq = em.createNamedQuery(
				ProductOrderLine.FIND_BY_CUSTOMER_ID, ProductOrderLine.class);
		pm.CloseEntityManager(em);
		tq.setParameter("CustomerID", customerID);
		try {
			return tq.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * @author Jake Find all product order lines above a certain quantity
	 */
	public ArrayList<ProductOrderLine> findByQuantity(int quantity) {
		EntityManager em = pm.CreateEntityManager();
		ArrayList<ProductOrderLine> POL = (ArrayList<ProductOrderLine>) em
				.createQuery("select * from ProductOrderLine a",
						ProductOrderLine.class).getResultList();
		pm.CloseEntityManager(em);
		return POL;
	}

	/**
	 * @author Jake Update details in a product order line
	 */
	public void updatePOL(ProductOrderLine pol) {
		if (pol == null)
			throw new ValidationException("null value passed");
		EntityManager em = pm.CreateEntityManager();
		em.merge(pol);
		pm.CloseEntityManager(em);
	}

	/**
	 * @author Jake Return all product order lines
	 */
	public ArrayList<ProductOrderLine> findall() {
		EntityManager em = pm.CreateEntityManager();
		ArrayList<ProductOrderLine> POL = (ArrayList<ProductOrderLine>) em
				.createQuery("select * from ProductOrderLine a",
						ProductOrderLine.class).getResultList();
		pm.CloseEntityManager(em);
		return POL;
	}
}
