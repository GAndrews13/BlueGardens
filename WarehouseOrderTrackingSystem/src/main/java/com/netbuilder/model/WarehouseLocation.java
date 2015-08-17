package com.netbuilder.model;


/**
 * @author abalagel
 */

public class WarehouseLocation {
	public static final String FIND_OUT_BY_PRODUCTID = "WarehouseLocation.findoutbyproductid";


	private int productId;


	private String locationId;


	private int quantity;

	public WarehouseLocation(int productId, String locationId, int quantity) {
		this.productId = productId;
		this.locationId = locationId;
		this.quantity = quantity;
	}

	public void setProductId(int id) {
		this.productId = id;
	}

	public int getProductId() {
		return productId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
