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
@Table(name = "PurchaseOrderLine")
@NamedQueries({
		@NamedQuery(name = PurchaseOrderLine.FIND_OUT_BY_PURCHASE_ORDER_ID, query = "SELECT pol FROM PurchaseOrderLine WHERE pol.purchaseOrderID = :poid"),
		@NamedQuery(name = PurchaseOrderLine.FIND_OUT_BY_PRODUCT_ID, query = "SELECT pol FROM PurchaseOrderLine WHERE pol.productID = :pid") })
public class PurchaseOrderLine {

	public static final String FIND_OUT_BY_PURCHASE_ORDER_ID = "PurchaseOrderLine.findbyid";
	public static final String FIND_OUT_BY_PRODUCT_ID = "PurchaseOrderLine.findoutbyid";

	@Id
	@Column(name = "purchaseOrderID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int purchaseOrderID;
	@Id
	@Column(name = "productID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int productID;
	@Column(name = "quantity", nullable = false, length = 30)
	@NotNull
	@Size(min = 2, max = 30)
	private int quantity;

	public int getPurchaseOrderID() {
		return purchaseOrderID;
	}

	public void setPurchaseOrderID(int id) {
		purchaseOrderID = id;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int id) {
		productID = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quan) {
		quantity = quan;
	}
}
