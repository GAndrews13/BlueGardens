package com.netbuilder.entitymanagers;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.Product;
import com.netbuilder.entities.Wishlist;

public class WishlistManagerDummy implements WishListManager {
Wishlist wish = new Wishlist();
	//TODO remove
	@Inject
	private PersistanceManager pm;

	public void persistWishlist(Customer inCustomer) {
		EntityManager em = pm.openEntityManager();
		em.getTransaction().begin();
		
		em.persist(wish);
		
		em.getTransaction().commit();
		pm.closeEntityManager(em);

	}

	public void updateWishlist(Product inProduct) {
		EntityManager em = pm.openEntityManager();
		em.getTransaction().begin();
		
		for(int i = 0; i<wish.getProducts().size();i++)
		{
			if(wish.getProducts().get(i).getProductID() == inProduct.getProductID())
			{
				break;
			}
			wish.getProducts().add(inProduct);
		}
		
		em.getTransaction().commit();
		pm.closeEntityManager(em);
	}

	public void updateWishlist(ArrayList<Product> inProductList) {
		EntityManager em = pm.openEntityManager();
		em.getTransaction().begin();
		
		for(int j = 0; j<inProductList.size();j++)
		{
			for(int i = 0; i<wish.getProducts().size();i++)
			{
				if(wish.getProducts().get(i).getProductID() == inProductList.get(j).getProductID())
				{
					break;
				}
				wish.getProducts().add(inProductList.get(j));
			}
		}
		em.getTransaction().commit();
		pm.closeEntityManager(em);
	}

	public void removeProduct(Product inProduct) {
		EntityManager em = pm.openEntityManager();
		em.getTransaction().begin();
		
		wish.getProducts().remove(inProduct);
		
		em.getTransaction().commit();
		pm.closeEntityManager(em);
	}

	public void removeProducts(ArrayList<Product> inProductList) {
		EntityManager em = pm.openEntityManager();
		em.getTransaction().begin();
		
		wish.getProducts().removeAll(inProductList);
		
		em.getTransaction().commit();
		pm.closeEntityManager(em);
	}

	public ArrayList<Product> findProductByName(String inName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Product findProductByID(int inID) {
		EntityManager em = pm.openEntityManager();
		em.getTransaction().begin();
		
		Product pr;
		for(Product p : wish.getProducts())
		{
			if(p.getProductID() == inID)
			{
				pr = p;
				break;
			}
		}
		
		em.getTransaction().commit();
		pm.closeEntityManager(em);
		return pr;
	}

	public ArrayList<Product> findAll() {
		EntityManager em = pm.openEntityManager();
		em.getTransaction().begin();

		pr = wish.getProducts();
		
		em.getTransaction().commit();
		pm.closeEntityManager(em);
		
		return pr;
	}

}
