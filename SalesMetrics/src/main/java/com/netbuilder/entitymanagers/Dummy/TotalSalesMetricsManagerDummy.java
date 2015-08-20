package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;
import com.netbuilder.entitymanagers.TotalSalesMetricsManager;
import com.netbuilder.model.TotalSalesMetric;

/**
 * @author jmander
 */

@Alternative
public class TotalSalesMetricsManagerDummy implements TotalSalesMetricsManager {
	
	private ArrayList<TotalSalesMetric> totalSalesMetrics = new ArrayList<TotalSalesMetric>();

	
	public ArrayList<TotalSalesMetric> getTotalSalesMetrics() {
		return totalSalesMetrics;
	}

	public void setTotalSalesMetrics(ArrayList<TotalSalesMetric> totalSalesMetrics) {
		this.totalSalesMetrics.addAll(totalSalesMetrics);
	}
	
	public void setTotalSalesMetric(TotalSalesMetric totalSalesMetric){
		totalSalesMetrics.add(totalSalesMetric);
	}
	
	public void persistTotalSalesMetricsValue(TotalSalesMetric totalSalesMetric) {
		setTotalSalesMetric(totalSalesMetric);			
	}

	public void persistTotalSalesMetricsValues(
			ArrayList<TotalSalesMetric> totalSalesMetrics) {
		setTotalSalesMetrics(totalSalesMetrics);;				
	}

	public ArrayList<TotalSalesMetric> findAll() {
			return getTotalSalesMetrics();
	}

	public void addNewSale(int productID, int quantity) {
		for(TotalSalesMetric tsm : getTotalSalesMetrics()){
			if(tsm.getProductID() == productID){
				tsm.setTotalSold(tsm.getTotalSold() + quantity);
				tsm.setTotalDays(tsm.getTotalDays()+1);
			}
		}
	}

	public boolean checkExists(int productID) {
		for(TotalSalesMetric tsm : getTotalSalesMetrics()){
			if(tsm.getProductID() == productID){
				return true;
			}
		}
		return false;
	}
	
}
