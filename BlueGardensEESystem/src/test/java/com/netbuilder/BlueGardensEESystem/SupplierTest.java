package com.netbuilder.BlueGardensEESystem;
/**
 * @author lczornyj
 * Attempting to do some testing for the supplier
 * havent got a clue what im doing, just hashing it together
 */
import static org.junit.Assert.*;

import org.junit.Test;

import com.netbuilder.entities.Supplier;

public class SupplierTest {
	
	public SupplierTest(){	
		//Supplier supplier = new Supplier();
		//supplier.getName();
	}
	/**
	 * @author lczornyj
	 * I think this is testing if the supplier name is null
	 */
	@Test  
	public void testSupplierName(){
		Supplier testing = new Supplier();
		testing.setName("a");
		assertEquals("a", testing.getName());
		assertNotNull(testing.getName());
	}
	/**
	 * @author lczornyj
	 * I think this one tests if the address is null
	 */
	@Test 
	public void testSupplierGetAddress(){
		Supplier testing = new Supplier();
		testing.setAddress("a");
		assertEquals("a",testing.getAddress());
		assertNotNull(testing.getAddress());
	}
}
