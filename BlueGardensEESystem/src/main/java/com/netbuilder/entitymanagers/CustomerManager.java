package com.netbuilder.entitymanagers;
/**
 * @author Jake
 *	Entity Manager for the Customer entity
 *	
 */

import java.util.ArrayList;

import com.netbuilder.entities.Customer;

public interface CustomerManager 
{
	/**
	 * @author Jake
	 *	Create a customer
	 */
	public void persistCustomer(Customer customer);
	
	/**
	 * @author Jake
	 *	Find customers already in the array by account status
	 */
	public ArrayList<Customer> findByStatus(String status);
	
	/**
	 * @author Jake
	 *	Edit details of a particular customer 
	 */
	public void updateCustomer(Customer customer);
	
	/**
	 * @author Jake
	 *	Find a customer using the name attribute
	 */
	public Customer findByName(String name);
	
	/**
	 * @author Jake
	 *	Find a customer using the email attribute
	 */
	public Customer findByEmail(String email);
}
