package com.netbuilder.BlueGardensEESystem;

/**
 * 
 * @author gandrews
 * Represents the products that are stored and can be sold to the client
 */
public class Products {

	/**
	 * The unique ID associated with that particular product (product and if porouswared)
	 */
	private int productID;
	/**
	 * The name that is used to represent the product within the system and catalogue
	 */
	private String productName;
	/**
	 * The number of items that are currently avaliable to be sold
	 */
	private int stockLevel;
	/**
	 * The Level at which stock should be reordered
	 */
	private int minimumThreshold;
	/**
	 * The level at which stock should be reordered to when it reaches the minimumThreshold
	 */
	private int recommendedLevel;
	/**
	 * If the item is pre-porouswared this is true
	 */
	private boolean isPorousware;
	/**
	 * The price of the item that is given to the customer
	 */
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
