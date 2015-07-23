package com.netbuilder.entitymanagers.Database;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.ValidationException;

import com.netbuilder.BlueGardensEESystem.DeliveryStatus;
import com.netbuilder.BlueGardensEESystem.PersistenceManager;
import com.netbuilder.entities.Customer;
import com.netbuilder.entities.CustomerOrder;
import com.netbuilder.entities.WarehouseWorker;
import com.netbuilder.entitymanagers.CustomerOrderManager;


/**
 * 
 * @author jmander
 * 
 * Created DB interface for Customer Order class and its queries
 *
 **/

public class CustomerOrderManagerDB implements CustomerOrderManager {
	
	@Inject
	private PersistenceManager pm;
    ArrayList<CustomerOrder> customerOrders = new ArrayList<CustomerOrder>();

	public void persistCustomerOrder(CustomerOrder customerOrder) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		em.persist(customerOrder);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);	
	}

	public void persistCustomerOrders(ArrayList<CustomerOrder> customerOrders) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		for (CustomerOrder customerOrder : customerOrders){
			em.persist(customerOrder);
		}
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	public void updateCustomerOrder(CustomerOrder customerOrder) {
		if (customerOrder == null)
			throw new ValidationException("null value passed ");
			EntityManager em = pm.CreateEntityManager();
			em.merge(customerOrder);
			pm.CloseEntityManager(em);
	}

	public CustomerOrder findByCustomerOrderId(int customerOrderId) {
		EntityManager em = pm.CreateEntityManager();
		TypedQuery<CustomerOrder> tq = em.createNamedQuery(CustomerOrder.FIND_BY_CUSTOMER_ORDER_ID, CustomerOrder.class);
		pm.CloseEntityManager(em);
		tq.setParameter("id", customerOrderId);
		try{
		return tq.getSingleResult();
		} catch (NoResultException nre) {
		return null;
		}
	}

	public ArrayList<CustomerOrder> findByisAssigned(boolean isAssigned) {
		ArrayList<CustomerOrder> co = new ArrayList<CustomerOrder>();
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();

		co = (ArrayList<CustomerOrder>) em.createQuery("SELECT * FROM CustomerOrder WHERE Is_Assigned = isAssigned ",CustomerOrder.class).getResultList();
		
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
		return co;
	}

	public CustomerOrder findByTrackingId(int trackingId) {
		EntityManager em = pm.CreateEntityManager();
		TypedQuery<CustomerOrder> tq = em.createNamedQuery(CustomerOrder.FIND_BY_TRACKING_ID, CustomerOrder.class);
		pm.CloseEntityManager(em);
		tq.setParameter("id", trackingId);
		try{
		return tq.getSingleResult();
		} catch (NoResultException nre) {
		return null;
		}
	}

	public ArrayList<CustomerOrder> findByDeliveryType(String deliveryType) {
		ArrayList<CustomerOrder> co = new ArrayList<CustomerOrder>();
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();

		co = (ArrayList<CustomerOrder>) em.createQuery("SELECT * FROM CustomerOrder WHERE DeliveryType = deliveryType",CustomerOrder.class).getResultList();
		
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
		return co;
	}

	public ArrayList<CustomerOrder> findByCustomer(Customer customer) {
		ArrayList<CustomerOrder> co = new ArrayList<CustomerOrder>();
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();

		co = (ArrayList<CustomerOrder>) em.createQuery("SELECT * FROM CustomerOrder WHERE Customer.CustomerID = customer ",CustomerOrder.class).getResultList();
		
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
		return co;
	}

	public ArrayList<CustomerOrder> findByWorker(WarehouseWorker worker) {
		ArrayList<CustomerOrder> co = new ArrayList<CustomerOrder>();
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();

		co = (ArrayList<CustomerOrder>) em.createQuery("SELECT * FROM CustomerOrder WHERE WarehouseWorker.WorkerId = worker ",CustomerOrder.class).getResultList();
		
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
		return co;
	}
	
    public ArrayList<CustomerOrder> findByDeliveryStatus(DeliveryStatus status){
		ArrayList<CustomerOrder> co = new ArrayList<CustomerOrder>();
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();

		co = (ArrayList<CustomerOrder>) em.createQuery("SELECT * FROM CustomerOrder WHERE DeliveryStatus = status ",CustomerOrder.class).getResultList();
		
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
		return co;
    }

}
