package com.netbuilder.BlueGardensEESystem;

import java.util.ArrayList;

public interface WarehouseWorkerManager {

	
	///////// CREATE /////////
	public void persistWarehouseWorker(WarehouseWorker warehouseWorker);
	public void persistWarehouseWorker(ArrayList<WarehouseWorker> warehouseWorkers);
	
	///////// UPDATE ////////
	public void updateWarehouseWorker(WarehouseWorker warehouseWorker);
	
	///////// READ /////////
	public WarehouseWorker findByName(String name);
	public WarehouseWorker findById(int id); 
		
	
	
	
	
}
