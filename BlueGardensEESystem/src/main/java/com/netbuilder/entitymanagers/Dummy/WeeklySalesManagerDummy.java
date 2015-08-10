package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;
import com.netbuilder.entities.WeeklySales;
import com.netbuilder.entitymanagers.WeeklySalesManager;

/**
 * 
 * @author gandrews
 *	Uses a list of WeeklySales to mimic a database interaction
 */
@Alternative
public class WeeklySalesManagerDummy implements WeeklySalesManager {
	private ArrayList<WeeklySales> salesRecord;

	public void persistWeeklySales(WeeklySales inWeeklySales) {
		//TODO dummy impementation
	}

	public void persistWeeklySales(ArrayList<WeeklySales> inWeeklySalesList) {
		//TODO dummy impementation
	}

	public ArrayList<WeeklySales> findByMonth(int inMonthNumber) {
		//TODO dummy impementation
		return null;
	}

	public ArrayList<WeeklySales> findByMinimumSales(int inMinimumSales) {
		//TODO dummy impementation
		return null;
	}
}