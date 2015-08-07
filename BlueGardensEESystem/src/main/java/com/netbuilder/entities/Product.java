package com.netbuilder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author JamesThompson
 * This Entity is used as the mapping for the products table
 */
@Entity
@Table(name = "Products")
@NamedQueries({
	@NamedQuery(name = Product.FIND_BY_OUT_STOCK, query = "SELECT p FROM Products p WHERE p.stockLevel = p.minimumThreshold"),
	@NamedQuery(name = Product.FIND_BY_PRODUCT_ID, query = "SELECT p FROM Products p WHERE p.ProductID = :id"),
	@NamedQuery(name = Product.FIND_BY_NAME, query = "SELECT p FROM Products p WHERE p.ProductName = :name"),
	@NamedQuery(name = Product.FIND_BY_SALE, query = "SELECT p FROM Products p WHERE p.Sale =: true"),
	@NamedQuery(name = Product.FIND_BY_POUROUSWARE, query = "SELECT p FROM Products p WHERE p.Pourousware =: true"),
	@NamedQuery(name = Product.FIND_BY_TRENDING, query = "SELECT p FROM Products p WHERE p.Trending =: true"),
	@NamedQuery(name = Product.FIND_BY_IMAGE_LINK, query = "SELECT p FROM Products p WHERE p.ImageLink = imageLink")
})
public class Product {
	public static final String FIND_BY_OUT_STOCK = "Product.findByOutStock";
	public static final String FIND_BY_PRODUCT_ID = "Product.findByProductId";
	public static final String FIND_BY_NAME = "Product.findByName";
	public static final String FIND_BY_SALE = "Product.findBySale";
	public static final String FIND_BY_POUROUSWARE = "Product.findByPourousware";
	public static final String FIND_BY_TRENDING = "Product.findByTrending";
	public static final String FIND_BY_IMAGE_LINK = "Product.findByImageLink";

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
	
	@Column(name = "isSale", nullable = false)
	@NotNull
	private boolean isSale;
	
	@Column(name = "featureOne", nullable = false, length = 50)
	@NotNull
	private String featureOne;
	
	@Column(name = "featureTwo", nullable = false, length = 50)
	@NotNull
	private String featureTwo;
	
	@Column(name = "featureThree", nullable = false, length = 50)
	@NotNull
	private String featureThree;
	
	@Column(name = "featureFour", nullable = false, length = 50)
	@NotNull
	private String featureFour;
	
	@Column(name = "featureFive", nullable = false, length = 50)
	@NotNull
	private String featureFive;
	
	@Column(name = "imageLink", nullable = false, length = 256)
	@NotNull
	private String imageLink;
	
	@Column(name = "isTrending", nullable = false)
	@NotNull
	private boolean isTrending;

	public Product() { this("test", 0, 0, 0, false, 0.0, false, "feature","feature","feature","feature","feature","imagelink", false); }
	
	/**
	 * This is the preferred constructor implementation as it forces us to specify all of the values that are not nullable
	 * @param productName This is a String for the name of the product
	 * @param stockLevel This is the number of stock that is currently being held for this product
	 * @param minimumThreshold This is the minimum level of stock that can be held before more stock needs to be ordered
	 * @param recommendedLevel This is the level of stock that will be ordered to when stock reaches the minimum threshold
	 * @param isPorousware This indicates whether this item should be treated for porousware
	 * @param price This is the price of the product
	 */
	public Product(String productName, int stockLevel, int minimumThreshold, int recommendedLevel, boolean isPorousware, double price, boolean isSale, String featureOne, String featureTwo, String featureThree, String featureFour, String featureFive, String imageLink, boolean isTrending) {
		this.productName = productName;
		this.stockLevel = stockLevel;
		this.minimumThreshold = minimumThreshold;
		this.recommendedLevel = recommendedLevel;
		this.isPorousware = isPorousware;
		this.price = price;
		this.isSale = isSale;
		this.featureOne = featureOne;
		this.featureTwo = featureTwo;
		this.featureThree = featureThree;
		this.featureFour = featureFour;
		this.featureFive = featureFive;
		this.imageLink = imageLink;
		this.isTrending = isTrending;
	}
	
	public Product(int productID, String productName, int stockLevel, int minimumThreshold, int recommendedLevel, boolean isPorousware, double price, boolean isSale, String featureOne, String featureTwo, String featureThree, String featureFour, String featureFive, String imageLink, boolean isTrending) {
		this.productID = productID;
		this.productName = productName;
		this.stockLevel = stockLevel;
		this.minimumThreshold = minimumThreshold;
		this.recommendedLevel = recommendedLevel;
		this.isPorousware = isPorousware;
		this.price = price;
		this.isSale = isSale;
		this.featureOne = featureOne;
		this.featureTwo = featureTwo;
		this.featureThree = featureThree;
		this.featureFour = featureFour;
		this.featureFive = featureFive;
		this.imageLink = imageLink;
		this.isTrending = isTrending;
	}
	
	public String getProductName() { return productName; }
	public int getStockLevel() { return stockLevel; }
	public int getMinimumThreshold() { return minimumThreshold; }
	public int getRecommendedLevel() { return recommendedLevel; }
	public boolean isPorousware() { return isPorousware; }
	public double getPrice() { return price; }
	public int getProductID() { return productID; }
	public boolean isSale() { return isSale; }
	public String getFeatureOne() { return featureOne; }
	public String getFeatureTwo() { return featureTwo; }
	public String getFeatureThree() { return featureThree; }
	public String getFeatureFour() { return featureFour; }
	public String getFeatureFive() { return featureFive; }
	public String getImageLink(){ return imageLink; }
	public boolean isTrending(){ return isTrending; }
	
	public void setProductName(String productName) { this.productName = productName; }
	public void setStockLevel(int stockLevel) { this.stockLevel = stockLevel; }
	public void setMinimumThreshold(int minimumThreshold) { this.minimumThreshold = minimumThreshold; }
	public void setRecommendedLevel(int recommendedLevel) { this.recommendedLevel = recommendedLevel; }
	public void setPorousware(boolean isPorousware) { this.isPorousware = isPorousware; }
	public void setPrice(double price) { this.price = price; }
	public void setSale(boolean isSale) { this.isSale = isSale; }
	public void setFeatureOne(String featureOne) { this.featureOne = featureOne; }
	public void setFeatureTwo(String featureTwo) { this.featureTwo = featureTwo; }
	public void setFeatureThree(String featureThree) { this.featureThree = featureThree; }
	public void setFeatureFour(String featureFour) { this.featureFour = featureFour; }
	public void setFeatureFive(String featureFive) { this.featureFive = featureFive; }	
	public void setImageLink(String imageLink){ this.imageLink = imageLink; }
	public void setTrending(boolean isTrending){ this.isTrending = isTrending; }
	
	@Override
	public String toString() {
		return "Products [productID=" + productID + ", productName=" + productName + ", stockLevel=" + stockLevel + ", minimumThreshold=" + minimumThreshold + ", recommendedLevel=" + recommendedLevel + ", isPorousware=" + isPorousware + ", price=" + price + ", isSale="+ isSale + ", features: " + featureOne + "; " + featureTwo + "; "  + featureThree + "; "  + featureFour + "; "  + featureFive + ", Imagelink='" + imageLink + "', isTrending=" + isTrending + " ]";
	}
}