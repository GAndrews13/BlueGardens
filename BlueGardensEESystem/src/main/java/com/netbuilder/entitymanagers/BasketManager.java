package com.netbuilder.entitymanagers;

import com.netbuilder.entities.Basket;

/**
 * @author abalagel
 * maps the outline of the db
 */
public interface BasketManager {

	public void persistBasket(Basket basket);
	public void updateBasket(Basket basket);
	public Basket findById(int id);  //customer id
}
