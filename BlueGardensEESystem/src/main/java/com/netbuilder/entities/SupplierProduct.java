package com.netbuilder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
@NamedQueries({
	@NamedQuery( name = SupplierProduct.FIND_OUT_BY_PRODUCTID, query = "SELECT p FROM SupplierProduct WHERE p.productId =1"),
	@NamedQuery( name = SupplierProduct.FIND_OUT_BY_PRICE, query = "SELECT p FROM SupplierProduct WHERE p.Price =1.5")
})
public class SupplierProduct {
	public static final String FIND_OUT_BY_PRODUCTID = "SupplierProduct.findByProductId";
	public static final String FIND_OUT_BY_PRICE = "SupplierProduct.findbyPrice";

	@Id
	@Column (name = "Supplier ID", nullable = false)
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supplierId;
	
	@JoinColumn (name = "Product ID", nullable = false)
	@NotNull
	private int productId;
	
	@Column (name = "Price", nullable = false)
	@NotNull
	private double price;
	
	public SupplierProduct(int supplierId, int productId, double price) {		
		this.supplierId = supplierId;
		this.productId = productId;
		this.price = price;
	}
	
	public int getProductId() { return productId; }
	public double getPrice() { return price; }
	public int getSupplierId() { return supplierId; }
	public void setProductId(int productId) { this.productId = productId; }
	public void setPrice(double price) { this.price = price; }
}