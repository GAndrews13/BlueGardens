package com.netbuilder.entitymanagers;

import java.util.ArrayList;

import com.netbuilder.entities.WarehouseWorker;

public class WarehouseWorkerManagerDummy implements WarehouseWorkerManager {
	ArrayList<WarehouseWorker> warehouseWorkers = new ArrayList<WarehouseWorker>();
	
	public void persistWarehouseWorker(WarehouseWorker warehouseWorker) {
		// TODO Auto-generated method stub
		this.warehouseWorkers.add(warehouseWorker);
	}

	public void persistWarehouseWorker(ArrayList<WarehouseWorker> warehouseWorkers) {
		// TODO Auto-generated method stub
		this.warehouseWorkers.addAll(warehouseWorkers);
	}

	public void updateWarehouseWorker(WarehouseWorker warehouseWorker) {
		// TODO Auto-generated method stub

	}

	public WarehouseWorker findByName(String name) {
		// TODO Auto-generated method stub
		ArrayList<WarehouseWorker> List = new ArrayList<WarehouseWorker>();
		for (WarehouseWorker w : warehouseWorkers) { 
			if (w.getName().equals(name))
				List.add(w);
		}
		return null;
	}

	public WarehouseWorker findById(int id) {
		// TODO Auto-generated method stub
		
		ArrayList<WarehouseWorker> List = new ArrayList<WarehouseWorker>();
		for (WarehouseWorker w : warehouseWorkers) { 
			if (w.getName().equals(id))
				List.add(w);
		}
		return null;
	}

}
