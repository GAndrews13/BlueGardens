package com.netbuilder.entitymanagers.Database;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.netbuilder.BlueGardensEESystem.PersistenceManager;
import com.netbuilder.entities.WishlistItems;
import com.netbuilder.entitymanagers.WishListManager;

/**
 * 
 * @author Anca Interfaces the database and the Wishlist entity
 */
@Alternative
public class WishListManagerDB implements WishListManager {
	@Inject
	private PersistenceManager pm;

	public void persistWishlistItem(WishlistItems wishlistitem) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();

		em.persist(wishlistitem);

		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	public void persistWishlistItems(ArrayList<WishlistItems> wishlistitems) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();

		for (WishlistItems wishlistItem : wishlistitems) {
			em.persist(wishlistItem);
		}
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	public void removeProduct(int productID, long customerID) {
		EntityManager em = pm.CreateEntityManager();
		em.createQuery(
				"DELETE FROM WishlistItems WHERE ProductID=productID & CustomerID=customerID",
				WishlistItems.class);
		pm.CloseEntityManager(em);
	}

	public ArrayList<WishlistItems> findForUser(long customerID) {
		EntityManager em = pm.CreateEntityManager();
		ArrayList<WishlistItems> wishlist = (ArrayList<WishlistItems>) em
				.createQuery(WishlistItems.FIND_BY_CUSTOMER_ID,
						WishlistItems.class).getResultList();
		pm.CloseEntityManager(em);
		try {
			return wishlist;
		} catch (Exception e) {
			return null;
		}
	}

}