package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;


/**
 * @author Jake
 *  Dummy class for testing if the customer entity can be manipulated	
 */
import com.netbuilder.entities.Customer;
import com.netbuilder.entitymanagers.CustomerManager;
import com.netbuilder.util.DummyData;

/**
 * @author jmander and Jake and abalagel
 * **/

@Alternative
public class CustomerManagerDummy implements CustomerManager
{
	/**
	 * @author Jake
	 *	Add new customer into array list
	 */
	
	@Inject
	private DummyData dd;
	
	public void persistCustomer(Customer customer) {
		dd.setCustomer(customer);
	}

	public void persistCustomers(ArrayList<Customer> customers) {
		dd.setCustomers(customers);
	}
	
	
	/**
	 * @author Jake
	 *	Return list of customers from array that have a certain account status
	 */
	public ArrayList<Customer> findByStatus(String status)
	{
		ArrayList<Customer> list = new ArrayList<Customer>();
		for(Customer c : dd.getCustomers())
		{
			if (c.getAccountSTATUS().equals(status))
				list.add(c);
		}
			return list;
	}
	
	/**
	 * @author Jake
	 *	Lookup set customer and update their details with new information 
	 */
	public void updateCustomer(Customer customer){
		for(int i=0; i<dd.getCustomers().size(); i++){
			if(customer.getCustomerID() == dd.getCustomers().get(i).getCustomerID()){
				dd.setCustomer(customer);
			}
		}
	}
	
	/**
	 * @author Jake
	 *	Look in array for customer with a set firstname
	 */
	public Customer findByFirstName(String firstname)
	{
		for(Customer c : dd.getCustomers())
		{
			if(c.getFirstName() == firstname)
			{
				return c;
			}
		}
		return null;
	}
	
	/**
	 * @author Jake
	 *	Look in array for customer with a set lastname
	 */
	public Customer findByLastName(String lastname)
	{
		for(Customer c : dd.getCustomers())
		{
			if(c.getFirstName() == lastname)
			{
				return c;
			}
		}
		return null;
	}
	
	/**
	 * @author Jake
	 *	Find a customer using the email attribute
	 */
	public Customer findByEmail(String email)
	{
		for(Customer c : dd.getCustomers())
		{
			if(c.getEmail() == email)
			{
				return c;
			}
		}
		return null;
	}
	
	/**
	 * @author Jake
	 *	Find a customer using the email attribute
	 */
	public ArrayList <Customer> findAll()
	{
		ArrayList <Customer> list = new ArrayList<Customer>();
		for(Customer c : dd.getCustomers())
		{
			list.add(c);
		}
		return null;
	}

	/**
	 * @author GAndrews
	 */
	@Override
	public Customer findByID(long inID) {
		for(Customer c: dd.getCustomers())
		{
			if(c.getCustomerID() ==inID)
			{
				return c;
			}
		}
		return null;
	}
}
