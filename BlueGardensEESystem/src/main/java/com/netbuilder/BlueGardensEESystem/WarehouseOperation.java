package com.netbuilder.BlueGardensEESystem;

import java.util.ArrayList;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.CustomerOrder;
import com.netbuilder.entities.CustomerOrderLine;
import com.netbuilder.entities.Product;
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

public class WarehouseOperation 
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
		ArrayList<CustomerOrderLine> currentOrderLines = colm.findByCOID(coid);
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
			
			if(locID.startsWith("A"))
			{
				String[] s = locID.split("A");
				int row = Integer.parseInt(s[1]); 
				if(sectionA.size() == 0)
				{
					ssectionA.add(locID);
					sectionA.add(col);
				}
				else
				{
					for(int i = 0; i < ssectionA.size(); i++)
					{
						String[] tempS = ssectionA.get(i).split("A");
						int tempRow = Integer.parseInt(tempS[1]); 						
						if(row > tempRow)
						{
							ssectionA.add(i, locID);
							sectionA.add(i, col);
						}
					}
				}
			}
			else if(locID.startsWith("B"))
			{		
				String[] s = locID.split("B");
				int row = Integer.parseInt(s[1]); 
				if(ssectionB.size() == 0)
				{
					ssectionB.add(locID);
					sectionB.add(col);
				}
				else
				{
					for(int i = 0; i < ssectionB.size(); i++)
					{
						String[] tempS = ssectionB.get(i).split("B");
						int tempRow = Integer.parseInt(tempS[1]); 						
						if(row > tempRow)
						{
							ssectionB.add(i, locID);
							sectionB.add(i, col);
						}
					}
				}
			}
			if(locID.startsWith("C"))
			{	
				String[] s = locID.split("C");
				int row = Integer.parseInt(s[1]); 
				if(ssectionC.size() == 0)
				{
					ssectionC.add(locID);
					sectionC.add(col);
				}
				else
				{
					for(int i = 0; i < sectionC.size(); i++)
					{
						String[] tempS = ssectionC.get(i).split("C");
						int tempRow = Integer.parseInt(tempS[1]); 						
						if(row > tempRow)
						{
							ssectionC.add(i, locID);
							sectionC.add(i, col);
						}
					}
				}
			}
			if(locID.startsWith("D"))
			{
				String[] s = locID.split("D");
				int row = Integer.parseInt(s[1]); 
				if(ssectionD.size() == 0)
				{
					ssectionD.add(locID);
					sectionD.add(col);
				}
				else
				{
					for(int i = 0; i < ssectionD.size(); i++)
					{
						String[] tempS = ssectionD.get(i).split("D");
						int tempRow = Integer.parseInt(tempS[1]); 						
						if(row > tempRow)
						{
							ssectionD.add(i, locID);
							sectionD.add(i, col);
						}
					}
				}
			}
			if(locID.startsWith("E"))
			{
				String[] s = locID.split("E");
				int row = Integer.parseInt(s[1]); 
				if(ssectionE.size() == 0)
				{
					ssectionE.add(locID);
					sectionE.add(col);
				}
				else
				{
					for(int i = 0; i < ssectionE.size(); i++)
					{
						String[] tempS = ssectionE.get(i).split("E");
						int tempRow = Integer.parseInt(tempS[1]); 						
						if(row > tempRow)
						{
							ssectionE.add(i, locID);
							sectionE.add(i, col);
						}
					}
				}
			}
			if(locID.startsWith("F"))
			{
				String[] s = locID.split("F");
				int row = Integer.parseInt(s[1]); 
				if(ssectionF.size() == 0)
				{
					ssectionF.add(locID);
					sectionF.add(col);
				}
				else
				{
					for(int i = 0; i < ssectionF.size(); i++)
					{
						String[] tempS = ssectionF.get(i).split("F");
						int tempRow = Integer.parseInt(tempS[1]); 						
						if(row > tempRow)
						{
							ssectionF.add(i, locID);
							sectionF.add(i, col);
						}
					}
				}
			}
			if(locID.startsWith("G"))
			{
				String[] s = locID.split("G");
				int row = Integer.parseInt(s[1]); 
				if(ssectionG.size() == 0)
				{
					ssectionG.add(locID);
					sectionG.add(col);
				}
				else
				{
					for(int i = 0; i < ssectionG.size(); i++)
					{
						String[] tempS = ssectionG.get(i).split("G");
						int tempRow = Integer.parseInt(tempS[1]); 						
						if(row > tempRow)
						{
							ssectionG.add(i, locID);
							sectionG.add(i, col);
						}
					}
				}
			}
			if(locID.startsWith("H"))
			{	
				String[] s = locID.split("H");
				int row = Integer.parseInt(s[1]); 
				if(sectionH.size() == 0)
				{
					ssectionH.add(locID);
					sectionH.add(col);
				}
				else
				{
					for(int i = 0; i < ssectionH.size(); i++)
					{
						String[] tempS = ssectionH.get(i).split("H");
						int tempRow = Integer.parseInt(tempS[1]); 						
						if(row > tempRow)
						{
							ssectionH.add(i, locID);
							sectionH.add(i, col);
						}
					}
				}
			}
			if(locID.startsWith("I"))
			{
				String[] s = locID.split("I");
				int row = Integer.parseInt(s[1]); 
				if(sectionI.size() == 0)
				{
					ssectionI.add(locID);
					sectionI.add(col);
				}
				else
				{
					for(int i = 0; i < ssectionI.size(); i++)
					{
						String[] tempS = ssectionI.get(i).split("I");
						int tempRow = Integer.parseInt(tempS[1]); 						
						if(row > tempRow)
						{
							ssectionI.add(i, locID);
							sectionI.add(i, col);
						}
					}
				}
			}
		}
		
		for(CustomerOrderLine col : sectionA)
		{
			pickingOrder.add(col);
		}
		for(CustomerOrderLine col : sectionB)
		{
			pickingOrder.add(col);
		}
		for(CustomerOrderLine col : sectionC)
		{
			pickingOrder.add(col);
		}
		for(CustomerOrderLine col : sectionD)
		{
			pickingOrder.add(col);
		}
		for(CustomerOrderLine col : sectionE)
		{
			pickingOrder.add(col);
		}
		for(CustomerOrderLine col : sectionF)
		{
			pickingOrder.add(col);
		}
		for(CustomerOrderLine col : sectionG)
		{
			pickingOrder.add(col);
		}
		for(CustomerOrderLine col : sectionH)
		{
			pickingOrder.add(col);
		}
		for(CustomerOrderLine col : sectionI)
		{
			pickingOrder.add(col);
		}
		return pickingOrder;
	}
	
	public void showNextProduct(int coid)
	{
		ArrayList<CustomerOrderLine> currentOrderLines = colm.findByCOID(coid);
	}
}
