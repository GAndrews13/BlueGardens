package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import com.netbuilder.entities.Product;
import com.netbuilder.util.SessionBasket;

@ManagedBean(name="basketController")
@SessionScoped
public class BasketController {

	@Inject
	private SessionBasket sessionBasket;
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
		System.out.println(productID);
		sessionBasket.addToBasket(productID);
		return "landingPage";
	}
}
