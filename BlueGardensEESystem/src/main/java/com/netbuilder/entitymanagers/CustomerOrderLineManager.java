package com.netbuilder.entitymanagers;

/**
 * @author Jake
 * @author jmander
 *	
 */
import java.util.ArrayList;

import com.netbuilder.entities.CustomerOrderLine;

public interface CustomerOrderLineManager {

	public void persistCustomerOrderLine(CustomerOrderLine customerOrderLine);

	public void persistCustomerOrderLines(
			ArrayList<CustomerOrderLine> customerOrderLines);

	public ArrayList<CustomerOrderLine> findByCustomerOrderID(
			int customerOrderID);

	public ArrayList<CustomerOrderLine> finyByProductID(int productID);

	public ArrayList<CustomerOrderLine> findByQuantity(int quantity);

	public void updateCustomerOrderLine(CustomerOrderLine customerOrderLine);

	public ArrayList<CustomerOrderLine> findAll();

}
