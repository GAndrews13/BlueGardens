package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;

import com.netbuilder.entities.Basket;
import com.netbuilder.entitymanagers.BasketManager;


/**
 * @author abalagel
 * links interface with db
 */
@Alternative
public class BasketManagerDummy implements BasketManager {
ArrayList<Basket> localbasket = new ArrayList<Basket>(); 
	
	public void persistBasket(Basket basket){
	localbasket.add(basket);
	}
	
	public void updateBasket(Basket basket){
	localbasket.set(localbasket.indexOf(basket),basket);
	}	
	
	public Basket findById(int id){
	for(Basket b : localbasket)
	{
		if(b.getCustomerId() == id)
		{
			return b;
		}
	}
	return null;
}; 
}
