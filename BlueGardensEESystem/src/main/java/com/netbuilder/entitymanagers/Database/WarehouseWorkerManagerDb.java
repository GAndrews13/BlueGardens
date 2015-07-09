package com.netbuilder.entitymanagers.Database;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.ValidationException;

import com.netbuilder.BlueGardensEESystem.PersistenceManager;
import com.netbuilder.entities.WarehouseWorker;
import com.netbuilder.entitymanagers.WarehouseWorkerManager;

public class WarehouseWorkerManagerDb implements WarehouseWorkerManager {
@Inject
private PersistenceManager pm;

/**
 * @author lczornyj Created DB interface for warehouseworker class and its queries
 */
	public void persistWarehouseWorker(WarehouseWorker warehouseWorker) {
		// TODO Auto-generated method stub
		
			EntityManager em = pm.CreateEntityManager();
			em.getTransaction().begin();
			em.persist(warehouseWorker);
			em.getTransaction().commit();
			pm.CloseEntityManager(em);
			
	}

	public void persistWarehouseWorker(ArrayList<WarehouseWorker> warehouseWorkers) {
		// TODO Auto-generated method stub
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		for (WarehouseWorker warehouseWorker : warehouseWorkers)
		{
		em.persist(warehouseWorker);
		}
		em.getTransaction().commit();
		pm.CloseEntityManager(em);

	}

	public void updateWarehouseWorker(WarehouseWorker warehouseWorker) {
		// TODO Auto-generated method stub
		if (warehouseWorker == null)
			throw new ValidationException("null value passed ");
			EntityManager em = pm.CreateEntityManager();
			em.merge(warehouseWorker);
			pm.CloseEntityManager(em);

	}

	public WarehouseWorker findByName(String name) {
		// TODO Auto-generated method stub
		
		
		EntityManager em = pm.CreateEntityManager();
		TypedQuery<WarehouseWorker> tq = em.createNamedQuery(WarehouseWorker.FIND_OUT_BY_NAME, WarehouseWorker.class);
		pm.CloseEntityManager(em);
		tq.setParameter("name", name);
		try{
		return tq.getSingleResult();
		} catch (NoResultException nre) {
		return null;
		}
	}

	public WarehouseWorker findById(int id) {
		// TODO Auto-generated method stub
		EntityManager em = pm.CreateEntityManager();
		TypedQuery<WarehouseWorker> tq = em.createNamedQuery(WarehouseWorker.FIND_OUT_BY_ID, WarehouseWorker.class);
		pm.CloseEntityManager(em);
		tq.setParameter("id", id);
		try{
		return tq.getSingleResult();
		} catch (NoResultException nre) {
		return null;
		}
	}
}
