package com.netbuilder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author abalagel
 */

@Entity
@Table(name = "WarehouseLocation")
@NamedQueries({ @NamedQuery(name = WarehouseLocation.FIND_OUT_BY_PRODUCTID, query = "SELECT w FROM WarehouseLocation WHERE w.productId = :id") })
public class WarehouseLocation {
	public static final String FIND_OUT_BY_PRODUCTID = "WarehouseLocation.findoutbyproductid";

	@Id
	@Column(name = "productId", nullable = false)
	@NotNull
	private int productId;

	@Id
	@Column(name = "locationId", nullable = false)
	@NotNull
	private String locationId;

	@Column(name = "quantity", nullable = false)
	@NotNull
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
