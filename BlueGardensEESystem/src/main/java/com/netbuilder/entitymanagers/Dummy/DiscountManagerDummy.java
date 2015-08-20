package com.netbuilder.entitymanagers.Dummy;

import java.lang.reflect.Array;
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
	@Override
	public void persistDiscount(Discount inDiscount) {
		
	}

	@Override
	public void disableDiscount(Discount inDiscount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void findDiscountById(long inDiscountID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateDiscount(Discount inDiscount) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getDiscountLevel(long inDiscountID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
