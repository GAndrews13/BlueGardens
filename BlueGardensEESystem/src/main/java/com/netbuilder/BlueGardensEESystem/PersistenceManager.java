package com.netbuilder.BlueGardensEESystem;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

@Singleton
public class PersistenceManager 
{
	 
	private EntityManagerFactory emf;
	public EntityManager CreateEntityManager()
	{
		try
		{
			emf = Persistence.createEntityManagerFactory("BlueGardensFactory");
			EntityManager em = emf.createEntityManager();
			return em;
		} 
		catch (PersistenceException pe)
		{
			return null;
		}
	}
	
	public void CloseEntityManager(EntityManager em)
	{
		em.close();
		emf.close();
	}

	public EntityManager CreateEntityManager1() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
