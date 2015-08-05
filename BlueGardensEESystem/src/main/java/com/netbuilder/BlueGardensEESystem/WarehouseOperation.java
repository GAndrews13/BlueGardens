package com.netbuilder.BlueGardensEESystem;

import java.util.ArrayList;

import com.netbuilder.entities.CustomerOrder;
import com.netbuilder.entities.CustomerOrderLine;
import com.netbuilder.entities.WarehouseLocation;
import com.netbuilder.entities.WarehouseWorker;
import com.netbuilder.entitymanagers.CustomerOrderManager;
import com.netbuilder.entitymanagers.WarehouseLocationManager;
import com.netbuilder.entitymanagers.WarehouseWorkerManager;
import com.netbuilder.entitymanagers.Dummy.CustomerOrderManagerDummy;
import com.netbuilder.entitymanagers.Dummy.WarehouseLocationManagerDummy;
import com.netbuilder.entitymanagers.Dummy.WarehouseWorkerManagerDummy;

public class WarehouseOperation 
{
	WarehouseWorkerManager wwm = new WarehouseWorkerManagerDummy();
	CustomerOrderManager com = new CustomerOrderManagerDummy();
	CustomerOrderLIneManager colm = new Cu
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
	
	public void showNextProduct(int id)
	{
		CustomerOrder order = com.findByTrackingId(id);
		ArrayList<CustomerOrderLine> col = 
	}
}
