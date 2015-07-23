package com.netbuilder.BlueGardensEESystem;

public enum DeliveryStatus {

	DELIVERED ("Delivered"),
	DISPATCHED ("Dispatched"),
	PROCESSED ("Processed"),
	ORDER_PLACED ("Order Placed");
	
	private String status;
	
	private DeliveryStatus(String s)
	{
		 status = s;
	}
	
	public String toString()
	{
		return status;
	}
	
	
}
