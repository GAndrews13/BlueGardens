package com.netbuilder.controllers;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ReferencedBean;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.BlueGardensEESystem.DeliveryStatus;
import com.netbuilder.entities.Basket;
import com.netbuilder.entities.CustomerOrder;
import com.netbuilder.entities.CustomerOrderLine;
import com.netbuilder.entities.Product;
import com.netbuilder.entities.ProductOrderLine;
import com.netbuilder.entitymanagers.BasketManager;
import com.netbuilder.entitymanagers.ProductManager;
import com.netbuilder.service.BasketProductOrderService;


@Singleton
@Startup
@ReferencedBean(name = "basketController")
public class BasketController implements Serializable{
	@Inject
	private BasketManager bm;
	@Inject
	private ProductManager productManager;
	private String errormsg; 
	private double basketTotal =0;
	private ArrayList<Product> items;
	
	public ArrayList<Product> getItems() {
		items = getItemsFromPOLS();
		return items;
	}
	
	public ArrayList<Product> getItemsFromPOLS()
	{
		ArrayList<Product> temp = new ArrayList<Product>();
		for(int i = 0;i<bm.products().size();i++)
		{
			temp.add(productManager.findById(bm.products().get(i).getProductId()));
		}
		return temp;
	}
	
	public double getBasketTotal() {
		basketTotal = bm.findTotal();
		return basketTotal;//bm.findTotal();
	}

	public void setBasketTotal(double basketTotal) {
		this.basketTotal = basketTotal;
	}

	public BasketManager getBm() {
		return bm;
	}

	public void setBm(BasketManager bm) {
		this.bm = bm;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public ArrayList<CustomerOrderLine> pols()
	{
		return bm.products();
	}
	
	public void addProduct(int inProduct)
	{
		bm.products().add(new CustomerOrderLine(inProduct,1));
	}
	
	public void submitBasket(Basket inBasket)
	{
		BasketProductOrderService.createBasketOrder(inBasket);
	}
}
/*
* dispay basket on page
* from contoller (thep page doesnt know what to do with a basket) you need to go to the se4rvice layer
* from the tte service you need to got o the basket managfer, get the basket, bull out the products. send back to controller as array
* XHTML have some dynamic table thing to display each element in array.
* 
*/