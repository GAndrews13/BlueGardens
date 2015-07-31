package com.netbuilder.entitymanagers.Database;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.ValidationException;

import com.netbuilder.BlueGardensEESystem.*;
import com.netbuilder.entities.Basket;
import com.netbuilder.entities.CustomerOrder;
import com.netbuilder.entities.ProductOrderLine;
import com.netbuilder.entitymanagers.BasketManager;
import com.netbuilder.entitymanagers.CustomerOrderManager;
import com.netbuilder.service.BasketProductOrderService;

/**
 * @author abalagel
 *	implements the database connectivity
 */
@Alternative
public class BasketManagerDb implements BasketManager {
	@Inject
	private PersistenceManager pm;
	
	public void persistBasket(Basket basket) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		em.persist(basket);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	public void updateBasket(Basket basket) {
		if (basket == null) throw new ValidationException("null value");
		EntityManager em = pm.CreateEntityManager();
		em.merge(basket);
		pm.CloseEntityManager(em);
	}
	
	public Basket findById(int id) {
		EntityManager em = pm.CreateEntityManager();
		TypedQuery<Basket> tq = em.createNamedQuery(Basket.FIND_OUT_BY_PRODUCTID, Basket.class);
		pm.CloseEntityManager(em);
		tq.setParameter("ProductID", id);
		try{
			return tq.getSingleResult();
		} catch (NoResultException nre){
		return null;
		}
	}

	@Override
	public double findTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ProductOrderLine> products() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
