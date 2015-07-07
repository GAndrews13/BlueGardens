package com.netbuilder.BlueGardensEESystem;

import static org.junit.Assert.*;

import org.junit.Test;

public class SupplierTest {

	@Test public void testSupplierName(){
		Supplier testing = new Supplier();
		assertNotNull(testing.getName());
	}
	@Test public void testSupplierGetName(){
		Supplier testing = new Supplier();
		assertEquals("a", testing.getName());
	}
	@Test public void testSupplierSetName(){
		Supplier testing = new Supplier();
		testing.setName("a");
		assertEquals("a",testing.getName());
	}
}
