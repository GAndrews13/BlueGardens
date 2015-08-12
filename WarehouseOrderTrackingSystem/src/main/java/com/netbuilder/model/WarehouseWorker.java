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

	private String workerName;

	private String workerAddress;

	private boolean isAssigned;

	private boolean isLoggedIn;

	private String password;

	public WarehouseWorker() {

	}

	/**
	 * @author lczornyj create getters and setters for the variables except the
	 *         ID as the ID is never set by a person.
	 * @param
	 * @return
	 */

	public WarehouseWorker(String workerName, String workerAddress,
			boolean isAssigned, boolean isLoggedIn, String password) {
		super();
		this.workerName = workerName;
		this.workerAddress = workerAddress;
		this.isAssigned = isAssigned;
		this.isLoggedIn = isLoggedIn;
		this.password = password;
	}
	
	public WarehouseWorker(int workerId, String workerName,
			String workerAddress, boolean isAssigned, boolean isLoggedIn,
			String password) {
		super();
		this.workerId = workerId;
		this.workerName = workerName;
		this.workerAddress = workerAddress;
		this.isAssigned = isAssigned;
		this.isLoggedIn = isLoggedIn;
		this.password = password;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
