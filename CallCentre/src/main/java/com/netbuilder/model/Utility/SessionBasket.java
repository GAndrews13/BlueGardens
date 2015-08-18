package com.netbuilder.model.Utility;
import org.springframework.beans.factory.annotation.Autowired;

import com.netbuilder.model.Basket;
import com.netbuilder.model.CustomerOrderLine;
import com.netbuilder.controller.ProductManager;

/**
 * @author jmander
 * **/

public class SessionBasket {

	private Basket basket;
	@Autowired
	ProductManager productManager;
	
	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	public SessionBasket(){
	}
	public double getTotal()
	{
		double total = 0;
		if (basket.getCustomerOrderLines() != null) {
			for (int i = 0; i < basket.getCustomerOrderLines().size(); i++) {
				total += basket.getCustomerOrderLines().get(i).getQuantity()* productManager.findById(
						basket.getCustomerOrderLines().get(i).getProductId()).getPrice();
			}
		}
		return total;
	}
	
	public void addToBasket(int productID, int quantity){
		basket.getCustomerOrderLines().add(new CustomerOrderLine(getBasket().getCustomerOrderID(), productID, quantity, false));
	}

	public void removeFromBasket(int productID) {
		for(int i = 0; i<basket.getCustomerOrderLines().size(); i++){
			if(basket.getCustomerOrderLines().get(i).getProductId() == productID){
				basket.getCustomerOrderLines().remove(i);
			}
		}
	}
	
}
	
