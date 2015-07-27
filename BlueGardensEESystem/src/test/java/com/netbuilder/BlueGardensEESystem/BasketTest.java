package com.netbuilder.BlueGardensEESystem;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.netbuilder.entities.Basket;
import com.netbuilder.entities.ProductOrderLine;

/**
 * @author abalagel
 */
public class BasketTest {
	Basket b;
	ArrayList<ProductOrderLine> ol = new ArrayList<ProductOrderLine>();
		
	public BasketTest() {
		
		ol.add(new ProductOrderLine(1, 1, 1));
		b= new Basket(1,ol);
		assertNotNull(b);
	}
	
	@Test public void testgetCustomerId() {
		assertEquals(b.getCustomerId(),1);
	}
	
	@Test public void testgetProductOrderLine() {
		assertEquals(b.getProductOrderLine(),ol);
	}
}