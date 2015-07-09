package com.netbuilder.entitymanagers;
/**
 * Created the Worker Dummy, for creating the database implementation
 * no find by ID as automatic settings.
 * @author lczornyj
 */
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
		for (int i = 0; i < warehouseWorkers.size(); i++){
			this.warehouseWorkers.set(warehouseWorkers.indexOf(warehouseWorker), warehouseWorker);
			}
	}

	public WarehouseWorker findByName(String name) {
		// TODO Auto-generated method stub
		for(WarehouseWorker w : warehouseWorkers)
		{
			if(w.getName() == name)
			{
				return w;
			}
		}
		return null;
	}

	
	//keeping this here for future reference
	public WarehouseWorker findById(int id) {
		// TODO Auto-generated method stub
		for(WarehouseWorker w : warehouseWorkers)
		{
			if(w.getWorkerId() == id)
			{
				return w;
			}
		}
		return null;
		
	}

}
