package com.netbuilder.controller.Dummy;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.netbuilder.entities.CustomerOrderLine;
import com.netbuilder.entitymanagers.CustomerOrderLineManager;
import com.netbuilder.util.DummyData;

/**
 * 
 * @author Jake
 * @author jmander Dummy class for testing the customer order line
 */

@Alternative
public class CustomerOrderLineManagerDummy implements CustomerOrderLineManager {
	@Inject
	DummyData dd;

	public void persistCustomerOrderLine(CustomerOrderLine customerOrderLine) {
		dd.setCustomerOrderLine(customerOrderLine);
	}

	public void persistCustomerOrderLines(
			ArrayList<CustomerOrderLine> customerOrderLines) {
		dd.setCustomerOrderLines(customerOrderLines);
	}

	public ArrayList<CustomerOrderLine> findByCustomerOrderID(
			int customerOrderID) {
		ArrayList<CustomerOrderLine> list = new ArrayList<CustomerOrderLine>();
		for (CustomerOrderLine co : dd.getCustomerOrderLines()) {
			if (co.getCustomerOrderID() == customerOrderID) {
				list.add(co);
			}
		}
		return list;
	}

	public ArrayList<CustomerOrderLine> findByQuantity(int quantity) {
		ArrayList<CustomerOrderLine> list = new ArrayList<CustomerOrderLine>();
		for (CustomerOrderLine co : dd.getCustomerOrderLines()) {
			if (co.getQuantity() == quantity) {
				list.add(co);
			}
		}
		return list;
	}

	public void updateCustomerOrderLine(CustomerOrderLine customerOrderLine) {
		for (int i = 0; i < dd.getCustomerOrderLines().size(); i++) {
			if (customerOrderLine.getCustomerOrderID() == dd
					.getCustomerOrderLines().get(i).getCustomerOrderID()) {
				dd.setCustomerOrderLine(customerOrderLine);
				;
			}
		}
	}

	public ArrayList<CustomerOrderLine> findAll() {
		return dd.getCustomerOrderLines();
	}

	public ArrayList<CustomerOrderLine> finyByProductID(int productID) {
		ArrayList<CustomerOrderLine> list = new ArrayList<CustomerOrderLine>();
		for (CustomerOrderLine co : dd.getCustomerOrderLines()) {
			if (co.getProductId() == productID) {
				list.add(co);
			}
		}
		return list;
	}

}
