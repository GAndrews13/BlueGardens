package com.netbuilder.BlueGardensEESystem;

import java.io.Serializable;
import java.util.ArrayList;

import javax.inject.Inject;

import com.netbuilder.entities.CustomerOrder;
import com.netbuilder.entities.CustomerOrderLine;
import com.netbuilder.entities.Product;
import com.netbuilder.entities.WarehouseLocation;
import com.netbuilder.entities.WarehouseWorker;
import com.netbuilder.entitymanagers.CustomerOrderLineManager;
import com.netbuilder.entitymanagers.CustomerOrderManager;
import com.netbuilder.entitymanagers.ProductManager;
import com.netbuilder.entitymanagers.WarehouseLocationManager;
import com.netbuilder.entitymanagers.WarehouseWorkerManager;
import com.netbuilder.entitymanagers.Dummy.ProductManagerDummy;
import com.netbuilder.entitymanagers.Dummy.WarehouseLocationManagerDummy;

public class WarehouseOperation implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2116270683372912345L;
	@Inject
	private WarehouseWorkerManager warehouseWorkerManager;
	@Inject
	private CustomerOrderManager customerOrderManager;
	@Inject
	private CustomerOrderLineManager customerOrderLineManager;
	@Inject
	private WarehouseLocationManager warehouseLocationManager;
	WarehouseLocationManager wlm = new WarehouseLocationManagerDummy();
	ArrayList<CustomerOrder> openOrders;
	ArrayList<CustomerOrder> assignedOrders;
	boolean pickingSequenced;

	public WarehouseOperation()
	{
		openOrders = customerOrderManager.findByDeliveryStatus(DeliveryStatus.ORDER_PLACED);	
		assignedOrders = customerOrderManager.findByDeliveryStatus(DeliveryStatus.PROCESSING);
	}

	/*
	 * @author David Ogbonnah
	 * @param id the workers id number
	 * @return the id number of the customer order assigned to the worker
	 * 
	 * Assigns a worker to a new order. Returns an id allowing the picking order can be calculated
	 */
	
	public String loginWorker(int id, String password)
	{
		WarehouseWorker worker = warehouseWorkerManager.findById(id);
		if (worker.equals(null))
		{
			return "Worker does not exist";
		}
		else if(!worker.getPassword().equals(password))
		{
			return "Password for worker incorrect";
		}
		else if(worker.getPassword().equals(password))
		{
			worker.setLoggedIn(true);
			warehouseWorkerManager.updateWarehouseWorker(worker);
			return "Worker " + worker.getName() + " is logged in";
		}
		return null;
	}
	
	public String logoutWorker(int id)
	{
		WarehouseWorker worker = warehouseWorkerManager.findById(id);
		if(worker.isLoggedIn())
		{
			worker.setLoggedIn(false);
			warehouseWorkerManager.updateWarehouseWorker(worker);
			return "Worker " + worker.getName() + " is logged out";
		}
		return null;
	}
	
	
	public int assignWorkerToOrder(int id)
	{
		WarehouseWorker worker = warehouseWorkerManager.findById(id);
		CustomerOrder order = openOrders.get(1);
		worker.setAssigned(true);
		order.setIsAssigned(true);
		order.setWorker(worker);
		order.setStatus(DeliveryStatus.PROCESSING);
		return order.getCustomerOrderID();
	}
	
	public void setPickingSequence(int coid)
	{
		ArrayList<CustomerOrderLine> currentOrderLines = customerOrderLineManager.findByCustomerOrderID(coid);
		ArrayList<CustomerOrderLine> pickingSequence = new ArrayList<CustomerOrderLine>();
		ArrayList<String> ssectionA = new ArrayList<String>();
		ArrayList<CustomerOrderLine> sectionA = new ArrayList<CustomerOrderLine>();
		ArrayList<String> ssectionB = new ArrayList<String>();
		ArrayList<CustomerOrderLine> sectionB = new ArrayList<CustomerOrderLine>();
		ArrayList<String> ssectionC = new ArrayList<String>();
		ArrayList<CustomerOrderLine> sectionC = new ArrayList<CustomerOrderLine>();
		ArrayList<String> ssectionD = new ArrayList<String>();
		ArrayList<CustomerOrderLine> sectionD = new ArrayList<CustomerOrderLine>();
		ArrayList<String> ssectionE = new ArrayList<String>();
		ArrayList<CustomerOrderLine> sectionE = new ArrayList<CustomerOrderLine>();
		ArrayList<String> ssectionF = new ArrayList<String>();
		ArrayList<CustomerOrderLine> sectionF = new ArrayList<CustomerOrderLine>();
		ArrayList<String> ssectionG = new ArrayList<String>();
		ArrayList<CustomerOrderLine> sectionG = new ArrayList<CustomerOrderLine>();
		ArrayList<String> ssectionH = new ArrayList<String>();
		ArrayList<CustomerOrderLine> sectionH = new ArrayList<CustomerOrderLine>();
		ArrayList<String> ssectionI = new ArrayList<String>();
		ArrayList<CustomerOrderLine> sectionI = new ArrayList<CustomerOrderLine>();

		for (CustomerOrderLine col : currentOrderLines) {
			int productID = col.getProductId();
			ArrayList<WarehouseLocation> thisIDLocations = wlm
					.findByProductID(productID);
			WarehouseLocation selected = thisIDLocations.get(1);
			String locID = selected.getLocationId();

			findRowInSection("A", ssectionA, sectionA, locID, col);
			findRowInSection("B", ssectionB, sectionB, locID, col);
			findRowInSection("C", ssectionC, sectionC, locID, col);
			findRowInSection("D", ssectionD, sectionD, locID, col);
			findRowInSection("E", ssectionE, sectionE, locID, col);
			findRowInSection("F", ssectionF, sectionF, locID, col);
			findRowInSection("G", ssectionG, sectionG, locID, col);
			findRowInSection("H", ssectionH, sectionH, locID, col);
			findRowInSection("I", ssectionI, sectionI, locID, col);
		}
		
		orderCols(sectionA, pickingSequence);
		orderCols(sectionB, pickingSequence);
		orderCols(sectionC, pickingSequence);
		orderCols(sectionD, pickingSequence);
		orderCols(sectionE, pickingSequence);
		orderCols(sectionF, pickingSequence);
		orderCols(sectionG, pickingSequence);
		orderCols(sectionH, pickingSequence);
		orderCols(sectionI, pickingSequence);
		
		pickingSequenced = true;

	}

	public String showNextProduct(int coid)
	{
		ArrayList<CustomerOrderLine> currentOrderLines = customerOrderLineManager.findByCustomerOrderID(coid);
		int i = 0;
		while(i<currentOrderLines.size())
		{
			CustomerOrderLine col = currentOrderLines.get(i);
			if(!col.getIsPicked())
			{
				int id = col.getProductId();
				ProductManager pm = new ProductManagerDummy();
				Product product = pm.findById(id);
				return product.getProductName();
			}
			i++;
		}
		return null;
	}

	public void findRowInSection(String sec, ArrayList<String> locIDs,
			ArrayList<CustomerOrderLine> cols, String tempLocID,
			CustomerOrderLine col) {
		if (tempLocID.startsWith(sec)) {
			String[] s = tempLocID.split(sec);
			int row = Integer.parseInt(s[1]);
			if (locIDs.size() == 0) {
				locIDs.add(tempLocID);
				cols.add(col);
			} else {
				for (int i = 0; i < locIDs.size(); i++) {
					String[] tempS = locIDs.get(i).split(sec);
					int tempRow = Integer.parseInt(tempS[1]);
					if (row > tempRow) {
						locIDs.add(i, tempLocID);
						cols.add(i, col);
					}
				}
			}
		}
	}

	public void orderCols(ArrayList<CustomerOrderLine> colsBySection,
			ArrayList<CustomerOrderLine> allCols) {
		for (CustomerOrderLine col : colsBySection) {
			allCols.add(col);
		}
	}
	
	public void completeOrder(int id)
	{
		WarehouseWorker worker = warehouseWorkerManager.findById(id);
		CustomerOrder order = openOrders.get(1);
		worker.setAssigned(false);
		order.setIsAssigned(false);
		order.setWorker(worker);
		order.setStatus(DeliveryStatus.READY);
		pickingSequenced = false;
	} 
}
