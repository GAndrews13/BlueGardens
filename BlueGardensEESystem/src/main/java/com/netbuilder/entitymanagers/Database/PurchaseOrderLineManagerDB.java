package com.netbuilder.entitymanagers.Database;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.ValidationException;

import com.netbuilder.BlueGardensEESystem.PersistenceManager;
import com.netbuilder.entities.PurchaseOrderLine;
import com.netbuilder.entitymanagers.PurchaseOrderLineManager;

public class PurchaseOrderLineManagerDB implements PurchaseOrderLineManager {

	PersistenceManager pm = new PersistenceManager();

	@Override
	public void persistPurchaseOrderLine(PurchaseOrderLine pol) {
		// TODO Auto-generated method stub
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		em.persist(pol);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	@Override
	public void persistPurchaseOrderLines(ArrayList<PurchaseOrderLine> pols) {
		// TODO Auto-generated method stub
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		for (PurchaseOrderLine pol : pols) {
			em.persist(pol);
		}
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	@Override
	public void updatePurchaseOrderLine(PurchaseOrderLine pol) {
		// TODO Auto-generated method stub
		if (pol == null)
			throw new ValidationException("null value passed ");
		EntityManager em = pm.CreateEntityManager();
		em.merge(pol);
		pm.CloseEntityManager(em);
	}

	@Override
	public ArrayList<PurchaseOrderLine> findbyPurchaseOrderID(int poid) {
		// TODO Auto-generated method stub
		EntityManager em = pm.CreateEntityManager();
		TypedQuery<PurchaseOrderLine> tq = em.createNamedQuery(
				PurchaseOrderLine.FIND_OUT_BY_PURCHASE_ORDER_ID,
				PurchaseOrderLine.class);
		pm.CloseEntityManager(em);
		tq.setParameter("poid", poid);
		try {
			return (ArrayList<PurchaseOrderLine>) tq.getResultList();
		} catch (NoResultException nre) {
			return null;
		}
	}

	@Override
	public ArrayList<PurchaseOrderLine> findbyProductID(int pid) {
		// TODO Auto-generated method stub
		EntityManager em = pm.CreateEntityManager();
		TypedQuery<PurchaseOrderLine> tq = em.createNamedQuery(
				PurchaseOrderLine.FIND_OUT_BY_PRODUCT_ID,
				PurchaseOrderLine.class);
		pm.CloseEntityManager(em);
		tq.setParameter("pid", pid);
		try {
			return (ArrayList<PurchaseOrderLine>) tq.getResultList();
		} catch (NoResultException nre) {
			return null;
		}
	}

}
