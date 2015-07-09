package com.netbuilder.entitymanagers;

import java.util.ArrayList;
import com.netbuilder.entities.Basket;


/**
 * @author abalagel
 * links interface with db
 */
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
