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
		customerOrder = new CustomerOrder(1, true, 1, "1st Class", 1, 1, DeliveryStatus.DELIVERED);
		assertNotNull(customerOrder.getTrackingID());
		
	}
	
	@Test public void testgetCustomerId() {
		assertEquals(customerOrder.getCustomer(), null);
	}	

	
	@Test public void testgetWorkerId() {
		assertEquals(customerOrder.getWorker(), null);
	}	
	
	}