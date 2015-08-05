package com.netbuilder.entitymanagers.Database;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.ValidationException;

import com.netbuilder.BlueGardensEESystem.PersistenceManager;
import com.netbuilder.entities.CustomerOrderLine;
import com.netbuilder.entities.ProductOrderLine;
import com.netbuilder.entitymanagers.CustomerOrderLineManager;

public class CustomerOrderLineManagerDB implements CustomerOrderLineManager 
{
	@Inject
	private PersistenceManager pm;
	
	
	@Override
	public void persistCOL(CustomerOrderLine col)
	{
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		em.persist(col);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	@Override
	public ArrayList<CustomerOrderLine> findByPOID(int po_ID) {
		EntityManager em = pm.CreateEntityManager(); 
		ArrayList<CustomerOrderLine> col = (ArrayList<CustomerOrderLine>) em.createQuery("select * from ProductOrderLine a", CustomerOrderLine.class).getResultList(); 
		pm.CloseEntityManager(em);
		try
		{
			return col; 
		}
		catch (NoResultException nre) 
			{
				return null;
			} 		
	}

	@Override
	public ArrayList<CustomerOrderLine> findByCOID(int customerID) 
	{
		EntityManager em = pm.CreateEntityManager(); 
		TypedQuery<CustomerOrderLine> tq = em.createNamedQuery(CustomerOrderLine.FIND_BY_CO_ID, CustomerOrderLine.class);
		pm.CloseEntityManager(em);
		tq.setParameter("CustomerID", customerID);
		try
		{
			return  (ArrayList<CustomerOrderLine>) tq.getResultList() ; 
		}
		catch (NoResultException nre) 
			{
				return null;
			} 
	}

	@Override
	public ArrayList<CustomerOrderLine> findByQuantity(int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCOL(CustomerOrderLine col) {
		// TODO Auto-generated method stub
		if (col == null)
			throw new ValidationException("null value passed ");
			EntityManager em = pm.CreateEntityManager();
			em.merge(col);
			pm.CloseEntityManager(em);
	}

	@Override
	public ArrayList<CustomerOrderLine> findAll() {
		// TODO Auto-generated method stub
		EntityManager em = pm.CreateEntityManager();
		ArrayList<CustomerOrderLine> COL = (ArrayList<CustomerOrderLine>) em.createQuery("select * from CustomerOrderLine a", CustomerOrderLine.class).getResultList(); 
		pm.CloseEntityManager(em); 
		return COL;
	}

}
