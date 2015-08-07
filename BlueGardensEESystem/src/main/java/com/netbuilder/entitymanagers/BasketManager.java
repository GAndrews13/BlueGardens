package com.netbuilder.entitymanagers;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.enterprise.inject.Alternative;

import com.netbuilder.entities.Basket;
import com.netbuilder.entities.CustomerOrderLine;
import com.netbuilder.entities.Product;
import com.netbuilder.entities.ProductOrderLine;

/**
 * @author abalagel
 * maps the outline of the db
 */

public interface BasketManager {

	public void persistBasket(Basket basket);
	public void updateBasket(Basket basket);
	//public Basket findById(int id);  //customer id
	
	/**
	 * @author gandrews
	 */
	public double findTotal();
	public ArrayList<CustomerOrderLine> products();
}
