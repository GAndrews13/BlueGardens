package com.netbuilder.util;

import javax.faces.bean.SessionScoped;
import javax.inject.Singleton;
import com.netbuilder.entities.Basket;
import com.netbuilder.entities.CustomerOrderLine;

@SessionScoped
@Singleton
public class SessionBasket {

	private Basket basket;
	
	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	public SessionBasket(){
	}
	
	public void addToBasket(int productID){
		System.out.println(productID);
		basket.getCustomerOrderLines().add(new CustomerOrderLine(productID, 1));
		System.out.println(basket);
		for(int i=0; i<basket.getCustomerOrderLines().size(); i++){
			System.out.println(basket.getCustomerOrderLines().get(i).getProductId());
			System.out.println(basket.getCustomerOrderLines().get(i).getQuantity());
		}
	}
	
}
