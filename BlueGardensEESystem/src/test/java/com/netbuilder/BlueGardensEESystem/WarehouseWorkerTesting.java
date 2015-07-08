package com.netbuilder.BlueGardensEESystem;
import static org.junit.Assert.*;

import org.junit.Test;
public class WarehouseWorkerTesting {
	
	public WarehouseWorkerTesting(){
	//	WarehouseWorker warehouseWorker = new WarehouseWorker();
	}

	/**
	 * @author lczornyj
	 * I think this is testing if the supplier name is null
	 */
	@Test 
	public void testWorkerName(){
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
	public void testWorkerAddress(){
		Supplier testing = new Supplier();
		testing.setAddress("a");
		assertEquals("a",testing.getAddress());
		assertNotNull(testing.getAddress());
	}
}
