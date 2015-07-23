package com.netbuilder.BlueGardensEESystem;

import static org.junit.Assert.*;

import org.junit.Test;

import com.netbuilder.entities.Product;

/**
 * 
 * @author gandrews
 *Checks that product methods are correctly tested
 */
public class ProductTest {

	String testName = "123456Test123456";
	String testNameError = "BreakingBad";
	
	int testStockLevel = 14;
	int testStockLevelError = 15;
	
	int testMinimumLevel = 13;
	int testMinimumLevelError = 26;
	
	int testRecommendedLevel = 15;
	int testRecommendedLevelError = 20;
	
	boolean testPorouswareApplied = false;
	boolean testPorouswareAppliedError = true;
	
	double testCost = 10.00;  
	double testCostError = 15.00;
	
	/**
	 * Added tests for whether a product is in sale along with the features and trending
	 * @author lczornyj
	 */
	
	boolean testSale = false;
	boolean testSaleError = false;
	
	String testFeatureOne = "one";
	String testFeatureOneError = "oneerror";
	
	String testFeatureTwo = "two";
	String testFeatureTwoError = "twoerror";
	
	String testFeatureThree = "three";
	String testFeatureThreeError = "threeerror";
	
	String testFeatureFour = "four";
	String testFeatureFourError = "fourerror";
	
	String testFeatureFive = "five";
	String testFeatureFiveError = "fiveerror";
	
	String testImageLink = "link";
	String testImageLinkError = "linkerror";	
	
	boolean testTrending = false;
	boolean testTrendingError = false;
	
	/**
	 * The test product that will be used for the set of tests
	 */
	//					Desired Values	Name				Stock Level		Minimum Level		Recommended Level		Porousware				Cost
	Product product = new Product(testName,testStockLevel,testMinimumLevel,testRecommendedLevel,testPorouswareApplied,testCost,testSale,testFeatureOne,testFeatureTwo,testFeatureThree, testFeatureFour, testFeatureFive,testImageLink,testTrending);
	Product productError = new Product(testNameError,testStockLevelError,testMinimumLevelError,testRecommendedLevelError,testPorouswareAppliedError,testCostError,testSaleError,testFeatureOneError,testFeatureTwoError,testFeatureThree, testFeatureFourError, testFeatureFiveError,testImageLinkError,testTrendingError);	
	 
	
	/**
	 * Checks that the product can be created 
	 */
	@Test
	public void testProductCreation() {
		Product product = new Product();
		assertNotNull(product);
	}
	
	/**
	 * Tests that products custom constructor assigns the values correctly
	 */
	@Test
	public void testProductCustomCreation()
	{
		assertSame(product.getProductName(),"123456Test123456");
		assertSame(product.getStockLevel(),14);
		assertSame(product.getMinimumThreshold(),13);
		assertSame(product.getRecommendedLevel(), 15);
		assertFalse(product.isPorousware());
		assertEquals(product.getPrice(), 10.00, 0.001); //0.001 is the tolerance
		assertFalse(product.isSale());
		assertSame(product.getFeatureOne(), "one");
		assertSame(product.getFeatureTwo(), "two");
		assertSame(product.getFeatureThree(), "three");
		assertSame(product.getFeatureFour(), "four");
		assertSame(product.getFeatureFive(), "five");
		assertSame(product.getImageLink(), "link");
		assertFalse(product.isTrending());
	}
	
		/**
		 * Tests that the correct name is assigned
		 */
		@Test
		public void testProductNameEqual()
		{
			assertSame(product.getProductName(),"123456Test123456");
		}
		
		/**
		 * Tests that the correct stock level is assigned
		 */
		@Test
		public void testProductStockEqual()
		{
			assertSame(product.getStockLevel(),14);
		}
		
		/**
		 * Tests correct minimum threshold is stored
		 */
		@Test
		public void testProductMinThresholdEqual()
		{
			assertSame(product.getMinimumThreshold(),13);
		}
		
		/**
		 * Test correct recommended level
		 */
		@Test
		public void testProductRecommendedLevelEqual()
		{
			assertSame(product.getRecommendedLevel(), 15);
		}
		
		/**
		 * Test if the product returns the correct value for porousware
		 */
		@Test
		public void testProductPorousEqual()
		{
			assertFalse(product.isPorousware());
		}
		
		/**
		 * Tests that products are assigned the correct cost
		 */
		@Test
		public void testProductCostEqual()
		{
			assertEquals(product.getPrice(), 10.00, 0.001); //0.001 is the tolerance
		}
		
		/**
		 * Test if the product returns the correct value for sale
		 */		
		@Test
		public void testSaleEqual() {
			assertFalse(product.isSale());
		}
		
		/**
		 * Tests that the correct feature1 is assigned
		 */
		@Test
		public void testFeatureOneEqual() {
			assertSame(product.getFeatureOne(), "one");
		}
		
		/**
		 * Tests that the correct feature2 is assigned
		 */
		@Test
		public void testFeatureTwoEqual() {
			assertSame(product.getFeatureTwo(), "two");
		}
		
		/**
		 * Tests that the correct feature3 is assigned
		 */
		@Test
		public void testFeatureThreeEqual() {
			assertSame(product.getFeatureThree(), "three");
		}
		
		/**
		 * Tests that the correct feature4 is assigned
		 */
		@Test
		public void testFeatureFourEqual() {
			assertSame(product.getFeatureFour(), "four");
		}

		/**
		 * Tests that the correct feature5 is assigned
		 */
		@Test
		public void testFeatureFiveEqual() {
			assertSame(product.getFeatureFive(), "five");
		}
		
		/**
		 * Tests that the correct link is assigned
		 */
		@Test
		public void testImageLinkEqual() {
			assertSame(product.getImageLink(), "link");
		}
		
		@Test
		public void testTrendingEqual(){
			assertFalse(product.isTrending());
		}
		
	/**
	 * Checks that the product name is assigned
	 */
	@Test
	public void testProductName()
	{
		assertNotNull(product.getProductName());
	}
	
	/**
	 * Checks that the product ID is assigned
	 */
	@Test
	public void testProductID()
	{
		assertNotNull(product.getProductID());
	}
	
	/**
	 * Checks to see that the product minimum threshold has been assigned and is not left null
	 */
	@Test
	public void testProductMinThreshold()
	{
		assertNotNull(product.getMinimumThreshold());
	}
	
	/**
	 * Checks that the products recommended level is not null
	 */
	@Test
	public void testProductRecommendedLevel()
	{
		assertNotNull(product.getRecommendedLevel());
	}
	
	/**
	 * Checks that the product is correctly assigned if it is coated in porousware or not
	 */
	@Test
	public void testProductPorousware()
	{
		assertNotNull(product.isPorousware());
	}
	
	/**
	 * Checks that the price of the product is correctly assigned
	 */
	@Test
	public void testProductCost()
	{
		assertNotNull(product.getPrice());
	}
	
	/**
	 * Checks that the product is correctly assigned if it is on sale or not
	 */
	@Test
	public void testSale()
	{
		assertNotNull(product.isSale());
	}
	
	/**
	 *  Checks that feature1 is assigned
	 */
	@Test
	public void testFeatureOne()
	{
		assertNotNull(product.getFeatureOne());
	}
	
	/**
	 *  Checks that feature2 is assigned
	 */
	@Test
	public void testFeatureTwo()
	{
		assertNotNull(product.getFeatureTwo());
	}
	
	/**
	 *  Checks that feature3 is assigned
	 */
	@Test
	public void testFeatureThree()
	{
		assertNotNull(product.getFeatureThree());
	}
	
	/**
	 *  Checks that feature4 is assigned
	 */
	@Test
	public void testFeatureFour()
	{
		assertNotNull(product.getFeatureFour());
	}
	
	/**
	 *  Checks that feature5 is assigned
	 */
	@Test
	public void testFeatureFive()
	{
		assertNotNull(product.getFeatureFive());
	}
	
	/**
	 *  Checks that image link is assigned
	 */
	@Test
	public void testImageLink()
	{
		assertNotNull(product.getImageLink());
	}
	
	@Test
	public void testTrending()
	{
		assertNotNull(product.isTrending());
	}
	
	/**
	 * Test that the products name does not exceed the maximum number of characters allowed
	 */
	
	@Test
	public void testProductNameLenghtEqual()
	{
		//Generate a string at max length
		String testString = "";
		for(int i = 0 ;i<45;i++)
		{
			testString += "a";
		}
		product.setProductName(testString);
		
		assertTrue(productError.getProductName().length() <= 45);
	}
	
		/**
		 * Tests that the correct name is assigned
		 */
		@Test
		public void testProductNameNotEqual()
		{
			assertNotSame(productError.getProductName(),"bob");
		}
		
		/**
		 * Tests that the correct stock level is assigned
		 */
		@Test
		public void testProductStockNotEqual()
		{
			assertNotSame(productError.getStockLevel(),266725);
		}
		
		/**
		 * Tests correct minimum threshold is stored
		 */
		@Test
		public void testProductMinThresholdNotEqual()
		{
			assertNotSame(productError.getMinimumThreshold(),115);
		}
		
		/**
		 * Test correct recommended level
		 */
		@Test
		public void testProductRecommendedLevelNotEqual()
		{
			assertNotSame(productError.getRecommendedLevel(), 151);
		}
		
		/**
		 * Test if the product returns the correct value for porousware
		 */
		@Test
		public void testProductPorousNotEqual()
		{
			assertFalse(productError.isPorousware() != true);
		}
		
		/**
		 * Tests that products are assigned the correct cost
		 */
		@Test
		public void testProductCostNotEqual()
		{
			assertNotEquals(productError.getPrice(), 17.00, 0.001); //0.001 is the tolerance
		}

		/**
		 * Test that the products name does not accept values that exceed the maximum number of characters allowed
		 */
		@Test
		public void testProductNameLenghtNotEqual()
		{
			//Generate a string at max length
			String testString = "";
			for(int i = 0 ;i<100;i++)
			{
				testString += "a";
			}
			productError.setProductName(testString);
			
			assertFalse(productError.getProductName().length() <= 45);
		}
		
		/**
		 * Test if the product returns the correct value for sale
		 */
		@Test
		public void testSaleNotEqual()
		{
			assertFalse(productError.isSale() != true);
		}
		
		/**
		 * Tests that the correct feature is assigned
		 */
		@Test
		public void testFeatureOneNotEqual()
		{
			assertNotSame(productError.getFeatureOne(),"bob");
		}
		
		/**
		 * Tests that the correct feature is assigned
		 */
		@Test
		public void testFeatureTwoNotEqual()
		{
			assertNotSame(productError.getFeatureTwo(),"bob");
		}
		
		/**
		 * Tests that the correct feature is assigned
		 */
		@Test
		public void testFeatureThreeNotEqual()
		{
			assertNotSame(productError.getFeatureThree(),"bob");
		}
		
		/**
		 * Tests that the correct feature is assigned
		 */
		@Test
		public void testFeatureFourNotEqual()
		{
			assertNotSame(productError.getFeatureFour(),"bob");
		}
		
		/**
		 * Tests that the correct feature is assigned
		 */
		@Test
		public void testFeatureFiveNotEqual()
		{
			assertNotSame(productError.getFeatureFive(),"bob");
		}
		
		/**
		 * Tests that the correct link is assigned
		 */
		@Test
		public void testLinkNotEqual()
		{
			assertNotSame(productError.getImageLink(),"bob");
		}
		
		@Test
		public void testTrendingNotEqual()
		{
			assertFalse(productError.isTrending() != true);
		}
		
}
