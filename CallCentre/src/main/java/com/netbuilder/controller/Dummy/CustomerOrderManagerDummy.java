package com.netbuilder.controller.Dummy;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;

import com.netbuilder.model.DeliveryStatus;
import com.netbuilder.model.CustomerOrder;
import com.netbuilder.controller.CustomerOrderManager;
import com.netbuilder.model.Utility.DummyData;
import com.netbuilder.service.DummyDataLoader;

/** 
 * @author jmander 
 * Customer Order Manager with dummy data *
 **/
@Alternative
public class CustomerOrderManagerDummy implements CustomerOrderManager {

	DummyData dd = new DummyData();

	public void persistCustomerOrder(CustomerOrder customerOrder) {
		DummyDataLoader.dd().setCustomerOrder(customerOrder);
		;
	}

	public void persistCustomerOrders(ArrayList<CustomerOrder> customerOrders) {
		DummyDataLoader.dd().setCustomerOrders(customerOrders);
	}

	public void updateCustomerOrder(CustomerOrder customerOrder) {
		for (int i = 0; i < DummyDataLoader.dd().getCustomerOrders().size(); i++) {
			if (customerOrder.getCustomerOrderID() == DummyDataLoader.dd().getCustomerOrders()
					.get(i).getCustomerOrderID()) {
				DummyDataLoader.dd().setCustomerOrder(customerOrder);
			}
		}
	}

	public CustomerOrder findByCustomerOrderId(int customerOrderId) {
		for (CustomerOrder co : DummyDataLoader.dd().getCustomerOrders()) {
			if (co.getCustomerOrderID() == customerOrderId) {
				return co;
			}
		}
		return null;
	}

	public ArrayList<CustomerOrder> findByisAssigned(boolean isAssigned) {
		ArrayList<CustomerOrder> list = new ArrayList<CustomerOrder>();
		for (CustomerOrder co : DummyDataLoader.dd().getCustomerOrders()) {
			if (co.getIsAssigned() == isAssigned) {
				list.add(co);
			}
		}
		return list;
	}

	public CustomerOrder findByTrackingId(int trackingId) {
		for (CustomerOrder co : DummyDataLoader.dd().getCustomerOrders()) {
			if (co.getTrackingID() == trackingId) {
				return co;
			}
		}
		return null;
	}

	public ArrayList<CustomerOrder> findByDeliveryType(String deliveryType) {
		ArrayList<CustomerOrder> list = new ArrayList<CustomerOrder>();
		for (CustomerOrder co : DummyDataLoader.dd().getCustomerOrders()) {
			if (co.getDeliveryType() == deliveryType) {
				list.add(co);
			}
		}
		return list;
	}

	public ArrayList<CustomerOrder> findByCustomer(long customerID) {
		ArrayList<CustomerOrder> list = new ArrayList<CustomerOrder>();
		for (CustomerOrder co : DummyDataLoader.dd().getCustomerOrders()) {
			if (co.getCustomer() == customerID) {
				list.add(co);
			}
		}
		return list;
	}

	public ArrayList<CustomerOrder> findByWorker(long workerID) {
		ArrayList<CustomerOrder> list = new ArrayList<CustomerOrder>();
		for (CustomerOrder co : DummyDataLoader.dd().getCustomerOrders()) {
			if (co.getWorker() == workerID) {
				list.add(co);
			}
		}
		return list;
	}

	public ArrayList<CustomerOrder> findByDeliveryStatus(DeliveryStatus status) {
		ArrayList<CustomerOrder> list = new ArrayList<CustomerOrder>();
		for (CustomerOrder co : DummyDataLoader.dd().getCustomerOrders()) {
			if (co.getStatus() == status) {
				list.add(co);
			}
		}
		return list;
	}

	@Override
	public ArrayList<CustomerOrder> findAll() {
		return DummyDataLoader.dd().getCustomerOrders();
	}

}