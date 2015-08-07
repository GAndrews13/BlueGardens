package com.netbuilder.entitymanagers;

import java.util.ArrayList;

import com.netbuilder.entities.WeeklySales;

/**
 * 
 * @author gandrews
 *
 */
public interface WeeklySalesManager {
	public void persistWeeklySales(WeeklySales inWeeklySales);
	public void persistWeeklySales(ArrayList<WeeklySales> inWeeklySalesList);
	public ArrayList<WeeklySales> findByMonth(int inMonthNumber);
	public ArrayList<WeeklySales> findByMinimumSales(int inMinimumSales);
}