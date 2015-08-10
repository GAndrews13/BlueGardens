package com.netbuilder.util;

import javax.faces.bean.SessionScoped;
import javax.inject.Singleton;

@SessionScoped
@Singleton
public class SelectedProduct {
	private int ProductID;

	public int getProductID() { return ProductID; }

	public void setProductID(int productID) { ProductID = productID; }
}