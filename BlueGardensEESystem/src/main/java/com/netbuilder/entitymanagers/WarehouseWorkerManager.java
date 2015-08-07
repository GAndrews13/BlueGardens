package com.netbuilder.entitymanagers;

import java.util.ArrayList;

import com.netbuilder.entities.WarehouseWorker;

/**
 * 
 * @author lczornyj
 *Created the Warehouse	Entity interface.
 */
public interface WarehouseWorkerManager {
	///////// CREATE /////////
	public void persistWarehouseWorker(WarehouseWorker warehouseWorker);
	public void persistWarehouseWorker(ArrayList<WarehouseWorker> warehouseWorker);
	///////// UPDATE ////////
	public void updateWarehouseWorker(WarehouseWorker warehouseWorker);
	///////// READ /////////
	public WarehouseWorker findByName(String name);
	public WarehouseWorker findById(int id); 
	public WarehouseWorker isAssigned(boolean isAssigned);	
}