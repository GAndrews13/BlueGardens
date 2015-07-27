package com.netbuilder.entitymanagers.Database;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.ValidationException;

import com.netbuilder.BlueGardensEESystem.PersistenceManager;
import com.netbuilder.entities.ProductOrderLine;
import com.netbuilder.entities.PurchaseOrder;

public class PurchaseOrderManagerDB {
	
	@Inject
	private PersistenceManager pm;
	/**
	 * @author David Ogbonnah
	 *	Add a new product order line into the system
	 */
	public void persistPOL(PurchaseOrder po)
	{
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		em.persist(po);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}
	
	/**
	 * @author David Ogbonnah
	 *	Find a product order line by its ID
	 */
	public PurchaseOrder findByID(int ID)
	{
		EntityManager em = pm.CreateEntityManager(); 
		TypedQuery<PurchaseOrder> tq = em.createNamedQuery(PurchaseOrder.FIND_BY_ID, PurchaseOrder.class);
		pm.CloseEntityManager(em);
		tq.setParameter("ID", ID);
		try
		{
			return tq.getSingleResult(); 
		}
		catch (NoResultException nre) 
			{
				return null;
			} 
	}
	
	/**
	 * @author David Ogbonnah
	 *	Find a product order line by the customer ID
	 */
	public PurchaseOrder findBySupplierID(int supplierID)
	{
		EntityManager em = pm.CreateEntityManager(); 
		TypedQuery<PurchaseOrder> tq = em.createNamedQuery(PurchaseOrder.FIND_BY_SUPPLIERID, PurchaseOrder.class);
		pm.CloseEntityManager(em);
		tq.setParameter("SupplierID", supplierID);
		try
		{
			return tq.getSingleResult(); 
		}
		catch (NoResultException nre) 
			{
				return null;
			} 
	}
	
	/**
	 * @author Jake
	 *	Find all product order lines above a certain quantity
	 */
	public ArrayList<PurchaseOrder> findByQuantity(int quantity)
	{
		EntityManager em = pm.CreateEntityManager();
		ArrayList<PurchaseOrder> po = (ArrayList<PurchaseOrder>) em.createQuery("select * from PurchaseOrder a", PurchaseOrder.class).getResultList(); 
		pm.CloseEntityManager(em); 
		return po; 
	}

	/**
	 * @author David Ogbonnah
	 *	Update details in a product order line
	 */
	public void updatePOL(PurchaseOrder pol)
	{
		if(pol == null)
			throw new ValidationException("null value passed");
		EntityManager em = pm.CreateEntityManager();
		em.merge(pol);
		pm.CloseEntityManager(em);
	}
	
	/**
	 * @author David Ogbonnah
	 *	Return all product order lines
	 */
	public ArrayList <PurchaseOrder> findall()
	{
		EntityManager em = pm.CreateEntityManager();
		ArrayList<PurchaseOrder> POL = (ArrayList<PurchaseOrder>) em.createQuery("select * from ProductOrderLine a", PurchaseOrder.class).getResultList(); 
		pm.CloseEntityManager(em); 
		return POL; 
	}
}
