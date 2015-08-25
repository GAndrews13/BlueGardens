package com.netbuilder.controller.Dummy;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;

import com.netbuilder.model.CustomerOrderLine;
import com.netbuilder.controller.CustomerOrderLineManager;
import com.netbuilder.model.Utility.DummyData;
import com.netbuilder.service.DummyDataLoader;

/**
 * 
 * @author Jake
 * @author jmander Dummy class for testing the customer order line
 */

@Alternative
public class CustomerOrderLineManagerDummy implements CustomerOrderLineManager {

	DummyData dd = new DummyData();
	
	/**
	 * persist the current customer order line
	 */
	public void persistCustomerOrderLine(CustomerOrderLine customerOrderLine) {
		DummyDataLoader.dd().setCustomerOrderLine(customerOrderLine);
	}

	/**
	 * persist all customer order lines
	 */
	public void persistCustomerOrderLines(
			ArrayList<CustomerOrderLine> customerOrderLines) {
		DummyDataLoader.dd().setCustomerOrderLines(customerOrderLines);
	}

	/**
	 * Return arrayList of customer order lines that contains the customer order ID
	 */
	public ArrayList<CustomerOrderLine> findByCustomerOrderID(
			int customerOrderID) {
		ArrayList<CustomerOrderLine> list = new ArrayList<CustomerOrderLine>();
		for (CustomerOrderLine co : DummyDataLoader.dd().getCustomerOrderLines()) {
			if (co.getCustomerOrderID() == customerOrderID) {
				list.add(co);
			}
		}
		return list;
	}

	/**
	 * Return arrayList of customer order lines that contain a given quantity
	 */
	public ArrayList<CustomerOrderLine> findByQuantity(int quantity) {
		ArrayList<CustomerOrderLine> list = new ArrayList<CustomerOrderLine>();
		for (CustomerOrderLine co : DummyDataLoader.dd().getCustomerOrderLines()) {
			if (co.getQuantity() == quantity) {
				list.add(co);
			}
		}
		return list;
	}
	
	/**
	 * Update a customer order line that is passed in with one that is being persisted 
	 */
	public void updateCustomerOrderLine(CustomerOrderLine customerOrderLine) {
		for (int i = 0; i < DummyDataLoader.dd().getCustomerOrderLines().size(); i++) {
			if (customerOrderLine.getCustomerOrderID() == dd
					.getCustomerOrderLines().get(i).getCustomerOrderID()) {
				DummyDataLoader.dd().setCustomerOrderLine(customerOrderLine);
				;
			}
		}
	}

	/**
	 * Return all customer order lines
	 */
	public ArrayList<CustomerOrderLine> findAll() {
		return DummyDataLoader.dd().getCustomerOrderLines();
	}
	
	/**
	 * Return all customer order lines that contain a certain product
	 */
	public ArrayList<CustomerOrderLine> finyByProductID(int productID) {
		ArrayList<CustomerOrderLine> list = new ArrayList<CustomerOrderLine>();
		for (CustomerOrderLine co : DummyDataLoader.dd().getCustomerOrderLines()) {
			if (co.getProductId() == productID) {
				list.add(co);
			}
		}
		return list;
	}

}
