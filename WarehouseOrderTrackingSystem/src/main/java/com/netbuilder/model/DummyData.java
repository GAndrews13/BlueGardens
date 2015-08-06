package com.netbuilder.model;

import java.util.ArrayList;

public class DummyData {
	

	private Customer customer1;
	private Customer customer2;
	private Product product1;
	private Product product2;
	private Product product3;
	private Product product4;
	private Product product5;
	private Product product6;
	private Product product7;
	private Product product8;
	private Product product9;
		
	private ArrayList<Product> products = new ArrayList<Product>();
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	
	public ArrayList<Product> getProducts() {
		return products;
	}
	
	public void setProduct(Product product) {
		products.add(product);
	}

	public void setProducts(ArrayList<Product> products) {
		this.products.addAll(products);
	}
	
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	
	public void setCustomer(Customer customer) {
		customers.add(customer);
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public DummyData(){
		product1 = new Product(1, "Ketchup", 10, 3, 10, false,
				135.00, false, "that's", "ammmaaaazing", "that", "you", "know",
				"resources/img/ketchup.png", true);
		
		product2 = new Product(2, "Chocolate", 100, 30, 100, false,
				10.00, false, "that's", "ammmaaaazing", "that", "you", "know",
				"resources/img/chocolate.png", true);
		
		product3 = new Product(3, "Notts County Gnome", 70, 50, 180, false,
				85.00, false, "that's", "ammmaaaazing", "that", "you", "know",
				"resources/img/nottsCountyGnome.png", true);
		
		product4 = new Product(4, "Floor", 100, 70, 700, true,
				98.00, false, "that's", "ammmaaaazing", "that", "you", "know",
				"resources/img/floor.png", false);
		
		product5 = new Product(5, "Machine Gun Gnome", 120, 60, 140, true,
				35.00, false, "that's", "ammmaaaazing", "that", "you", "know",
				"resources/img/gnome.png", false);
		
		product6 = new Product(6, "Plum", 104, 63, 130, true,
				4.99, false, "that's", "ammmaaaazing", "that", "you", "know",
				"resources/img/plum.png", false);
		
		product7 = new Product(7, "Cheese", 150, 13, 163, false,
				12.00, true, "that's", "ammmaaaazing", "that", "you", "know",
				"resources/img/cheese.png", false);
		
		product8 = new Product(8, "Sofa", 140, 36, 164, false,
				700.00, true, "that's", "ammmaaaazing", "that", "you", "know",
				"resources/img/sofa.png", false);
		
		product9 = new Product(9, "Jacuzzi", 120, 34, 150, false,
				15.00, true, "that's", "ammmaaaazing", "that", "you", "know",
				"resources/img/jacuzzi.png", false);
		
		products.add(product1);
		products.add(product2);
		products.add(product3);
		products.add(product4);
		products.add(product5);
		products.add(product6);
		products.add(product7);
		products.add(product8);
		products.add(product9);
		
		customer1 = new Customer(1, "Oliver", "Queen", "Queen Mansion, Starling City, OL1 V3R", "999", "badboyqueen@queenconsolidated.com", "ACTIVE");
		customer2 = new Customer(2, "Slade", "Wilson", "Lian Yu, China, L14N YU1", "404", "shado@rip.com", "BLACKLISTED");
		
		customers.add(customer1);
		customers.add(customer2);

	}
	
}
