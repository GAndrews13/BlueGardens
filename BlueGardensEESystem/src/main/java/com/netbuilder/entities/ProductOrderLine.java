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

/**
 * @author Jake
 * Product Order Line entity
 */
@Entity
@Table(name = "Product Order Line")
@NamedQueries
({
	@NamedQuery(name = ProductOrderLine.FIND_BY_POL_ID, query = "SELECT c FROM ProductOrderLine c"),
	@NamedQuery(name = ProductOrderLine.FIND_BY_CUSTOMER_ID, query = "SELECT c FROM ProductOrderLine c WHERE CUSTOMER ID = 1")
})
public class ProductOrderLine 
{	
	public static final String FIND_BY_POL_ID = "ProductOrderLine.findByPOLID";
	public static final String FIND_BY_CUSTOMER_ID = "ProductOrderLine.findByCID";
	 
	@Id
	@Column(name = "POLID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int productOrderLineID;
	
	@Column(name = "Product", nullable = false)
	@NotNull
	private Product product;
	
	@Column(name = "Quantity", nullable = false)
	@NotNull
	private int quantity;
	
	public ProductOrderLine( Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public int getProductOrderLineID() { return productOrderLineID; }
	public Product getProduct() { return product; }
	public int getQuantity() { return quantity; }
	
	public void setProductOrderLineID(int productOrderLineID) { this.productOrderLineID = productOrderLineID; }
	public void setProductID(Product product) { this.product = product; }
	public void setQuantity(int quantity) { this.quantity = quantity; }
	
	public double getTotal() {
		double total =quantity*product.getPrice() ;
		return total;
	}
}