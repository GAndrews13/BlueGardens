package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;

/**
 * @author Jake
 *  Dummy class for testing if the customer entity can be manipulated	
 */
import com.netbuilder.entities.Customer;
import com.netbuilder.entitymanagers.CustomerManager;

@Alternative
public class CustomerManagerDummy implements CustomerManager
{
	/**
	 * @author Jake
	 *	Add new customer into array list
	 */
	ArrayList<Customer> customers = new ArrayList<Customer>();
	public void persistCustomer(Customer customer)
	{
		customers.add(customer);
	}
	
	/**
	 * @author Jake
	 *	Return list of customers from array that have a certain account status
	 */
	public ArrayList<Customer> findByStatus(String status)
	{
		ArrayList<Customer> list = new ArrayList<Customer>();
		for(Customer c : customers)
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
	public void updateCustomer(Customer customer)
	{
		customers.set(customers.indexOf(customer), customer);
	}
	
	/**
	 * @author Jake
	 *	Look in array for customer with a set firstname
	 */
	public Customer findByFirstName(String firstname)
	{
		for(Customer c : customers)
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
		for(Customer c : customers)
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
		for(Customer c : customers)
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
		for(Customer c : customers)
		{
			list.add(c);
		}
		return null;
	}
}
