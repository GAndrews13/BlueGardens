package com.netbuilder.BlueGardensEESystem;

public class WarehouseWorker {
/**
 * @author lczornyj
 * Generate warehouse workers attributes and save the variables
 * locally.
 */
	private int workerId;
	private String name;
	private String address;
/**
 * @author lczornyj
 * create getters and setters for the variables except the ID
 * as the ID is never set by a person.
 * @return
 */
	public WarehouseWorker(String name, String address){
		this.name = name;
		this.address = address;
	}
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
