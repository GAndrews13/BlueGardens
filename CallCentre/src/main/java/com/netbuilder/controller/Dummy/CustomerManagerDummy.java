package com.netbuilder.controller.Dummy;

import java.util.ArrayList;



import javax.enterprise.inject.Alternative;


/**
 * @author Jake
 *  Dummy class for testing if the customer entity can be manipulated	
 */
import com.netbuilder.model.Customer;
import com.netbuilder.controller.CustomerManager;
import com.netbuilder.model.Utility.DummyData;
import com.netbuilder.service.DummyDataLoader;

/**
 * @author jmander and Jake and abalagel
 * **/
@Alternative
public class CustomerManagerDummy implements CustomerManager {
	/**
	 * @author Jake Add new customer into array list
	 */

	DummyData dd = new DummyData();

	public void persistCustomer(Customer customer) {
		DummyDataLoader.dd().setCustomer(customer);
	}

	public void persistCustomers(ArrayList<Customer> customers) {
		DummyDataLoader.dd().setCustomers(customers);
	}

	/**
	 * @author Jake Return list of customers from array that have a certain
	 *         account status
	 */
	public ArrayList<Customer> findByStatus(String status) {
		ArrayList<Customer> list = new ArrayList<Customer>();
		for (Customer c : DummyDataLoader.dd().getCustomers()) {
			if (c.getAccountSTATUS().equals(status))
				list.add(c);
		}
		return list;
	}

	/**
	 * @author Jake Lookup set customer and update their details with new
	 *         information
	 */
	public void updateCustomer(Customer customer) {
		for (int i = 0; i < DummyDataLoader.dd().getCustomers().size(); i++) {
			if (customer.getCustomerID() == DummyDataLoader.dd().getCustomers().get(i)
					.getCustomerID()) {
				DummyDataLoader.dd().setCustomer(customer);
			}
		}
	}

	/**
	 * @author Jake Look in array for customer with a set firstname
	 */
	public Customer findByFirstName(String firstname) {
		for (Customer c : DummyDataLoader.dd().getCustomers()) {
			if (c.getFirstName() == firstname) {
				return c;
			}
		}
		return null;
	}

	/**
	 * @author Jake Look in array for customer with a set lastname
	 */
	public Customer findByLastName(String lastname) {
		for (Customer c : DummyDataLoader.dd().getCustomers()) {
			if (c.getFirstName() == lastname) {
				return c;
			}
		}
		return null;
	}

	/**
	 * @author Jake Find a customer using the email attribute
	 */
	public Customer findByEmail(String email) {
		for (Customer c : DummyDataLoader.dd().getCustomers()) {
			if (c.getEmail() == email) {
				return c;
			}
		}
		return null;
	}

	/**
	 * @author Jake Find a customer using the email attribute
	 */
	public ArrayList<Customer> findAll() {
		return DummyDataLoader.dd().getCustomers();
	}

	/**
	 * @author GAndrews
	 */
	@Override
	public Customer findByID(long inID) {
		for (Customer c : DummyDataLoader.dd().getCustomers()) {
			if (c.getCustomerID() == inID) {
				return c;
			}
		}
		return null;
	}
}
