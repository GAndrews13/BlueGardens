package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.netbuilder.entitymanagers.SalesMetricsManager;
import com.netbuilder.entitymanagers.TotalSalesMetricsManager;
import com.netbuilder.model.SalesMetricsValue;
import com.netbuilder.model.TotalSalesMetric;

/**
 * @author jmander
 **/
@ManagedBean(name = "salesMetricsController")
@RequestScoped
public class SalesMetricsController {
	@Inject
	private SalesMetricsManager salesMetricsManager;
	@Inject
	private TotalSalesMetricsManager totalSalesMetricsManager;
	private ArrayList<TotalSalesMetric> results = new ArrayList<TotalSalesMetric>();
	private boolean itemExists = false;

	public SalesMetricsController() {
	}

	public ArrayList<TotalSalesMetric> getResults() {
		return results;
	}

	public void setResults(ArrayList<TotalSalesMetric> results) {
		this.results = results;
	}

	public String search() {
		for(SalesMetricsValue smv : salesMetricsManager.findAll()){
			itemExists = totalSalesMetricsManager.checkExists(smv.getProductID());
			if(itemExists){
				totalSalesMetricsManager.addNewSale(smv.getProductID(), smv.getTotalAmountSold());
			}else{
				totalSalesMetricsManager.persistTotalSalesMetricsValue(new TotalSalesMetric(
						smv.getProductID(), smv.getTotalAmountSold(), smv.getProductName(), smv.getProductPrice(), 1));
			}
			itemExists = false;
		}
		results = totalSalesMetricsManager.findAll();
		return "salesMetrics";
	}
	
}