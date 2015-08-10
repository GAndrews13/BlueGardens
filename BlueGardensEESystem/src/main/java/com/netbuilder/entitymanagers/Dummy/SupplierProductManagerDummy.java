package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;

import com.netbuilder.entities.SupplierProduct;
import com.netbuilder.entitymanagers.SupplierProductManager;

/**
 * @author abalagel links interface with db
 */
@Alternative
public class SupplierProductManagerDummy implements SupplierProductManager {
	ArrayList<SupplierProduct> sp = new ArrayList<SupplierProduct>();

	public void persistSupplierProduct(SupplierProduct supplierProduct) {
		sp.add(supplierProduct);
	};

	public void persistSupplierProducts(
			ArrayList<SupplierProduct> supplierProducts) {
		this.sp.addAll(supplierProducts);
	};

	public void updateSupplierProduct(SupplierProduct supplierProduct) {
		sp.set(sp.indexOf(supplierProduct), supplierProduct);
	};

	public SupplierProduct findById(int id) {
		for (SupplierProduct i : sp) {
			if (i.getProductId() == id)
				return i;
		}
		return null;
	};

	public SupplierProduct findByPrice(double price) {
		for (SupplierProduct i : sp) {
			if (i.getPrice() == price)
				return i;
		}
		return null;
	};
}
