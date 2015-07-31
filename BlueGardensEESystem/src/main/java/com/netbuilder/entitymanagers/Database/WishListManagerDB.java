package com.netbuilder.entitymanagers.Database;

import java.util.List;
import java.util.ArrayList;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.netbuilder.BlueGardensEESystem.PersistenceManager;
import com.netbuilder.entities.CustomerOrder;
import com.netbuilder.entities.Product;
import com.netbuilder.entities.Wishlist;
import com.netbuilder.entitymanagers.WishListManager;

/**
 * 
 * @author Anca
 *	Interfaces the database and the Wishlist entity
 */
@Alternative
public class WishListManagerDB implements WishListManager {
	@Inject
	private PersistenceManager pm;
	
	public void persistWishlist(Wishlist wishlist) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		em.persist(wishlist);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}
	
	public void persistWishlists(ArrayList<Wishlist> wishlists) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		
		for(Wishlist wishlist : wishlists)
		{
			em.persist(wishlist);
		}
		em.getTransaction().commit();
		pm.CloseEntityManager(em);		
	}

	public void updateWishlist(Wishlist wishlist) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		em.merge(wishlist);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}
	
	public void removeProduct(int productID, long customerID) {
		
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		em.createQuery("DELETE FROM Wishlist where CustomerID = customerID & ProductID = productID");
		
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	
	}

	public Wishlist findForUser(long customerID) {
		EntityManager em = pm.CreateEntityManager();
		TypedQuery<Wishlist> wr = em.createNamedQuery("SELECT * FROM Wishlist w where CustomerID=customerID", Wishlist.class);
		pm.CloseEntityManager(em);
		List<Wishlist> wl = wr.getResultList();
		ArrayList<Product> pl = new ArrayList<Product>();
		Wishlist pw = new Wishlist(customerID, pl);
		for(Wishlist w : wl) {
			pl.addAll(w.getProducts());
		}
		return pw;
	}
}