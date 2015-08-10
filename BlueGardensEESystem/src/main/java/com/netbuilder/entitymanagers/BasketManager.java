package com.netbuilder.entitymanagers;

import java.util.ArrayList;

import com.netbuilder.entities.Basket;
import com.netbuilder.entities.CustomerOrderLine;

/**
 * @author abalagel maps the outline of the db
 */

public interface BasketManager {

	public void persistBasket(Basket basket);

	public void updateBasket(Basket basket);

	// public Basket findById(int id); //customer id
	public void addProduct(int productID, int quantity);

	/**
	 * @author gandrews
	 */
	public double findTotal();

	public ArrayList<CustomerOrderLine> products();
}
