package com.netbuilder.BlueGardensEESystem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class SupplierProduct {
/**
 * @author abalagel
 * Attributes for product received from supplier
 * includes supplier unique ID, product unique ID and the purchasing price from supplier
*/
	@Id
	@Column (name = "Supplier ID", nullable = false)
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supplierId;
	
	@Column (name = "Product ID", nullable = false)
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
/**
 * @author abalagel
 * getters and setters for class variables
 *initialise class
*/
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getSupplierId() {
		return supplierId;
	}

}
