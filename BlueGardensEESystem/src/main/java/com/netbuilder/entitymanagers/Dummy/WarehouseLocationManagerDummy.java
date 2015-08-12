package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import com.netbuilder.entities.WarehouseLocation;
import com.netbuilder.entitymanagers.WarehouseLocationManager;
import com.netbuilder.util.DummyData;

/** @author anca */

@Alternative
public class WarehouseLocationManagerDummy implements WarehouseLocationManager {
	
	@Inject
	DummyData dd;

	public void persistWarehouseLocation(WarehouseLocation warehouseLocation) {
		dd.setLocation(warehouseLocation);
	}
	
	public void persistWarehouseLocations(
			ArrayList<WarehouseLocation> warehouseLocations) {
		dd.setLocations(warehouseLocations);		
	}

	public ArrayList<WarehouseLocation> findByProductID(int id) {
		ArrayList<WarehouseLocation> list = new ArrayList<WarehouseLocation>();
		for (WarehouseLocation wl : dd.getLocations()) {
			if (wl.getProductId() == id) {
				list.add(wl);
			}
		}
		return list;
	}

	public void updateWarehouseLocation(WarehouseLocation warehouseLocation) {
		// TODO Auto-generated method stub
	}

}
