package com.netbuilder.BlueGardensEESystem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

/**
 * 
 * This Object handles the connection between the app server and a database.
 * 
 * @author jthompson
 */
public class PersistenceManager 
{
	private EntityManagerFactory emf;
	
	/**
	 * This method opens a connection to the database and returns the entity manager
	 * 
	 * @return javax.persistence.EntityManager
	 */
	public EntityManager CreateEntityManager()
	{
		try
		{
			emf = Persistence.createEntityManagerFactory("BlueGardensFactory");
			EntityManager em = emf.createEntityManager();
			return em;
		} 
		catch (PersistenceException pe) { return null; }
	}
	
	/**
	 * This method closes the connection of the entity manager that is passed into it.
	 * 
	 * @param em javax.persistence.EntityManager
	 */
	public void CloseEntityManager(EntityManager em)
	{
		em.close();
		emf.close();
	}	
}