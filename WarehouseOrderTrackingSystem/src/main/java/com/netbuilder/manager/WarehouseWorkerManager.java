package com.netbuilder.manager;

import com.netbuilder.model.DummyData;
import com.netbuilder.model.WarehouseWorker;

public class WarehouseWorkerManager 
{
	DummyData dd;
	public WarehouseWorker findById(int id) {
		for (WarehouseWorker w : dd.getWorkers()) {
			if (w.getWorkerId() == id) {
				return w;
			}
		}
		return null;
	}
}
