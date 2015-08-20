package com.netbuilder.entities;

/**
 * 
 * @author GAndrews
 * @author ABalagel
 *
 */
public class Discount {
	/**
	 * A unique reference to this discount
	 */
	private long discountID;
	/**
	 * The amount that the discount gives
	 */
	private double discountLevel;
	/**
	 * the specific product that this discount applies to
	 */
	private long productID;
	/**
	 * The discount type (FLAT/PERCENTAGE)
	 */
	private String discountType;
	
	public String getDiscountType() {
		return discountType;
	}
	public void setDiscountType(String discountType) {
		if(discountType == "FLAT" || discountType=="PERCENTAGE")
		{
			this.discountType = discountType;
		}
		else
		{
			this.discountType = "FLAT";
		}
	}
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
	
	public Discount(long inProductID, double inDiscountLevel, String inDiscountType)
	{
		this.productID = inProductID;
		this.discountLevel = inDiscountLevel;
		this.discountType = inDiscountType;
	}
	
}
