package com.netbuilder.entitymanagers;

import java.util.ArrayList;

import com.netbuilder.model.TotalSalesMetric;

/**
 * 
 * @author jmander
 *
 */
public interface TotalSalesMetricsManager {

	public void persistTotalSalesMetricsValue(TotalSalesMetric totalSalesMetric);

	public void persistTotalSalesMetricsValues(ArrayList<TotalSalesMetric> totalSalesMetrics);

	public ArrayList<TotalSalesMetric> findAll();
	
	public void addNewSale(int productID, int quantity);
	
	public boolean checkExists (int productID);

}