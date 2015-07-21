package com.netbuilder.BlueGardensEESystem;

import static org.junit.Assert.*;

import org.junit.Test;

import com.netbuilder.entities.Customer;

/**
 * @author Jake
 *	Testing Customer class using Junit
 *	Currently successful with values test values used to setup this instance of customer
 */
public class CustomerTest 
{	
	@Test public void testCustomer()
	{
		/**
		 * @author Jake
		 *	Unit test for Not Null
		 */
		Customer testing = new Customer(1,"Jake","Thompson", "Home","0123456789","Active");
		assertNotNull(testing.getAccountSTATUS());
	}
}
