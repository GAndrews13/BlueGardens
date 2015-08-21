package com.netbuilder.controllers;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;

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
	private TotalSalesMetric swap;
	
	public SalesMetricsController() {
	}

	public ArrayList<TotalSalesMetric> getResults() {
		return results;
	}

	public void setResults(ArrayList<TotalSalesMetric> results) {
		this.results = results;
	}

	public String search() {
		initialiseData();
		results = totalSalesMetricsManager.findAll();
		return "salesMetrics";
	}
	
	public void initialiseData(){
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
	}
	
	@GET
	// @Path("salesMetrics.xhtml")
	public void getProductByID() {
		HttpServletRequest hsr = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		String pid = hsr.getQueryString();
		pid = pid.replace("[", "");
		pid = pid.replace("]", "");
		pid = pid.replace("sort=", "");
		
		if(Integer.parseInt(pid)==1){
			initialiseData();
			results = totalSalesMetricsManager.findAll();
			for (int i=0; i<results.size()-1; i++){
				for (int j=0; j<results.size()-1; j++){
					if(results.get(j).getProductID() > results.get(j+1).getProductID()){
						swap = results.get(j);
						results.set(j, results.get(j+1));
						results.set(j+1, swap);
					}
				}
			}
		}
		if(Integer.parseInt(pid)==0){
			initialiseData();
		}
		if(Integer.parseInt(pid)==2){
			initialiseData();
			results = totalSalesMetricsManager.findAll();
			for (int i=0; i<results.size()-1; i++){
				for (int j=0; j<results.size()-1; j++){
					if(results.get(j).getProductPrice() < results.get(j+1).getProductPrice()){
						swap = results.get(j);
						results.set(j, results.get(j+1));
						results.set(j+1, swap);
					}
				}
			}
		}
		if(Integer.parseInt(pid)==3){
			initialiseData();
			results = totalSalesMetricsManager.findAll();
			for (int i=0; i<results.size()-1; i++){
				for (int j=0; j<results.size()-1; j++){
					if(results.get(j).getTotalSold() < results.get(j+1).getTotalSold()){
						swap = results.get(j);
						results.set(j, results.get(j+1));
						results.set(j+1, swap);
					}
				}
			}
		}

	}
	
}