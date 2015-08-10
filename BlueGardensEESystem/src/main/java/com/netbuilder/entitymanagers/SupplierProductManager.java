package com.netbuilder.entitymanagers;

import java.util.ArrayList;

import com.netbuilder.entities.SupplierProduct;

/**
 * @author abalagel maps the outline of the db
 */
public interface SupplierProductManager {

	public void persistSupplierProduct(SupplierProduct supplierProduct);

	public void persistSupplierProducts(
			ArrayList<SupplierProduct> supplierProducts);

	public void updateSupplierProduct(SupplierProduct supplierProduct);

	public SupplierProduct findById(int id); // any ID

	public SupplierProduct findByPrice(double price);
}
