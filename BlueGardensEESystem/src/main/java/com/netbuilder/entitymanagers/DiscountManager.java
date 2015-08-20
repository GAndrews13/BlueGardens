package com.netbuilder.entitymanagers;

import com.netbuilder.entities.Discount;

/**
 * Used to record the level of discounts applied to products
 * @author GAndrews
 * @author ABalagel
 *
 */
public interface DiscountManager {
	public void persistDiscount(Discount inDiscount);
	
	public void disableDiscount(Discount inDiscount);
	
	public void findDiscountById(long inDiscountID);
	
	public void updateDiscount(Discount inDiscount);
	
	public double getDiscountLevel(long inDiscountID);
}
