package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import com.netbuilder.BlueGardensEESystem.DeliveryStatus;
import com.netbuilder.entities.CustomerOrder;
import com.netbuilder.entities.Product;
import com.netbuilder.entitymanagers.CustomerOrderLineManager;
import com.netbuilder.entitymanagers.CustomerOrderManager;
import com.netbuilder.entitymanagers.ProductManager;
import com.netbuilder.util.SessionBasket;

/**
 * @author jmander
 * **/

@ManagedBean(name="basketController")
@SessionScoped
public class BasketController {

	@Inject
	private SessionBasket sessionBasket;
	@Inject
	private ProductManager productManager;
	@Inject
	private CustomerOrderManager customerOrderManager;
	@Inject
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
