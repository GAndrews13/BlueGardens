package com.netbuilder.entitymanagers;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.netbuilder.entities.WeeklySales;

public class WeeklySalesManagerDummy implements WeeklySalesManager {
	@Inject
	private PersistanceManager pm;
	
	private ArrayList<WeeklySales> salesRecord;

	public void persistWeeklySales(WeeklySales inWeeklySales) {
		EntityManager em = pm.openEntityManager();
		em.getTransaction().begin();
		
		em.persist(inWeeklySales);
		
		em.getTransaction().commit();
		pm.closeEntityManager(em);

	}

	public void persistWeeklySales(ArrayList<WeeklySales> inWeeklySalesList) {
		EntityManager em = pm.openEntityManager();
		em.getTransaction().begin();
		
		em.persist(inWeeklySalesList);
		
		em.getTransaction().commit();
		pm.closeEntityManager(em);
	}

	public ArrayList<WeeklySales> findByMonth(int inMonthNumber) {
		EntityManager em = pm.openEntityManager();
		em.getTransaction().begin();
		
		ArrayList<WeeklySales> returnList = new ArrayList<WeeklySales>();
		for(WeeklySales w : salesRecord)
		{
			//TODO replace with calender?
			if(w.getDateSold().getMonth() == inMonthNumber)
			{
				returnList.add(w);
			}
		}
		
		
		em.getTransaction().commit();
		pm.closeEntityManager(em);
		return returnList;
	}

	public ArrayList<WeeklySales> findByMinimumSales(int inMinimumSales) {
		EntityManager em = pm.openEntityManager();
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
		pm.closeEntityManager(em);
		return returnList;
		
	}

}
