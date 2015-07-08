package com.netbuilder.BlueGardensEESystem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Supplier")
public class Supplier {
/**
 * @author lczornyj
 *  Create the variables for the supplier
 */
	
	@Id
	@Column(name = "supplierId", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int supplierId;
	
	@Column(name = "supplierName", nullable = false, length = 45)
	@NotNull
	@Size(min = 2, max = 45)
	private String supplierName;
	
	@Column(name = "supplierAddress", nullable = false, length = 45)
	@NotNull
	@Size(min = 2, max = 45)
	private String supplierAddress;
/**
 * @author lczornyj
 * Create getters and setters for the variables except ID as there
 * is no need to set a ID as it will be automatically generated
 * @return
 */
	

	
public Supplier(String supplierName, String supplierAddress) {
	this.supplierName = supplierName;
	this.supplierAddress = supplierAddress;
}
	public String getName() {
		return supplierName;
	}
	public void setName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getAddress() {
		return supplierAddress;
	}
	public void setAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	public int supplierId() {
		return supplierId;
	}
}
