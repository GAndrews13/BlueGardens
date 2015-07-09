package com.netbuilder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "WarehouseWorker")
@NamedQueries({
@NamedQuery(name = WarehouseWorker.FIND_OUT_BY_NAME, query = "SELECT p FROM WarehouseWorker p WHERE p.workerName = :name"),
@NamedQuery(name = WarehouseWorker.FIND_OUT_BY_ID, query = "SELECT p FROM WarehouseWorker p WHERE p.workerId = :id")
})
public class WarehouseWorker {
	public static final String FIND_OUT_BY_NAME = "WarehouseWorker.findoutbyname";
	public static final String FIND_OUT_BY_ID = "WarehouseWorker.findoutbyid";
/**
 * @author lczornyj
 * Generate warehouse workers attributes and save the variables
 * locally.
 */

	 
	
	@Id
	@Column(name = "workerId", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int workerId;
	@Column(name = "workerName", nullable = false, length = 45)
	@NotNull
	@Size(min = 2, max = 45)
	private String workerName;
	@Column(name = "workerAddress", nullable = false, length = 145)
	@NotNull
	@Size(min = 2, max = 145)
	private String workerAddress;
	
	public WarehouseWorker(){
		
	}
/**
 * @author lczornyj
 * create getters and setters for the variables except the ID
 * as the ID is never set by a person.
 * @return
 */
	public WarehouseWorker(String workerName, String workerAddress){
		this.workerName = workerName;
		this.workerAddress = workerAddress;
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
}
