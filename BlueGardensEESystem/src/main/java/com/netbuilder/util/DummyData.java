package com.netbuilder.util;

import java.util.ArrayList;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.CustomerLogin;
import com.netbuilder.entities.Product;
import com.netbuilder.entities.WishlistItems;

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
	
	private ArrayList<WishlistItems> wishlistProducts = new ArrayList<WishlistItems>();
	private WishlistItems wishlist1 = new WishlistItems(1,1);
	private WishlistItems wishlist2 = new WishlistItems(1,4);
	private WishlistItems wishlist3 = new WishlistItems(1,7);
	private WishlistItems wishlist4 = new WishlistItems(2,2);
	private WishlistItems wishlist5 = new WishlistItems(2,4);
	private WishlistItems wishlist6 = new WishlistItems(2,8);
	private ArrayList<Product> products = new ArrayList<Product>();
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<CustomerLogin> customerLogins = new ArrayList<CustomerLogin>();
	
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

	public ArrayList<CustomerLogin> getCustomerLogins() {
		return customerLogins;
	}

	public void setCustomerLogin(CustomerLogin customerLogin) {
		customerLogins.add(customerLogin);
	}
	
	public void setCustomerLogins(ArrayList<CustomerLogin> customerLogins) {
		this.customerLogins = customerLogins;
	}
	
	public void setWishlistItems(WishlistItems wishlistitem){
		wishlistProducts.add(wishlistitem);
	}
	
	public ArrayList<WishlistItems> getWishlistProducts() {
		return wishlistProducts;
	}

	public void setWishlistProducts(ArrayList<WishlistItems> wishlistProducts) {
		this.wishlistProducts.addAll(wishlistProducts);
	}

	public DummyData(){
		product1 = new Product(1, "Ketchup", 10, 3, 10, false,
				135.00, false, "that's", "ammmaaaazing", "that", "you", "know",
				"resources/img/ketchup.jpg", true);
		
		product2 = new Product(2, "Chocolate", 100, 30, 100, false,
				10.00, false, "that's", "ammmaaaazing", "that", "you", "know",
				"resources/img/chocolate.jpg", true);
		
		product3 = new Product(3, "Kitchen Sink", 70, 50, 180, false,
				85.00, false, "that's", "ammmaaaazing", "that", "you", "know",
				"resources/img/kitchenSink.jpg", true);
		
		product4 = new Product(4, "Floor", 100, 70, 700, true,
				98.00, false, "that's", "ammmaaaazing", "that", "you", "know",
				"resources/img/floor.jpg", false);
		
		product5 = new Product(5, "Fish", 120, 60, 140, true,
				35.00, false, "that's", "ammmaaaazing", "that", "you", "know",
				"resources/img/fish.JPG", false);
		
		product6 = new Product(6, "Plum", 104, 63, 130, true,
				4.99, false, "that's", "ammmaaaazing", "that", "you", "know",
				"resources/img/plum.png", false);
		
		product7 = new Product(7, "Cheese", 150, 13, 163, false,
				12.00, true, "that's", "ammmaaaazing", "that", "you", "know",
				"resources/img/cheese.jpg", false);
		
		product8 = new Product(8, "Sofa", 140, 36, 164, false,
				700.00, true, "that's", "ammmaaaazing", "that", "you", "know",
				"resources/img/sofa.jpg", false);
		
		product9 = new Product(9, "Shower", 120, 34, 150, false,
				15.00, true, "that's", "ammmaaaazing", "that", "you", "know",
				"resources/img/shower.jpg", false);
		
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
		
		customerLogin1 = new CustomerLogin(1, "The Arrow", "th34", LoginUtils.getNextSalt());
		customerLogin2 = new CustomerLogin(2, "Deathstroke", "sh4d0", LoginUtils.getNextSalt());
		
		customerLogins.add(customerLogin1);
		customerLogins.add(customerLogin2);
		
		wishlistProducts.add(wishlist1);
		wishlistProducts.add(wishlist2);
		wishlistProducts.add(wishlist3);
		wishlistProducts.add(wishlist4);
		wishlistProducts.add(wishlist5);
		wishlistProducts.add(wishlist6);

	}
	
}
