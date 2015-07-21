package com.netbuilder.BlueGardensEESystem;

import static org.junit.Assert.*;

import org.junit.Test;

import com.netbuilder.entities.CustomerOrderLine;

/**
 * @author Jake
 *	Testing ProductOrderLine class using Junit
 *	Currently successful with values test values used to setup this instance of the Product Order Line
 */
public class ProductOrderLineTest 
{
	@Test public void ProductOrderLineTesting()
	{
		/**
		 * @author Jake
		 *	Testing if the quantity in Ptest is NotNull
		 */
		CustomerOrderLine Ptest = new CustomerOrderLine(1,1,12);
		assertNotNull(Ptest.getQuantity());
	}
}
