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
@Table(name = "Supplier")
@NamedQueries({
	@NamedQuery(name = Supplier.FIND_OUT_BY_NAME, query = "SELECT p FROM Supplier p WHERE p.supplierName = :name"),
	@NamedQuery(name = Supplier.FIND_OUT_BY_ID, query = "SELECT p FROM Supplier p WHERE p.supplierId = :id"),
})
public class Supplier {
	public static final String FIND_OUT_BY_NAME = "Supplier.findoutbyname";
	public static final String FIND_OUT_BY_ID = "Supplier.findoutbyid";
	
	@Id
	@Column(name = "supplierId", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int supplierId;
	
	@Column(name = "supplierName", nullable = false, length = 45)
	@NotNull
	@Size(min = 2, max = 45)
	private String supplierName;
	
	@Column(name = "supplierAddress", nullable = false, length = 145)
	@NotNull
	@Size(min = 2, max = 145)
	private String supplierAddress;

	/**
	 * @author lczornyj
	 * Create getters and setters for the variables except ID as there
	 * is no need to set a ID as it will be automatically generated
	 * @return
	 **/
	public Supplier() { }

	public Supplier(String supplierName, String supplierAddress) {
		this.supplierName = supplierName;
		this.supplierAddress = supplierAddress;
	}

	public String getName() { return supplierName; }
	public String getAddress() { return supplierAddress; }
	public int getSupplierId() { return supplierId; }
	
	public void setName(String supplierName) { this.supplierName = supplierName; }
	public void setAddress(String supplierAddress) { this.supplierAddress = supplierAddress; }
}