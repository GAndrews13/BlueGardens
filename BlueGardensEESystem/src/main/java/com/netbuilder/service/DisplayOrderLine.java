package com.netbuilder.service;

import com.netbuilder.entities.Product;

public class DisplayOrderLine {

	private Product product;
	private int quantity;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public DisplayOrderLine(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

}
