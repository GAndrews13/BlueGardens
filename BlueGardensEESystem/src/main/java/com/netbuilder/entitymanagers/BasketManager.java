package com.netbuilder.entitymanagers;

import com.netbuilder.entities.Basket;

public interface BasketManager {

	public void persistBasket(Basket basket);
	public void updateBasket(Basket basket);
	public Basket findById(int id);  //customer id
}
