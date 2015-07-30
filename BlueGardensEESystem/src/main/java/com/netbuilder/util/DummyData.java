package com.netbuilder.util;

import java.util.ArrayList;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.CustomerLogin;
import com.netbuilder.entities.Product;
import com.netbuilder.entities.Wishlist;

@Singleton
@Startup
public class DummyData {

	private Customer customer1;
	private CustomerLogin customerLogin1;
	private Customer customer2;
	private CustomerLogin customerLogin2;
	private Product product1;
	private Product product2;
	private Product product3;
	private Product product4;
	private Product product5;
	private Product product6;
	private Product product7;
	private Product product8;
	private Product product9;
	private ArrayList<Product> wishlist1 = new ArrayList<Product>();
	private ArrayList<Product> wishlist2 = new ArrayList<Product>();
	private ArrayList<Product> products = new ArrayList<Product>();
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<CustomerLogin> customerLogins = new ArrayList<CustomerLogin>();
	private ArrayList<ArrayList<Product>> wishlists = new ArrayList<ArrayList<Product>>();
	
	public DummyData(){
		product1 = new Product("Ketchup", 10, 3, 10, false,
				135.00, false, "that's", "ammmaaaazing", "that", "you", "know",
				"Blue-Gardens/BlueGardensEESystem/src/main/webapp/resources/img/ketchup.jpg", true);
		
		product2 = new Product("Chocolate", 100, 30, 100, false,
				10.00, false, "that's", "ammmaaaazing", "that", "you", "know",
				"Blue-Gardens/BlueGardensEESystem/src/main/webapp/resources/img/chocolate.jpg", true);
		
		product3 = new Product("Kitchen Sink", 70, 50, 180, false,
				85.00, false, "that's", "ammmaaaazing", "that", "you", "know",
				"Blue-Gardens/BlueGardensEESystem/src/main/webapp/resources/img/kitchenSink.jpg", true);
		
		product4 = new Product("Floor", 100, 70, 700, true,
				98.00, false, "that's", "ammmaaaazing", "that", "you", "know",
				"Blue-Gardens/BlueGardensEESystem/src/main/webapp/resources/img/floor.jpg", false);
		
		product5 = new Product("Fish", 120, 60, 140, true,
				35.00, false, "that's", "ammmaaaazing", "that", "you", "know",
				"Blue-Gardens/BlueGardensEESystem/src/main/webapp/resources/img/fish.jpg", false);
		
		product6 = new Product("Plum", 104, 63, 130, true,
				4.99, false, "that's", "ammmaaaazing", "that", "you", "know",
				"Blue-Gardens/BlueGardensEESystem/src/main/webapp/resources/img/plum.png", false);
		
		product7 = new Product("Cheese", 150, 13, 163, false,
				12.00, true, "that's", "ammmaaaazing", "that", "you", "know",
				"Blue-Gardens/BlueGardensEESystem/src/main/webapp/resources/img/cheese.jpg", false);
		
		product8 = new Product("Sofa", 140, 36, 164, false,
				700.00, true, "that's", "ammmaaaazing", "that", "you", "know",
				"Blue-Gardens/BlueGardensEESystem/src/main/webapp/resources/img/sofa.jpg", false);
		
		product9 = new Product("Shower", 120, 34, 150, false,
				15.00, true, "that's", "ammmaaaazing", "that", "you", "know",
				"Blue-Gardens/BlueGardensEESystem/src/main/webapp/resources/img/shower.jpg", false);
		
		products.add(product1);
		products.add(product2);
		products.add(product3);
		products.add(product4);
		products.add(product5);
		products.add(product6);
		products.add(product7);
		products.add(product8);
		products.add(product9);
		
		customer1 = new Customer("Oliver", "Queen", "Queen Mansion, Starling City, OL1 V3R", "999", "ACTIVE");
		customer2 = new Customer("Slade", "Wilson", "Lian Yu, China, L14N YU1", "404", "BLACKLISTED");
		
		customers.add(customer1);
		customers.add(customer2);
		
		customerLogin1 = new CustomerLogin(1, "The Arrow", "th34", LoginUtils.getNextSalt());
		customerLogin2 = new CustomerLogin(2, "Deathstroke", "sh4d0", LoginUtils.getNextSalt());
		
		customerLogins.add(customerLogin1);
		customerLogins.add(customerLogin2);
		
		wishlist1.add(product1);
		wishlist1.add(product4);
		wishlist1.add(product7);

		wishlist2.add(product3);
		wishlist2.add(product8);
		wishlist2.add(product2);
		
		wishlists.add(wishlist1);
		wishlists.add(wishlist2);
		
		
		
	}
	
}
