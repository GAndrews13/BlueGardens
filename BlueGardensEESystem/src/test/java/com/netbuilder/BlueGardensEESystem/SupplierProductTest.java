package com.netbuilder.BlueGardensEESystem;

import static org.junit.Assert.*;

import org.junit.Test;

import com.netbuilder.entities.SupplierProduct;

public class SupplierProductTest {
	SupplierProduct supplierProduct;
		
	public SupplierProductTest() {
		supplierProduct = new SupplierProduct(1, 1, 1.5);
		assertNotNull(supplierProduct);
	}
	
	@Test public void testgetProductId() {
		assertEquals(supplierProduct.getProductId(), 1);
	}	
	
	@Test public void testgetSupplierId() {
		assertEquals(supplierProduct.getSupplierId(), 1);
	}
	
	@Test public void testgetPrice() {
		assertEquals(supplierProduct.getPrice(), 1.5, 0);
	}
}
