package com.netbuilder.BlueGardensEESystem;
import org.junit.*;
import com.netbuilder.entities.CustomerOrder;;
/**
 * 
 * @author jmander
 * 
 * Unit test for the CustomOrder Class
 *
 **/

public class CustomerOrderTest {

	public CustomerOrderTest(){
		customerOrder = new CustomerOrder(true, 01245, "1st Class");
		assertNotNull(testing.getTrackingID());
	}
	
	@Test public void testgetCustomerId() {
		assertEquals(customer.getProductId(), 1);
	}	
	
	@Test public void testgetPOLID() {
		assertEquals(ProductOrderLine.getProductId(), 1);
	}	
	
	@Test public void testgetWorkerId() {
		assertEquals(WarehouseWorker.getProductId(), 1);
	}	
	
}