package com.netbuilder.entities;

public class Discount {
	private long discountID;
	private double discountLevel;
	private long productID;
	
	public long getDiscountID() {
		return discountID;
	}
	public void setDiscountID(long discountID) {
		this.discountID = discountID;
	}
	public double getDiscountLevel() {
		return discountLevel;
	}
	public void setDiscountLevel(double discountLevel) {
		this.discountLevel = discountLevel;
	}
	public long getProductID() {
		return productID;
	}
	public void setProductID(long productID) {
		this.productID = productID;
	}
	
	
	
}
