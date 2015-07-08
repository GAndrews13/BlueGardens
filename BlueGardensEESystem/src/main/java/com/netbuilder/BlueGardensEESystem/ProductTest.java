package com.netbuilder.BlueGardensEESystem;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author gandrews
 *Checks that product methods are correctly tested
 */
public class ProductTest {

	/**
	 * Checks that the product can be created 
	 */
	@Test
	public void testProductCreation() {
		Products product = new Products();
		assertNotNull(product);
	}
	
	/**
	 * Tests that products custom constructor assigns the values correctly
	 */
	@Test
	public boolean testProductCustomCreation()
	{
		Products product = new Products("TestName",14,13,15,false,10.00);
		if(product.getProductName()!="TestName")
		{
			return false;
		}
		if(product.getStockLevel() != 14)
		{
			return false;
		}
		if(product.getMinimumThreshold() != 13)
		{
			return false;
		}
		if(product.getRecommendedLevel() != 15)
		{
			return false;
		}
		if(product.isPorousware() != false)
		{
			return false;
		}
		if(product.getPrice() != 10.00)
		{
			return false;
		}
		return true;
	}
	
	/**
	 * Checks that the product name is assigned
	 */
	@Test
	public void testProductName()
	{
		Products product = new Products();
		assertNotNull(product.getProductName());
	}
	
	/**
	 * Checks that the product ID is assigned
	 */
	@Test
	public void testProductID()
	{
		Products product = new Products();
		assertNotNull(product.getProductID());
	}
	
	/**
	 * Checks to see that the product minimum threshold has been assigned and is not left null
	 */
	@Test
	public void testProductMinThreshold()
	{
		Products product = new Products();
		assertNotNull(product.getMinimumThreshold());
	}
	
	/**
	 * Checks that the products recommended level is not null
	 */
	@Test
	public void testProductRecommendedLevel()
	{
		Products product = new Products();
		assertNotNull(product.getRecommendedLevel());
	}
	
	/**
	 * Checks that the product is correctly assigned if it is coated in porousware or not
	 */
	@Test
	public void testProductPorousware()
	{
		Products product = new Products();
		assertNotNull(product.isPorousware());
	}
	
	/**
	 * Checks that the price of the product is correctly assigned
	 */
	@Test
	public void testProductCost()
	{
		Products product = new Products();
		assertNotNull(product.getPrice());
	}
}
