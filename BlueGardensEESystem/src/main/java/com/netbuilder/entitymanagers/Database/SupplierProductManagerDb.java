package com.netbuilder.entitymanagers.Database;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.ValidationException;

import com.netbuilder.BlueGardensEESystem.PersistenceManager;
import com.netbuilder.entities.SupplierProduct;
import com.netbuilder.entitymanagers.SupplierProductManager;

/**
 * @author abalagel implements the database connectivity
 */
public class SupplierProductManagerDb implements SupplierProductManager {

	@Inject
	private PersistenceManager pm;

	public void persistSupplierProduct(SupplierProduct supplierProduct) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		em.persist(supplierProduct);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);

	}

	public void persistSupplierProducts(
			ArrayList<SupplierProduct> supplierProducts) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		for (SupplierProduct supplierProduct : supplierProducts)
			em.persist(supplierProduct);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);

	}

	public void updateSupplierProduct(SupplierProduct supplierProduct) {
		if (supplierProduct == null)
			throw new ValidationException("null value");
		EntityManager em = pm.CreateEntityManager();
		em.merge(supplierProduct);
		pm.CloseEntityManager(em);

	}

	public SupplierProduct findById(int id) {
		EntityManager em = pm.CreateEntityManager();
		TypedQuery<SupplierProduct> tq = em.createNamedQuery(
				SupplierProduct.FIND_OUT_BY_PRODUCTID, SupplierProduct.class);
		pm.CloseEntityManager(em);
		tq.setParameter("ProductID", id);
		try {
			return tq.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	public SupplierProduct findByPrice(double price) {
		EntityManager em = pm.CreateEntityManager();
		TypedQuery<SupplierProduct> tq = em.createNamedQuery(
				SupplierProduct.FIND_OUT_BY_PRICE, SupplierProduct.class);
		pm.CloseEntityManager(em);
		tq.setParameter("Price", price);
		try {
			return tq.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

}
