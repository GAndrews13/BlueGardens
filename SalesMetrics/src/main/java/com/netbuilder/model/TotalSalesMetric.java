package com.netbuilder.model;


/** 
 * This class will be used like a Product in JavaEE, where we make a new SalesMetricValue for each product each day
 * This will then be added to an ArrayList of SalesMetricValues, to then be printed in the pdf
 * **/
public class TotalSalesMetric {

	private int productID;
	private int totalSold;
	private String productName;
	//so we can determine the total value of the amount of the products sold, productPrice * totalAmountSold
	private double productPrice;
	private int totalDays;
	
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getTotalSold() {
		return totalSold;
	}
	public void setTotalSold(int totalSold) {
		this.totalSold = totalSold;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getTotalDays() {
		return totalDays;
	}
	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}
	
	public TotalSalesMetric(int productID, int totalSold, String productName,
			double productPrice, int totalDays) {
		this.productID = productID;
		this.totalSold = totalSold;
		this.productName = productName;
		this.productPrice = productPrice;
		this.totalDays = totalDays;
	}
	
	
	
}
