package com.netbuilder.entitymanagers.Dummy;

/**
 * Created the Worker Dummy, for creating the database implementation
 * no find by ID as automatic settings.
 * @author lczornyj
 */
import java.util.ArrayList;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import com.netbuilder.entities.WarehouseWorker;
import com.netbuilder.entitymanagers.WarehouseWorkerManager;
import com.netbuilder.util.DummyData;

@Alternative
public class WarehouseWorkerManagerDummy implements WarehouseWorkerManager {

	@Inject
	DummyData dd;
	
	public void persistWarehouseWorker(WarehouseWorker warehouseWorker) {
		dd.setWorker(warehouseWorker);
	}

	public void persistWarehouseWorker(
			ArrayList<WarehouseWorker> warehouseWorkers) {
		dd.setWorkers(warehouseWorkers);
	}

	public void updateWarehouseWorker(WarehouseWorker warehouseWorker) {
		for (int i = 0; i < dd.getWorkers().size(); i++) {
			if (warehouseWorker.getWorkerId() == dd.getWorkers().get(i)
					.getWorkerId()) {
				dd.setWorker(warehouseWorker);
			}
		}
	}

	public ArrayList<WarehouseWorker> findByName(String name) {
		ArrayList<WarehouseWorker> list = new ArrayList<WarehouseWorker>();
		for (WarehouseWorker w : dd.getWorkers()) {
			if (w.getName().equals(name)) {
				list.add(w);
			}
		}
		return list;
	}

	public WarehouseWorker findById(int id) {
		for (WarehouseWorker w : dd.getWorkers()) {
			if (w.getWorkerId() == id) {
				return w;
			}
		}
		return null;
	}

	public ArrayList<WarehouseWorker> isAssigned(boolean isAssigned) {
		ArrayList<WarehouseWorker> list = new ArrayList<WarehouseWorker>();
		for (WarehouseWorker w : dd.getWorkers()) {
			if (w.isAssigned() == isAssigned) {
				list.add(w);
			}
		}
		return list;
	}

}
