package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.netbuilder.controllers.SalesMetricsTextReader;
import com.netbuilder.entitymanagers.SalesMetricsManager;
import com.netbuilder.model.SalesMetricsValue;

/**
 * @author jmander
 */

@Alternative
public class SalesMetricsManagerDummy implements SalesMetricsManager {

	@Inject
	private SalesMetricsTextReader salesMetricsTextReader;

	public void persistSalesMetricsValue(SalesMetricsValue salesMetricValue) {
		salesMetricsTextReader.setSalesMetricsValue(salesMetricValue);			
	}

	public void persistSalesMetricsValues(
			ArrayList<SalesMetricsValue> salesMetricsValues) {
		salesMetricsTextReader.setSalesMetricsValues(salesMetricsValues);		
	}
	
	public ArrayList<SalesMetricsValue> findAll() {
		return salesMetricsTextReader.getSalesMetricsValues();
	}
	
}
