package com.netbuilder.BlueGardensEESystem;

public class WarehouseWorker {
/**
 * Generate warehouse workers attributes and save the variables
 * locally.
 */
	private int workerId;
	private String name;
	private String address;
/**
 * create getters and setters for the variables except the ID
 * as the ID is never set by a person.
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
	public int getWorkerId() {
		return workerId;
	}
}
