package com.netbuilder.controllers;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.BlueGardensEESystem.DeliveryStatus;
import com.netbuilder.entities.Basket;
import com.netbuilder.entities.CustomerOrder;
import com.netbuilder.entities.Product;
import com.netbuilder.entities.ProductOrderLine;
import com.netbuilder.entitymanagers.BasketManager;
import com.netbuilder.service.BasketProductOrderService;

@SessionScoped
@ManagedBean (name="basketController")
public class BasketController implements Serializable{
	@Inject
	private BasketManager bm;
	private String errormsg; 
	private double basketTotal = 0;
	private ArrayList<Product> items;
	
	public ArrayList<Product> getItems() {
		items = getItemsFromPOLS();
		return items;
	}
	
	public ArrayList<Product> getItemsFromPOLS() {
		ArrayList<Product> temp = new ArrayList<Product>();
		for(int i = 0;i<bm.products().size();i++) {
			temp.add(bm.products().get(i).getProduct());
		}
		return temp;
	}
	
	public double getBasketTotal() {
		basketTotal = bm.findTotal();
		return basketTotal;
	}
	
	public String getErrormsg() { return errormsg; }
	public BasketManager getBm() { return bm; }
	public ArrayList<ProductOrderLine> pols() { return bm.products(); }
	
	public void setBasketTotal(double basketTotal) { this.basketTotal = basketTotal; }
	public void setBm(BasketManager bm) { this.bm = bm; }
	public void setErrormsg(String errormsg) { this.errormsg = errormsg; }

	public void addProduct(Product inProduct) {
		bm.products().add(new ProductOrderLine(inProduct,1));
	}
	
	public void submitBasket(Basket inBasket) {
		BasketProductOrderService.createBasketOrder(inBasket);
	}
}