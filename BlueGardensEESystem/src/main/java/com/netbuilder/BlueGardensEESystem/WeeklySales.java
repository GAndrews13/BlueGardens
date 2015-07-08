package com.netbuilder.BlueGardensEESystem;

import java.util.Date;
/**
 * 
 * @author gandrews
 *	Lists the number of a certain product that is sold within a working week
 */
public class WeeklySales {

	private int amountSold;
	private int productID;
	private Date dateSold;
	
	public int getAmountSold() {
		return amountSold;
	}
	public void setAmountSold(int amountSold) {
		this.amountSold = amountSold;
	}
	public Date getDateSold() {
		return dateSold;
	}
	public void setDateSold(Date dateSold) {
		this.dateSold = dateSold;
	}
	public int getProductID() {
		return productID;
	}
	
}
