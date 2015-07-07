package com.netbuilder.BlueGardensEESystem;

import java.util.ArrayList;

public class Basket {
	private int customerId;
	private ArrayList<ProductOrderLine> ProductOrderLine;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public ArrayList<ProductOrderLine> getProductOrderLine() {
		return ProductOrderLine;
	}
	public void setProductOrderLine(ArrayList<ProductOrderLine> productOrderLine) {
		ProductOrderLine = productOrderLine;
	}
}
