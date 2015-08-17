package com.netbuilder.controller.Database;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.netbuilder.controller.PersistenceManager;
import com.netbuilder.model.CustomerOrderLine;
import com.netbuilder.controller.CustomerOrderLineManager;

/**
 * @author jmander
 */
public class CustomerOrderLineManagerDB implements CustomerOrderLineManager {
	@Inject
	private PersistenceManager pm;

	public void persistCustomerOrderLine(CustomerOrderLine customerOrderLine) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();

		em.persist(customerOrderLine);

		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	public void persistCustomerOrderLines(
			ArrayList<CustomerOrderLine> customerOrderLines) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();

		for (CustomerOrderLine customerOrderLine : customerOrderLines) {
			em.persist(customerOrderLine);
		}
		em.getTransaction().commit();
		pm.CloseEntityManager(em);

	}

	public ArrayList<CustomerOrderLine> findByCustomerOrderID(
			int customerOrderID) {
		EntityManager em = pm.CreateEntityManager();
		ArrayList<CustomerOrderLine> customerOrderLines = (ArrayList<CustomerOrderLine>) em
				.createQuery(CustomerOrderLine.FIND_BY_CO_ID,
						CustomerOrderLine.class).getResultList();
		pm.CloseEntityManager(em);
		try {
			return customerOrderLines;
		} catch (Exception e) {
			return null;
		}
	}

	public ArrayList<CustomerOrderLine> findByQuantity(int quantity) {
		EntityManager em = pm.CreateEntityManager();
		ArrayList<CustomerOrderLine> customerOrderLines = (ArrayList<CustomerOrderLine>) em
				.createQuery(CustomerOrderLine.FIND_BY_QUANTITY,
						CustomerOrderLine.class).getResultList();
		pm.CloseEntityManager(em);
		try {
			return customerOrderLines;
		} catch (Exception e) {
			return null;
		}
	}

	public void updateCustomerOrderLine(CustomerOrderLine customerOrderLine) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();

		em.merge(customerOrderLine);

		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	public ArrayList<CustomerOrderLine> findAll() {
		EntityManager em = pm.CreateEntityManager();
		ArrayList<CustomerOrderLine> customerOrderLines = (ArrayList<CustomerOrderLine>) em
				.createQuery("SELECT * FROM CustomerOrderLine",
						CustomerOrderLine.class).getResultList();
		pm.CloseEntityManager(em);
		try {
			return customerOrderLines;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public ArrayList<CustomerOrderLine> finyByProductID(int productID) {
		EntityManager em = pm.CreateEntityManager();
		ArrayList<CustomerOrderLine> customerOrderLines = (ArrayList<CustomerOrderLine>) em
				.createQuery(CustomerOrderLine.FIND_BY_PRODUCT_ID,
						CustomerOrderLine.class).getResultList();
		pm.CloseEntityManager(em);
		try {
			return customerOrderLines;
		} catch (Exception e) {
			return null;
		}
	}

}
