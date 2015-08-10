package com.netbuilder.entitymanagers.Database;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.netbuilder.BlueGardensEESystem.PersistenceManager;
import com.netbuilder.entities.WarehouseLocation;
import com.netbuilder.entitymanagers.WarehouseLocationManager;

/** @author anca */
@Alternative
public class WarehouseLocationManagerDB implements WarehouseLocationManager {
	@Inject
	private PersistenceManager pm;

	public void persistWarehouseLocation(WarehouseLocation warehouseLocation) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		em.persist(warehouseLocation);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	public void updateWarehouseLocation(WarehouseLocation warehouseLocation) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		em.merge(warehouseLocation);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	@Override
	public ArrayList<WarehouseLocation> findByProductID(int id) {
		EntityManager em = pm.CreateEntityManager();
		TypedQuery<WarehouseLocation> wr = em.createNamedQuery(
				WarehouseLocation.FIND_OUT_BY_PRODUCTID,
				WarehouseLocation.class);
		pm.CloseEntityManager(em);
		wr.setParameter("ProductID", id);
		try {
			return (ArrayList<WarehouseLocation>) wr.getResultList();
		} catch (NoResultException nre) {
			return null;
		}
	}
}
