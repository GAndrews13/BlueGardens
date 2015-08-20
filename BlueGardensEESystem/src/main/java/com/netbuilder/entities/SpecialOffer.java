package com.netbuilder.entities;

import java.util.Calendar;
import java.util.Date;

public class SpecialOffer {
	private String specialOfferID;
	private Date startTime;
	private Date endTime;
	private long discountCode;
	
	public String getSpecialOfferID() {
		return specialOfferID;
	}
	public void setSpecialOfferID(String specialOfferID) {
		this.specialOfferID = specialOfferID;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public long getDiscountCode() {
		return discountCode;
	}
	public void setDiscountCode(long discountCode) {
		this.discountCode = discountCode;
	}
	
	
}
