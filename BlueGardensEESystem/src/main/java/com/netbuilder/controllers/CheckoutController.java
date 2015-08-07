package com.netbuilder.controllers;

public class CheckoutController {
	private String errormsg;
	
	public String getErrorMessage() { return errormsg; }
	
	public void setErrorMessage(String inErrorMessage) { errormsg = inErrorMessage; }
	
	public void generateProductList() { }
	public void sendToPaypal() { }	
}