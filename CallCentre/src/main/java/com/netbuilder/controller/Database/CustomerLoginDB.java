package com.netbuilder.controller.Database;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.netbuilder.controller.PersistenceManager;
import com.netbuilder.model.CustomerLogin;
import com.netbuilder.controller.CustomerLoginManager;

/**
 * @author gandrews
 * **/

public class CustomerLoginDB implements CustomerLoginManager {

	@Inject
	private PersistenceManager pm;

	public long checkDetails(String inUsername, byte[] inPassword) {
		String SQLStatement = "SELECT * FROM CustomerLogin c WHERE c.username = "
				+ inUsername + " AND c.password = " + inPassword;
		EntityManager em = pm.CreateEntityManager();
		TypedQuery<CustomerLogin> tq = em.createQuery(SQLStatement,
				CustomerLogin.class);
		tq.setParameter("username", inUsername);
		try {
			return tq.getSingleResult().getCustomerID();
		} catch (NoResultException nre) {
			return 0;
		}
	}

	public long checkCustomerID(String inUsername) {
		String SQLStatement = "SELECT * FROM CustomerLogin c WHERE c.username = "
				+ inUsername;
		EntityManager em = pm.CreateEntityManager();
		TypedQuery<CustomerLogin> tq = em.createQuery(SQLStatement,
				CustomerLogin.class);
		tq.setParameter("username", inUsername);
		try {
			return tq.getSingleResult().getCustomerID();
		} catch (NoResultException nre) {
			return 0;
		}
	}

	@Override
	public String getCustomerUsername(String inUserEmail) {
		EntityManager em = pm.CreateEntityManager();
		CustomerLogin cl = em.createQuery(
				"SELECT * FROM CustomerLogin c WHERE c.email = " + inUserEmail,
				CustomerLogin.class).getSingleResult();
		return cl.getCustomerUsername();
	}

	@Override
	public byte[] getCustomerSalt(String inUsername) {
		EntityManager em = pm.CreateEntityManager();
		byte[] saltArray = em.createQuery(
				"SELECT salt FROM CustomerLogin c WHERE c.username = "
						+ inUsername, byte[].class).getSingleResult();
		return saltArray;
	}

	@Override
	public void persistCustomerLogin(CustomerLogin customerLogin) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		em.persist(customerLogin);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	@Override
	public ArrayList<CustomerLogin> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCustomerPassword(long id, String password) {
		// TODO Auto-generated method stub

	}

}
