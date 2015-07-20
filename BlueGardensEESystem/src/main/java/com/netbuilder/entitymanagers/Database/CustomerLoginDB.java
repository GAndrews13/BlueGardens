package com.netbuilder.entitymanagers.Database;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.netbuilder.BlueGardensEESystem.PersistenceManager;
import com.netbuilder.entities.CustomerLogin;
import com.netbuilder.entitymanagers.CustomerLoginManager;

public class CustomerLoginDB implements CustomerLoginManager {

	@Inject 
	private PersistenceManager pm;
	
	public long checkDetails(String inUsername, String inPassword) {
		String SQLStatement = "SELECT * FROM CustomerLogin c WHERE c.username = "+  inUsername + " AND c.password = " + inPassword;
		EntityManager em = pm.CreateEntityManager();
		TypedQuery<CustomerLogin> tq = em.createQuery(SQLStatement, CustomerLogin.class);
		tq.setParameter("username", inUsername);
		try
		{
			return tq.getSingleResult().getCustomerID();
		}
		catch (NoResultException nre)
		{
			return 0;
		}
	}

	public long checkCustomerID(String inUsername) {
		String SQLStatement = "SELECT * FROM CustomerLogin c WHERE c.username = " + inUsername;
		EntityManager em = pm.CreateEntityManager();
		TypedQuery<CustomerLogin> tq = em.createQuery(SQLStatement, CustomerLogin.class);
		tq.setParameter("username",inUsername);
		try
		{
			return tq.getSingleResult().getCustomerID();
		}
		catch (NoResultException nre)
		{
			return 0;			
		}
	}

}
