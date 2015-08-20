package com.netbuilder.entitymanagers;

import java.util.ArrayList;
import com.netbuilder.model.SalesMetricsValue;

/**
 * 
 * @author jmander
 *
 */
public interface SalesMetricsManager {

	public void persistSalesMetricsValue(SalesMetricsValue salesMetricValue);

	public void persistSalesMetricsValues(ArrayList<SalesMetricsValue> salesMetricsValues);

	public ArrayList<SalesMetricsValue> findAll();

}