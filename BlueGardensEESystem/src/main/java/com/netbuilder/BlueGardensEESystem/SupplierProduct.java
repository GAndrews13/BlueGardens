package com.netbuilder.BlueGardensEESystem;

public class SupplierProduct {
/**
 * @author abalagel
 * Attributes for product received from supplier
 * includes supplier unique ID, product unique ID and the purchasing price from supplier
*/
	private int supplierId;
	private int productId;
	private double price;
/**
 * @author abalagel
 * getters and setters for class variables
 *initialise class
*/
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getSupplierId() {
		return supplierId;
	}

}
