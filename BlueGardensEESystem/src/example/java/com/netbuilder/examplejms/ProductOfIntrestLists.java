package com.netbuilder.examplejms;
import java.io.Serializable;
import java.util.ArrayList;

import com.netbuilder.entities.Product;


public class ProductOfIntrestLists implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3677387888461989010L;
	private ArrayList<Product> sale;
	private ArrayList<Product> pourous;
	private ArrayList<Product> trending;
	
	public ProductOfIntrestLists(ArrayList<Product> sale, ArrayList<Product> pourous, ArrayList<Product> trending) {
		this.sale = sale;
		this.pourous = pourous;
		this.trending = trending;
	}
	
	public ArrayList<Product> getSale() {
		return sale;
	}
	public void setSale(ArrayList<Product> sale) {
		this.sale = sale;
	}
	public ArrayList<Product> getPourous() {
		return pourous;
	}
	public void setPourous(ArrayList<Product> pourous) {
		this.pourous = pourous;
	}
	public ArrayList<Product> getTrending() {
		return trending;
	}
	public void setTrending(ArrayList<Product> trending) {
		this.trending = trending;
	}

	@Override
	public String toString() {
		return "ProductOfIntrestLists [sale=" + sale.toString() + ", pourous=" + pourous.toString()
				+ ", trending=" + trending.toString() + "]";
	}
}