package com.netbuilder.BlueGardensEESystem;

public class Products {

	private int productID;
	private String productName;
	private int stockLevel;
	private int minimumThreshold;
	private int recommendedLevel;
	private boolean isPorousware;
	private double price;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public int getStockLevel() {
		return stockLevel;
	}
	public void setStockLevel(int stockLevel) {
		this.stockLevel = stockLevel;
	}
	
	public int getMinimumThreshold() {
		return minimumThreshold;
	}
	public void setMinimumThreshold(int minimumThreshold) {
		this.minimumThreshold = minimumThreshold;
	}
	
	public int getRecommendedLevel() {
		return recommendedLevel;
	}
	public void setRecommendedLevel(int recommendedLevel) {
		this.recommendedLevel = recommendedLevel;
	}
	
	public boolean isPorousware() {
		return isPorousware;
	}
	public void setPorousware(boolean isPorousware) {
		this.isPorousware = isPorousware;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getProductID() {
		return productID;
	}
}
