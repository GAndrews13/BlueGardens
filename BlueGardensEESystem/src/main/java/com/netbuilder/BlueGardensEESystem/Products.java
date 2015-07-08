package com.netbuilder.BlueGardensEESystem;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

/**
 * 
 * @author JamesThompson
 * This Entity is used as the mapping for the products table
 */
@Entity
@Table(name = "Products")
public class Products {
	
	@Id
	@Column(name = "productID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int productID;
	
	@Column(name = "productName", nullable = false, length = 45)
	@NotNull
	@Size(min=2, max = 45)
	private String productName;
 
	@Column(name = "stockLevel", nullable = false)
	@NotNull
	private int stockLevel;	

	@Column(name = "minimumThreshold", nullable = false)
	@NotNull
	private int minimumThreshold;

	@Column(name = "recomendedLevel", nullable = false)
	@NotNull
	private int recommendedLevel;

	@Column(name = "isPorousware", nullable = false)
	@NotNull
	private boolean isPorousware;

	@Column(name = "price", nullable = false)
	@NotNull
	private double price;
	
	/**
	 * This is the default constructor for the Product entity. It sets all of the properties to their default values.
	 */
	public Products() {
		this("test", 0, 0, 0, false, 0.0);
	}
	
	/**
	 * This is the preferred constructor implementation as it forces us to specify all of the values that are not nullable
	 * @param productName This is a String for the name of the product
	 * @param stockLevel This is the number of stock that is currently being held for this product
	 * @param minimumThreshold This is the minimum level of stock that can be held before more stock needs to be ordered
	 * @param recommendedLevel This is the level of stock that will be ordered to when stock reaches the minimum threshold
	 * @param isPorousware This indicates whether this item should be treated for porousware
	 * @param price This is the price of the product
	 */
	public Products(String productName, int stockLevel, int minimumThreshold,
			int recommendedLevel, boolean isPorousware, double price) {
		this.productName = productName;
		this.stockLevel = stockLevel;
		this.minimumThreshold = minimumThreshold;
		this.recommendedLevel = recommendedLevel;
		this.isPorousware = isPorousware;
		this.price = price;
	}
	
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

	
	@Override
	public String toString() {
		return "Products [productID=" + productID + ", productName="
				+ productName + ", stockLevel=" + stockLevel
				+ ", minimumThreshold=" + minimumThreshold
				+ ", recommendedLevel=" + recommendedLevel + ", isPorousware="
				+ isPorousware + ", price=" + price + "]";
	}
}
