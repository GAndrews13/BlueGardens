package com.netbuilder.util;

import java.util.ArrayList;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import com.netbuilder.BlueGardensEESystem.DeliveryStatus;
import com.netbuilder.entities.Customer;
import com.netbuilder.entities.CustomerLogin;
import com.netbuilder.entities.CustomerOrder;
import com.netbuilder.entities.CustomerOrderLine;
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
	private Product product10;
	private WishlistItems wishlist1 = new WishlistItems(1, 1);
	private WishlistItems wishlist2 = new WishlistItems(1, 4);
	private WishlistItems wishlist3 = new WishlistItems(1, 7);
	private WishlistItems wishlist4 = new WishlistItems(2, 2);
	private WishlistItems wishlist5 = new WishlistItems(2, 4);
	private WishlistItems wishlist6 = new WishlistItems(2, 8);
	private CustomerOrder customerOrder1;
	private CustomerOrder customerOrder2;
	private CustomerOrder customerOrder3;
	private CustomerOrder customerOrder4;
	private CustomerOrderLine customerOrderLine1;
	private CustomerOrderLine customerOrderLine2;
	private CustomerOrderLine customerOrderLine3;
	private CustomerOrderLine customerOrderLine4;
	private CustomerOrderLine customerOrderLine5;
	private CustomerOrderLine customerOrderLine6;
	private CustomerOrderLine customerOrderLine7;
	private CustomerOrderLine customerOrderLine8;
	private ArrayList<WishlistItems> wishlistProducts = new ArrayList<WishlistItems>();
	private ArrayList<CustomerOrderLine> customerOrderLines = new ArrayList<CustomerOrderLine>();
	private ArrayList<CustomerOrder> customerOrders = new ArrayList<CustomerOrder>();
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

	public ArrayList<CustomerOrderLine> getCustomerOrderLines() {
		return customerOrderLines;
	}

	public void setCustomerOrderLine(CustomerOrderLine customerOrderLine) {
		customerOrderLines.add(customerOrderLine);
	}

	public void setCustomerOrderLines(
			ArrayList<CustomerOrderLine> customerOrderLines) {
		this.customerOrderLines.addAll(customerOrderLines);
	}

	public ArrayList<CustomerOrder> getCustomerOrders() {
		return customerOrders;
	}

	public void setCustomerOrder(CustomerOrder customerOrder) {
		customerOrders.add(customerOrder);
	}

	public void setCustomerOrders(ArrayList<CustomerOrder> customerOrders) {
		this.customerOrders.addAll(customerOrders);
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

	public void setCustomerLogin(CustomerLogin customerLogin) {
		customerLogins.add(customerLogin);
	}

	public ArrayList<CustomerLogin> getCustomerLogins() {
		return customerLogins;
	}

	public void setCustomerLogins(ArrayList<CustomerLogin> customerLogins) {
		this.customerLogins.addAll(customerLogins);
	}

	public void setWishlistItems(WishlistItems wishlistitem) {
		wishlistProducts.add(wishlistitem);
	}

	public ArrayList<WishlistItems> getWishlistProducts() {
		return wishlistProducts;
	}

	public void setWishlistProducts(ArrayList<WishlistItems> wishlistProducts) {
		this.wishlistProducts.addAll(wishlistProducts);
	}

	public DummyData() {
		product1 = new Product(1, "Gnomes On Swing", 10, 3, 10, true, 134.99,
				false, "height: 30 cm", "material: polyresin", "frost proof and weather resistant", "porousware", "handcrafted",
				"resources/img/gnomesswing.png", false);

		product2 = new Product(2, "Mini Garden", 100, 30, 100, false, 19.99,
				false, "height: 55 cm", "diameter: 30 cm ", "made to order", "handcrafted", "weight: 7.5 kg",
				"resources/img/minigarden.png", true);

		product3 = new Product(3, "Arsenal Gnome", 70, 50, 180, true,
				84.99, false, "height: 60 cm", "material: clay", "Arsenal Approved", "porousware", "water resistant",
				"resources/img/nottsCountyGnome.png", false);

		product4 = new Product(4, "Deck", 100, 70, 700, false, 14.99, true,
				"£15.00 per metre squared", "material: mahogany", "size: custom ", "water resistant", "non-slip",
				"resources/img/floor.png", false);

		product5 = new Product(5, "Machine Gun Gnome", 120, 60, 140, true,
				54.99, false, "height: 37.5 cm", "angry face gnome", "'Say Hello to my little friend!'", "porousware", "handcrafted",
				"resources/img/gnome.png", false);

		product6 = new Product(6, "Garden Fountain", 104, 63, 130, false, 4499.99, false,
				"suitable for outdoors", "material: granite", "size: 2 m", "diameter: 5 m ", "supplied with a pump, liner and hoses",
				"resources/img/fountain.png", true);

		product7 = new Product(7, "Garden Lights", 150, 13, 163, false, 119.99,
				true, "height: 55 cm ", "diameter: 30 cm", "solar powered", "color: custom", "plants included",
				"resources/img/lights.png", false);

		product8 = new Product(8, "Garden Bench", 140, 36, 164, false, 199.99,
				true, "height: 1 m", "width: 2 m", "material: chestnut", "water resistant", "hand crafted by local carpenters",
				"resources/img/bench.png", false);

		product9 = new Product(9, "Jacuzzi", 120, 34, 150, false, 24999.99, false,
				"24 carat gold plated", "20 water jets", "in-build heating", "glass holders", "customisable seating",
				"resources/img/jacuzzi.png", true);

		product10 = new Product(10, "Heater", 230, 25, 300, true, 31.99, true,
				"material: Tungston steel", "size: 75 cm", "color: metalic black", "rustic design", "suitable for outdoors", 
				"resources/img/heater.png",
				true);

		products.add(product1);
		products.add(product2);
		products.add(product3);
		products.add(product4);
		products.add(product5);
		products.add(product6);
		products.add(product7);
		products.add(product8);
		products.add(product9);
		products.add(product10);

		customer1 = new Customer(1, "Oliver", "Queen",
				"Arrow Cave, Underground, Verdant, The Glades, OL1 V3R", "999",
				"badboyqueen@queenconsolidated.com", "ACTIVE");
		customer2 = new Customer(2, "Slade", "Wilson",
				"Lian Yu, China, L14N YU1", "404", "shado@rip.com",
				"BLACKLISTED");

		customers.add(customer1);
		customers.add(customer2);

		customerLogin1 = new CustomerLogin(1, "The Arrow", "th34",
				LoginUtils.getNextSalt());
		customerLogin2 = new CustomerLogin(2, "Deathstroke", "sh4d0",
				LoginUtils.getNextSalt());

		customerLogins.add(customerLogin1);
		customerLogins.add(customerLogin2);

		customerOrderLine1 = new CustomerOrderLine(1, 1, 23, true);
		customerOrderLine2 = new CustomerOrderLine(1, 10, 1, true);
		customerOrderLine3 = new CustomerOrderLine(2, 7, 12, true);
		customerOrderLine4 = new CustomerOrderLine(2, 8, 4, true);
		customerOrderLine5 = new CustomerOrderLine(2, 6, 2, true);
		customerOrderLine6 = new CustomerOrderLine(3, 4, 3, false);
		customerOrderLine7 = new CustomerOrderLine(3, 6, 7, true);
		customerOrderLine8 = new CustomerOrderLine(4, 9, 1, false);
		// new CustomerOrderLine(customerOrderID, productId, quantity, isPicked)

		customerOrder1 = new CustomerOrder(1, true, 1, "1st Class", 1, 1,
				DeliveryStatus.DELIVERED, (3105 +31.49));
		customerOrder2 = new CustomerOrder(2, true, 2, "1st Class", 1, 2,
				DeliveryStatus.DISPATCHED, (1440 + 2800 + 999.98));
		customerOrder3 = new CustomerOrder(3, true, 3, "Standard Delivery", 2,
				1, DeliveryStatus.PROCESSING, (45 + 3499.93));
		customerOrder4 = new CustomerOrder(4, false, 4, "1st Class", 1, 0,
				DeliveryStatus.ORDER_PLACED, (25000));
		// new CustomerOrder(customerOrderID, isAssigned, trackingID,
		// deliveryType, customerID, workerID, status)

		wishlistProducts.add(wishlist1);
		wishlistProducts.add(wishlist2);
		wishlistProducts.add(wishlist3);
		wishlistProducts.add(wishlist4);
		wishlistProducts.add(wishlist5);
		wishlistProducts.add(wishlist6);

		customerOrders.add(customerOrder1);
		customerOrders.add(customerOrder2);
		customerOrders.add(customerOrder3);
		customerOrders.add(customerOrder4);

		customerOrderLines.add(customerOrderLine1);
		customerOrderLines.add(customerOrderLine2);
		customerOrderLines.add(customerOrderLine3);
		customerOrderLines.add(customerOrderLine4);
		customerOrderLines.add(customerOrderLine5);
		customerOrderLines.add(customerOrderLine6);
		customerOrderLines.add(customerOrderLine7);
		customerOrderLines.add(customerOrderLine8);

	}

}
