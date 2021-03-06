package com.netbuilder.entitymanagers.Database;

import java.util.ArrayList;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.ValidationException;

import com.netbuilder.BlueGardensEESystem.PersistenceManager;
import com.netbuilder.entities.Supplier;
import com.netbuilder.entitymanagers.SupplierManager;

@Default
public class SupplierManagerDb implements SupplierManager {
	@Inject
	private PersistenceManager pm;

	/**
	 * @author lczornyj Created DB interface for supplier class and its queries
	 *         This includes the inplemented methods for searching for a worker
	 *         by name and ID
	 */
	public void persistSupplier(Supplier supplier) {
		// TODO Auto-generated method stub

		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		em.persist(supplier);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);

	}

	public void persistSupplier(ArrayList<Supplier> suppliers) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		for (Supplier supplier : suppliers) {
			em.persist(supplier);
		}
		em.getTransaction().commit();
		pm.CloseEntityManager(em);

	}

	public void updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		if (supplier == null)
			throw new ValidationException("null value passed ");
		EntityManager em = pm.CreateEntityManager();
		em.merge(supplier);
		pm.CloseEntityManager(em);

	}

	public Supplier findByName(String name) {
		// TODO Auto-generated method stub
		EntityManager em = pm.CreateEntityManager();
		TypedQuery<Supplier> tq = em.createNamedQuery(
				Supplier.FIND_OUT_BY_NAME, Supplier.class);
		pm.CloseEntityManager(em);
		tq.setParameter("name", name);
		try {
			return tq.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	public Supplier findById(int id) {
		// TODO Auto-generated method stub
		EntityManager em = pm.CreateEntityManager();
		TypedQuery<Supplier> tq = em.createNamedQuery(Supplier.FIND_OUT_BY_ID,
				Supplier.class);
		pm.CloseEntityManager(em);
		tq.setParameter("id", id);
		try {
			return tq.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}
}
