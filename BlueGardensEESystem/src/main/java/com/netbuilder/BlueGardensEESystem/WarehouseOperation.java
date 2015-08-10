package com.netbuilder.BlueGardensEESystem;

import java.io.Serializable;
import java.util.ArrayList;

import com.netbuilder.entities.CustomerOrder;
import com.netbuilder.entities.CustomerOrderLine;
import com.netbuilder.entities.WarehouseLocation;
import com.netbuilder.entities.WarehouseWorker;
import com.netbuilder.entitymanagers.CustomerOrderLineManager;
import com.netbuilder.entitymanagers.CustomerOrderManager;
import com.netbuilder.entitymanagers.WarehouseLocationManager;
import com.netbuilder.entitymanagers.WarehouseWorkerManager;
import com.netbuilder.entitymanagers.Dummy.CustomerOrderLineManagerDummy;
import com.netbuilder.entitymanagers.Dummy.CustomerOrderManagerDummy;
import com.netbuilder.entitymanagers.Dummy.WarehouseLocationManagerDummy;
import com.netbuilder.entitymanagers.Dummy.WarehouseWorkerManagerDummy;

public class WarehouseOperation implements Serializable
{
	WarehouseWorkerManager wwm = new WarehouseWorkerManagerDummy();
	CustomerOrderManager com = new CustomerOrderManagerDummy();
	CustomerOrderLineManager colm = new CustomerOrderLineManagerDummy();
	WarehouseLocationManager wlm = new WarehouseLocationManagerDummy();
	ArrayList<CustomerOrder> openOrders;
	ArrayList<CustomerOrder> assignedOrders;
	
	public WarehouseOperation()
	{
		openOrders = com.findByDeliveryStatus(DeliveryStatus.ORDER_PLACED);	
		assignedOrders = com.findByDeliveryStatus(DeliveryStatus.PROCESSING);
	}
	
	public void assignWorkerToOrder(int id)
	{
		WarehouseWorker worker = wwm.findById(id);
		CustomerOrder order = openOrders.get(1);
		worker.setAssigned(true);
		order.setIsAssigned(true);
		order.setWorker(worker);
		order.setStatus(DeliveryStatus.PROCESSING);
	}
	
	public void completeOrder(int id)
	{
		WarehouseWorker worker = wwm.findById(id);
		CustomerOrder order = openOrders.get(1);
		worker.setAssigned(false);
		order.setIsAssigned(false);
		order.setWorker(worker);
		order.setStatus(DeliveryStatus.READY);
	} 
	
	
	
	public ArrayList<CustomerOrderLine> setPickingOrder(int coid)
	{
		ArrayList<CustomerOrderLine> currentOrderLines = colm.findByCustomerOrderID(coid);
		ArrayList<CustomerOrderLine> pickingOrder = new ArrayList<CustomerOrderLine>();
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
		
		for(CustomerOrderLine col : currentOrderLines)
		{
			int productID = col.getProductId();
			ArrayList<WarehouseLocation> thisIDLocations = wlm.findByProductID(productID);
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
		
		orderCols(sectionA, pickingOrder);
		orderCols(sectionB, pickingOrder);
		orderCols(sectionC, pickingOrder);
		orderCols(sectionD, pickingOrder);
		orderCols(sectionE, pickingOrder);
		orderCols(sectionF, pickingOrder);
		orderCols(sectionG, pickingOrder);
		orderCols(sectionH, pickingOrder);
		orderCols(sectionI, pickingOrder);
		
		return pickingOrder;
	}
	
	public void showNextProduct(int coid)
	{
		ArrayList<CustomerOrderLine> currentOrderLines = colm.findByCustomerOrderID(coid);
		
	}
	
	public void findRowInSection(String sec, ArrayList<String> locIDs, 
			ArrayList<CustomerOrderLine> cols, String tempLocID, CustomerOrderLine col)
	{
		if(tempLocID.startsWith(sec))
		{
			String[] s = tempLocID.split(sec);
			int row = Integer.parseInt(s[1]); 
			if(locIDs.size() == 0)
			{
				locIDs.add(tempLocID);
				cols.add(col);
			}
			else
			{
				for(int i = 0; i < locIDs.size(); i++)
				{
					String[] tempS = locIDs.get(i).split(sec);
					int tempRow = Integer.parseInt(tempS[1]); 						
					if(row > tempRow)
					{
						locIDs.add(i, tempLocID);
						cols.add(i, col);
					}
				}
			}
		}
	}
	
	public void orderCols(ArrayList<CustomerOrderLine> colsBySection,
			ArrayList<CustomerOrderLine> allCols)
	{
		for(CustomerOrderLine col : colsBySection)
		{
			allCols.add(col);
		}
	}
}
