package com.netbuilder.entitymanagers.Database;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.ValidationException;

import com.netbuilder.BlueGardensEESystem.PersistenceManager;
import com.netbuilder.entities.Customer;
import com.netbuilder.entitymanagers.CustomerManager;

/**
 * @author Jake
 *	Database implementation for customer using the Persistence Manager
 */

public class CustomerManagerDB implements CustomerManager
{
	@Inject 
	private PersistenceManager pm;
	/**
	 * @author Jake
	 *	Customer is pushed to database
	 */
	public void persistCustomer(Customer customer)
	{
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		em.persist(customer);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}
	
	/**
	 * @author Jake
	 *	New customer details overwrite old customer details
	 */
	public void updateCustomer(Customer customer)
	{
		if(customer == null)
			throw new ValidationException("null value passed");
		EntityManager em = pm.CreateEntityManager();
		em.merge(customer);
		pm.CloseEntityManager(em);
	}
	
	/**
	 * @author Jake
	 *	Return customer matching the string passed in
	 */
	public Customer findByName(String name)
	{
		EntityManager em = pm.CreateEntityManager(); 
		TypedQuery<Customer> tq = em.createNamedQuery(Customer.FIND_BY_NAME, Customer.class);
		pm.CloseEntityManager(em);
		tq.setParameter("Name", name);
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
	 *	Return Customer matching the email passed in 
	 */
	public Customer findByEmail(String email)
	{
		EntityManager em = pm.CreateEntityManager(); 
		TypedQuery<Customer> tq = em.createNamedQuery(Customer.FIND_BY_NAME, Customer.class);
		pm.CloseEntityManager(em);
		tq.setParameter("Name", email);
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
	 *	Return list of customers that match the accoutn status passed in
	 */
	public ArrayList<Customer> findByStatus(String status)
	{
		EntityManager em = pm.CreateEntityManager();
		ArrayList<Customer> customer = (ArrayList<Customer>) em.createQuery("select * from customers a", Customer.class).getResultList(); 
		pm.CloseEntityManager(em); 
		return customer; 
	}
}
