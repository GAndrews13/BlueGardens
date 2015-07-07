package com.netbuilder.BlueGardensEESystem;

public class Supplier {
/**
 *  Create the variables for the supplier
 */
	private int supplierId;
	private String name;
	private String address;
/**
 * Create getters and setters for the variables except ID as there
 * is no need to set a ID as it will be automatically generated
 * @return
 */
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int supplierId() {
		return supplierId;
	}
}
