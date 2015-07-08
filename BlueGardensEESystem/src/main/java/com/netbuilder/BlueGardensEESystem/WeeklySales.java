package com.netbuilder.BlueGardensEESystem;

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

	//Create a default instance in which the date of the products sales are provided
	public WeeklySales(Date inDate)
	{
		this.dateSold = inDate;
	}
	
	//Creates a weekly sale based on todays date and time
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
	
}
