package com.netbuilder.model;


/**
 * 
 * @author JamesThompson This Entity is used as the mapping for the products
 *         table
 */

public class Product {

	private int productID;


	private String productName;

	private int stockLevel;

	private int minimumThreshold;

	private int recommendedLevel;


	private boolean isPorousware;


	private double price;

	/**
	 * Added more attributes in a boolean for whether in sale, along with the
	 * description strings and a string which contains the link for the products
	 * image.
	 * 
	 * @author lczornyj
	 */


	private boolean isSale;

	// FEATURE 1 AND FEATURE 2 ARE THE ONES THAT ARE VISABLE IN THE LANDING
	// PAGE, MAKE SURE THESE ARE THE MAIN FEATURES
	// THAT YOU WANT VISABLE FOR THE USER.

	private String featureOne;


	private String featureTwo;

	private String featureThree;


	private String featureFour;

	private String featureFive;

	private String imageLink;

	private boolean isTrending;

	/**
	 * The isTrending above is the last implementation for the variables
	 * 
	 * @author lczornyj
	 */

	/**
	 * This is the default constructor for the Product entity. It sets all of
	 * the properties to their default values.
	 */
	public Product() {
		this("test", 0, 0, 0, false, 0.0, false, "feature", "feature",
				"feature", "feature", "feature", "imagelink", false);
	}

	/**
	 * This is the preferred constructor implementation as it forces us to
	 * specify all of the values that are not nullable
	 * 
	 * @param productName
	 *            This is a String for the name of the product
	 * @param stockLevel
	 *            This is the number of stock that is currently being held for
	 *            this product
	 * @param minimumThreshold
	 *            This is the minimum level of stock that can be held before
	 *            more stock needs to be ordered
	 * @param recommendedLevel
	 *            This is the level of stock that will be ordered to when stock
	 *            reaches the minimum threshold
	 * @param isPorousware
	 *            This indicates whether this item should be treated for
	 *            porousware
	 * @param price
	 *            This is the price of the product
	 */
	public Product(String productName, int stockLevel, int minimumThreshold,
			int recommendedLevel, boolean isPorousware, double price,
			boolean isSale, String featureOne, String featureTwo,
			String featureThree, String featureFour, String featureFive,
			String imageLink, boolean isTrending) {
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

	public Product(int productID, String productName, int stockLevel,
			int minimumThreshold, int recommendedLevel, boolean isPorousware,
			double price, boolean isSale, String featureOne, String featureTwo,
			String featureThree, String featureFour, String featureFive,
			String imageLink, boolean isTrending) {
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

	/**
	 * Added setters and getters for new variables added
	 * 
	 * @author lczornyj
	 * @return
	 */
	public boolean isSale() {
		return isSale;
	}

	public void setSale(boolean isSale) {
		this.isSale = isSale;
	}

	public String getFeatureOne() {
		return featureOne;
	}

	public void setFeatureOne(String featureOne) {
		this.featureOne = featureOne;
	}

	public String getFeatureTwo() {
		return featureTwo;
	}

	public void setFeatureTwo(String featureTwo) {
		this.featureTwo = featureTwo;
	}

	public String getFeatureThree() {
		return featureThree;
	}

	public void setFeatureThree(String featureThree) {
		this.featureThree = featureThree;
	}

	public String getFeatureFour() {
		return featureFour;
	}

	public void setFeatureFour(String featureFour) {
		this.featureFour = featureFour;
	}

	public String getFeatureFive() {
		return featureFive;
	}

	public void setFeatureFive(String featureFive) {
		this.featureFive = featureFive;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public boolean isTrending() {
		return isTrending;
	}

	public void setTrending(boolean isTrending) {
		this.isTrending = isTrending;
	}

	/**
	 * Overrides the to wring method to return all the relevant information for
	 * the product alongside tags outlining what each piece of data represents
	 */
	@Override
	public String toString() {
		return "Products [productID=" + productID + ", productName="
				+ productName + ", stockLevel=" + stockLevel
				+ ", minimumThreshold=" + minimumThreshold
				+ ", recommendedLevel=" + recommendedLevel + ", isPorousware="
				+ isPorousware + ", price=" + price + ", isSale=" + isSale
				+ ", features: " + featureOne + "; " + featureTwo + "; "
				+ featureThree + "; " + featureFour + "; " + featureFive
				+ ", Imagelink='" + imageLink + "', isTrending=" + isTrending
				+ " ]";
	}
}
