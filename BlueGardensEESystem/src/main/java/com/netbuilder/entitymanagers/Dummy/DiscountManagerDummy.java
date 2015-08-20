package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;
import com.netbuilder.entities.Discount;
import com.netbuilder.entitymanagers.DiscountManager;
import com.netbuilder.util.DummyData;

/**
 * 
 * @author GAndrews
 *	@author ABalagel
 */
public class DiscountManagerDummy implements DiscountManager {
	private DummyData dd = new DummyData();
	/**
	 * Creates the particular discount in the dummy data 
	 */
	@Override
	public void persistDiscount(Discount inDiscount) {
		ArrayList<Discount> dl =dd.getDiscounts();
		dl.add(inDiscount);
		dd.setDiscounts(dl);
	}
	
	/**
	 * Returns the discount level of the selected discount
	 */
	@Override
	public double getDiscountLevel(long inDiscountID) {
		ArrayList<Discount> dl = dd.getDiscounts();
		for(Discount d : dl)
		{
			if(d.getDiscountID() == inDiscountID)
			{
				return d.getDiscountLevel();
			}
		}
		return 0;
	}

	/**
	 * Searches for and finds a discount with the inserted discount ID
	 * WARNING: May return null
	 */
	@Override
	public Discount findDiscountById(long inDiscountID) {
		ArrayList<Discount> dl = dd.getDiscounts();
		for(Discount d : dl)
		{
			if(d.getDiscountID() == inDiscountID)
			{
				return d;
			}
		}
		return null;
	}

	/**
	 * Searches for a matching discount and then replaces the original one with the new variation
	 */
	@Override
	public void updateDiscount(Discount inDiscount) {
		ArrayList<Discount> dl = dd.getDiscounts();
		for(int i = 0;i<dl.size();i++)
		{	
			Discount td = dl.get(i);
			if(td.getDiscountID() == inDiscount.getDiscountID())
			{
				dl.set(i, inDiscount);
				break;
			}
		}
		dd.setDiscounts(dl);
	}
}
