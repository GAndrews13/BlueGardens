package com.netbuilder.model;

public class WarehouseWorker {
	public static final String FIND_OUT_BY_NAME = "WarehouseWorker.findoutbyname";
	public static final String FIND_OUT_BY_ID = "WarehouseWorker.findoutbyid";
	public static final String IS_ASSIGNED = "WarehouseWorker.isassigned";
	/**
	 * @author lczornyj Generate warehouse workers attributes and save the
	 *         variables locally.
	 */
	private int workerId;
	private String workerAddress;
	private boolean isAssigned;
	private String workerName;

	public WarehouseWorker() {

	}

	/**
	 * @author lczornyj create getters and setters for the variables except the
	 *         ID as the ID is never set by a person.
	 * @param
	 * @return
	 */
	public WarehouseWorker(String workerName, String workerAddress,
			boolean isAssigned) {
		this.workerName = workerName;
		this.workerAddress = workerAddress;
		this.isAssigned = isAssigned;
	}

	public String getName() {
		return workerName;
	}

	public void setName(String workerName) {
		this.workerName = workerName;
	}

	public String getAddress() {
		return workerAddress;
	}

	public void setAddress(String workerAddress) {
		this.workerAddress = workerAddress;
	}

	public int getWorkerId() {
		return workerId;
	}

	public boolean isAssigned() {
		return isAssigned;
	}

	public void setAssigned(boolean isAssigned) {
		this.isAssigned = isAssigned;
	}
}
