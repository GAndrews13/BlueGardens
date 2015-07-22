package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;
import java.util.Calendar;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.netbuilder.BlueGardensEESystem.PersistenceManager;
import com.netbuilder.entities.WeeklySales;
import com.netbuilder.entitymanagers.WeeklySalesManager;

/**
 * 
 * @author gandrews
 *	Uses a list of WeeklySales to mimic a database interaction
 */
@Alternative
public class WeeklySalesManagerDummy implements WeeklySalesManager {
	@Inject
	private PersistenceManager pm;
	
	private ArrayList<WeeklySales> salesRecord;

	public void persistWeeklySales(WeeklySales inWeeklySales) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		
		em.persist(inWeeklySales);
		salesRecord.add(inWeeklySales);
		
		em.getTransaction().commit();
		pm.CloseEntityManager(em);

	}

	public void persistWeeklySales(ArrayList<WeeklySales> inWeeklySalesList) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		
		em.persist(inWeeklySalesList);
		
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	@SuppressWarnings("deprecation")
	public ArrayList<WeeklySales> findByMonth(int inMonthNumber) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		
		ArrayList<WeeklySales> returnList = new ArrayList<WeeklySales>();
		for(WeeklySales w : salesRecord)
		{
			//TODO replace with calender?
			Calendar c = Calendar.getInstance();
			if(w.getDateSold().getMonth() == inMonthNumber-1)
			{
				returnList.add(w);
			}
		}
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
		return returnList;
	}

	public ArrayList<WeeklySales> findByMinimumSales(int inMinimumSales) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		ArrayList<WeeklySales> returnList = new ArrayList<WeeklySales>();
		
		for(WeeklySales w : salesRecord)
		{
			if(w.getAmountSold() >= inMinimumSales)
			{
				returnList.add(w);
			}
		}
		
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
		return returnList;
		
	}

}
