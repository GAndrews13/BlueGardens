package com.netbuilder.BlueGardensEESystem;

import static org.junit.Assert.*;

import org.junit.Test;

public class SupplierTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

		 
	@Test public void testSupplier(String id, String name){
	Supplier testing = new Supplier(id, name);
	assertNull(testing.getName());
	}
	
	@Test public void testSupplierName(){
		Supplier testing = new Supplier();
		assertNotNull(testing.getName());
	}
	@Test public void testSupplierAddress(){
		Supplier testing = new Supplier();
		assertNull(testing.getAddress());
	}
	@Test public void testSupplierGetName(){
		Supplier testing = new Supplier();
		assertEquals("a", testing.getName());

}
