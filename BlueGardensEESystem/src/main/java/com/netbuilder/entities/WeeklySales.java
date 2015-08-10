package com.netbuilder.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author gandrews Lists the number of a certain product that is sold within a
 *         working week
 */

@NamedQueries({ @NamedQuery(name = WeeklySales.FIND_LOW_SELLERS, query = "SELECT v FROM WeeklySales v WHERE v.amountSold <= 30") })
@Entity
@Table(name = "WeeklySales")
public class WeeklySales {

	public static final String FIND_LOW_SELLERS = "WeeklySales.findLowSellers";

	/**
	 * Create a default instance in which the date of the products sales are
	 * provided
	 * 
	 * @param inDate
	 *            This is the date at which the sales of the product are going
	 *            to be tracked from for the duration of a week
	 */
	public WeeklySales(Date inDate) {
		this.dateSold = inDate;
	}

	/**
	 * Creates an instance of weekly sales using the time it was created as its
	 * Date
	 */
	public WeeklySales() {
		this(Calendar.getInstance().getTime());
	}

	@Column(name = "amountSold", nullable = true)
	private int amountSold;

	@Column(name = "productID", nullable = false)
	@NotNull
	@ManyToOne
	@JoinColumn(name = "productID")
	private int productID;

	@Column(name = "dateSold", nullable = false)
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

	/**
	 * Returns the date that represents the start of the week and the number
	 * that have been sold within that week
	 */
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd.hhmmss");
		return sdf.format(dateSold) + ": " + amountSold;
	}

}
