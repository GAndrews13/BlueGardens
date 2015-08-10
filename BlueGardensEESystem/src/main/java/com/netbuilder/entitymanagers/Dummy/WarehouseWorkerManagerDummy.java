package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;




import javax.enterprise.inject.Alternative;

import com.netbuilder.entities.WarehouseWorker;
import com.netbuilder.entitymanagers.WarehouseWorkerManager;

/**
 * Created the Worker Dummy, for creating the database implementation
 * no find by ID as automatic settings.
 * @author lczornyj
 */
@Alternative
public class WarehouseWorkerManagerDummy implements WarehouseWorkerManager {
	ArrayList<WarehouseWorker> warehouseWorkers = new ArrayList<WarehouseWorker>();
	
	public void persistWarehouseWorker(WarehouseWorker warehouseWorker) {
		this.warehouseWorkers.add(warehouseWorker);
	}

	public void persistWarehouseWorker(ArrayList<WarehouseWorker> warehouseWorkers) {
		this.warehouseWorkers.addAll(warehouseWorkers);
	}

	public void updateWarehouseWorker(WarehouseWorker warehouseWorker) {
		for (int i = 0; i < warehouseWorkers.size(); i++) {
			this.warehouseWorkers.set(warehouseWorkers.indexOf(warehouseWorker), warehouseWorker);
		}
	}

	public WarehouseWorker findByName(String name) {
		for(WarehouseWorker w : warehouseWorkers) {
			if(w.getName().equals(name))
				return w;
		}
		return null;
	}

	//keeping this here for future reference
	public WarehouseWorker findById(int id) {
		for(WarehouseWorker w : warehouseWorkers) {
			if(w.getWorkerId() == id)
				return w;
		}
		return null;
	}

	@Override
	public WarehouseWorker isAssigned(boolean isAssigned) {
		for (WarehouseWorker w : warehouseWorkers){
			if(w.isAssigned() == true)
				return w;
		}
		return null;
	}
}