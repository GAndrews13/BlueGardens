package com.netbuilder.entitymanagers.Database;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.netbuilder.BlueGardensEESystem.PersistenceManager;
import com.netbuilder.BlueGardensEESystem.SQLCreator;
import com.netbuilder.entities.WeeklySales;
import com.netbuilder.entitymanagers.WeeklySalesManager;
/**
 * 
 * @author gandrews
 */
@Alternative
public class WeeklySalesDB implements WeeklySalesManager {
	@Inject
	private PersistenceManager pm;
	
	public void persistWeeklySales(WeeklySales inWeeklySales) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		
		em.persist(inWeeklySales);
		
		em.getTransaction().commit();
		pm.CloseEntityManager(em);

	}

	public void persistWeeklySales(ArrayList<WeeklySales> inWeeklySalesList) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();		
		for(WeeklySales ws : inWeeklySalesList)
		{
			em.persist(ws);
		}
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	public ArrayList<WeeklySales> findByMonth(int inMonthNumber)
	{
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<WeeklySales> tq = (TypedQuery<WeeklySales>) em.createNamedQuery("SELECT * FROM WeeklySales WHERE MONTH(happened_at) = " + inMonthNumber);
		
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
		try
		{
			return (ArrayList<WeeklySales>) tq.getResultList();
		}
		catch(NoResultException nre)
		{
			return null;
		}
	}

	public ArrayList<WeeklySales> findByMinimumSales(int inMinimumSales) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		TypedQuery<WeeklySales> tq = (TypedQuery<WeeklySales>) em.createNamedQuery(SQLCreator.Select("WeeklySales", "amountSold", "<" + inMinimumSales));
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
		try
		{
			return (ArrayList<WeeklySales>) tq.getResultList();
		}
		catch (NoResultException nre)
		{
			return null;
		}
	}

}
