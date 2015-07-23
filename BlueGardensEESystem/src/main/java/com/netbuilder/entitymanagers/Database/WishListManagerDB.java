package com.netbuilder.entitymanagers.Database;

import java.util.List;
import java.util.ArrayList;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.netbuilder.BlueGardensEESystem.PersistenceManager;
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
	
	public void persistWishlist(Wishlist wishList) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		em.persist(wishList);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	public void updateWishlist(Wishlist wishList) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		em.merge(wishList);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	public void removeProduct(Wishlist wishList) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		em.remove(wishList);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	public void removeProducts(ArrayList<Wishlist> wishlists) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		for(Wishlist p : wishlists) {
			em.remove(p);
		}
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	@Override
	public ArrayList<Product> findForUser(long customerID) {
		EntityManager em = pm.CreateEntityManager();
		TypedQuery<Wishlist> wr = em.createNamedQuery("SELECT * FROM Wishlist w where CustomerID=customerID", Wishlist.class);
		pm.CloseEntityManager(em);
		List<Wishlist> wl = wr.getResultList();
		ArrayList<Product> pl = new ArrayList<Product>();
		for(Wishlist w : wl) {
			pl.addAll(w.getProducts());
		}
		return pl;
	}
	
	public void updateWishlists(ArrayList<Wishlist> wishlists) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		for(Wishlist p : wishlists) {
			em.merge(p);
		}
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}
}