package com.netbuilder.entitymanagers;

import java.util.ArrayList;
import com.netbuilder.entities.SupplierProduct;

public interface SupplierProductManager {

	public void persistSupplierProduct(SupplierProduct supplierProduct);
	public void persistSupplierProducts(ArrayList<SupplierProduct> supplierProducts);
	
	public void updateSupplierProduct(SupplierProduct supplierProduct);
	
	public SupplierProduct findById(int id);  //any ID
	public SupplierProduct findByPrice(double price);
}
