package com.netbuilder.controller;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;

import com.netbuilder.model.DeliveryStatus;
import com.netbuilder.model.CustomerOrder;
import com.netbuilder.model.Product;
import com.netbuilder.controller.CustomerOrderLineManager;
import com.netbuilder.controller.CustomerOrderManager;
import com.netbuilder.controller.ProductManager;
import com.netbuilder.model.Utility.SessionBasket;

@Controller
public class BasketController {

	private SessionBasket sessionBasket;
	private ProductManager productManager;
	private CustomerOrderManager customerOrderManager;
	private CustomerOrderLineManager customerOrderLineManager;
	private DeliveryStatus deliveryStatus;
	private ArrayList<Product> items = new ArrayList<Product>();
	private int quantity;
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ArrayList<Product> getItems() {
		return items;
	}

	public void setItems(ArrayList<Product> items) {
		this.items = items;
	}

	public BasketController(){
	}
	
	public String addProduct(int productID){
		if(quantity!=0){
			sessionBasket.addToBasket(productID, quantity);
			items.add(productManager.findById(productID));
		}
		quantity = 1;
		return "productCatalog";
	}
	
	public double findTotal()
	{
		double total = Math.round(sessionBasket.getTotal());
		return total;
	}
	
	public void checkoutBasket(){
		for(int i=0; i<sessionBasket.getBasket().getCustomerOrderLines().size(); i++){
			customerOrderLineManager.persistCustomerOrderLine(sessionBasket.getBasket().getCustomerOrderLines().get(i));
		}
		customerOrderManager.persistCustomerOrder(new CustomerOrder(
				sessionBasket.getBasket().getCustomerOrderID(), false, sessionBasket.getBasket().getCustomerOrderID(), "Standard delivery",
				sessionBasket.getBasket().getCustomerId(), 0, deliveryStatus.ORDER_PLACED, findTotal()));
	}

}
