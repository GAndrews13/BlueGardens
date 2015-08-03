package com.netbuilder.BlueGardensEESystem;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.netbuilder.entities.WarehouseLocation;
/**
 * Created the tests for the WarehouseLocation class.
 * @author lczornyj
 *
 */

public class WarehouseLocationTesting {
	
	@Test
	public void testProductID(){
	
		WarehouseLocation testing = new WarehouseLocation(1, 1, 1);
		assertNotNull(testing.getProductId());
	}
	
	@Test
	public void testLocationID(){
	
		WarehouseLocation testing = new WarehouseLocation(1, 1, 1);
		assertNotNull(testing.getLocationId());
	}
	
}
