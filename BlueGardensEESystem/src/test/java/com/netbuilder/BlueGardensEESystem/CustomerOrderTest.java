package com.netbuilder.BlueGardensEESystem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.netbuilder.entities.CustomerOrder;
/**
 * 
 * @author jmander
 * 
 * Unit test for the CustomOrder Class
 *
 **/

public class CustomerOrderTest {
	
	CustomerOrder customerOrder;

	public CustomerOrderTest(){
		customerOrder = new CustomerOrder(true, 01245, "1st Class", null, null, null);
		assertNotNull(customerOrder.getTrackingID());
		
	}
	
	@Test public void testgetCustomerId() {
		assertEquals(customerOrder.getCustomer(), null);
	}	
	
	@Test public void testgetPOLIDS() {
		assertEquals(customerOrder.getProductOrderLines(), null);
	}	
	
	@Test public void testgetWorkerId() {
		assertEquals(customerOrder.getWorker(), null);
	}	
	
}