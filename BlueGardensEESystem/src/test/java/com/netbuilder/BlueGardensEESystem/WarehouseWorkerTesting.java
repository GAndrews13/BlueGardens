package com.netbuilder.BlueGardensEESystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.netbuilder.entities.WarehouseWorker;

public class WarehouseWorkerTesting {

	public WarehouseWorkerTesting() {
		// WarehouseWorker warehouseWorker = new WarehouseWorker();
	}

	/**
	 * @author lczornyj I think this is testing if the supplier name is null
	 */
	@Test
	public void testWorkerName() {
		WarehouseWorker testing = new WarehouseWorker();
		testing.setName("a");
		assertEquals("a", testing.getName());
		assertNotNull(testing.getName());
	}

	/**
	 * @author lczornyj I think this one tests if the address is null
	 */
	@Test
	public void testWorkerAddress() {
		WarehouseWorker testing = new WarehouseWorker();
		testing.setAddress("a");
		assertEquals("a", testing.getAddress());
		assertNotNull(testing.getAddress());
	}
}
