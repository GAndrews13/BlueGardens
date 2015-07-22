package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.netbuilder.BlueGardensEESystem.PersistenceManager;
import com.netbuilder.entities.Product;
import com.netbuilder.entities.Wishlist;
import com.netbuilder.entitymanagers.WishListManager;

/**
 * 
 * @author gandrews
 *	Uses a dummy wishlist object to imitate its real interactions with the system
 */
@Alternative
public class WishlistManagerDummy implements WishListManager {
Wishlist wish = new Wishlist();
	@Inject
	private PersistenceManager pm;

	public void persistWishlist(Wishlist inWishList) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		
		wish = inWishList;
		
		em.getTransaction().commit();
		pm.CloseEntityManager(em);

	}

	public void updateWishlist(Product inProduct) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		
		for(int i = 0; i<wish.getProducts().size();i++)
		{
			if(wish.getProducts().get(i).getProductID() == inProduct.getProductID())
			{
				wish.getProducts().set(i,inProduct);
			}
			wish.getProducts().add(inProduct);
		}
		
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	public void updateWishlist(ArrayList<Product> inProductList) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		
		for(int j = 0; j<inProductList.size();j++)
		{
			for(int i = 0; i<wish.getProducts().size();i++)
			{
				if(wish.getProducts().get(i).getProductID() == inProductList.get(j).getProductID())
				{
					wish.getProducts().set(i,inProductList.get(j));
				}
				wish.getProducts().add(inProductList.get(j));
			}
		}
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	public void removeProduct(Product inProduct) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		
		wish.getProducts().remove(inProduct);
		
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	public void removeProducts(ArrayList<Product> inProductList) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		
		wish.getProducts().removeAll(inProductList);
		
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	public ArrayList<Product> findProductByName(String inName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Product findProductByID(int inID) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		
		Product pr = null;
		for(Product p : wish.getProducts())
		{
			if(p.getProductID() == inID)
			{
				pr = p;
				break;
			}
		}
		
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
		return pr;
	}

	public ArrayList<Product> findAll() {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		ArrayList<Product> pr = new ArrayList<Product>();
		pr = wish.getProducts();
		
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
		
		return pr;
	}

}
