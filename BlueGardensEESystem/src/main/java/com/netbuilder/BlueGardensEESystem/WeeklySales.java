package com.netbuilder.BlueGardensEESystem;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
/**
 * 
 * @author gandrews
 *	Lists the number of a certain product that is sold within a working week
 */

@Entity
@Table (name = "WeeklySales")
public class WeeklySales {

	/**
	 * Create a default instance in which the date of the products sales are provided
	 * @param inDate This is the date at which the sales of the product are going to be tracked from for the duration of a week
	 */
	public WeeklySales(Date inDate)
	{
		this.dateSold = inDate;
	}
	
	/**
	 * Creates an instance of weekly sales using the time it was created as its Date
	 */
	public WeeklySales()
	{
		this(Calendar.getInstance().getTime());
	}
	
	@Column (name = "amountSold",nullable = true)
	private int amountSold;
	
	@Column (name = "productID",nullable = false)
	@NotNull
	@ManyToOne
	@JoinColumn(name="productID")
	private int productID;
	
	@Column (name = "dateSold",nullable = false)
	@NotNull
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
	
	@Override
	public String toString()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd.hhmmss");
		return sdf.format(dateSold) + ": " + amountSold;
	}
	
}
