package com.netbuilder.entitymanagers;

import java.util.ArrayList;

import com.netbuilder.entities.Basket;
import com.netbuilder.entities.ProductOrderLine;

/**
 * @author abalagel
 * maps the outline of the db
 */
public interface BasketManager {
	public void persistBasket(Basket basket);
	public void updateBasket(Basket basket);
	
	/**
	 * @author gandrews
	 */
	public double findTotal();
	public ArrayList<ProductOrderLine> products();
}