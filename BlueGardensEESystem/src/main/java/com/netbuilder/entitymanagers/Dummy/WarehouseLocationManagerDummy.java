package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;
import com.netbuilder.entities.WarehouseLocation;
import com.netbuilder.entitymanagers.WarehouseLocationManager;

/**@author anca*/
@Alternative
public class WarehouseLocationManagerDummy implements WarehouseLocationManager {
private ArrayList<WarehouseLocation> warehouseLocations = new ArrayList<WarehouseLocation>();	
	
	public void persistWarehouseLocation(WarehouseLocation warehouseLocation) {
		warehouseLocations.add(warehouseLocation);
	}
	
	public void updateWarehouseLocation(WarehouseLocation warehouseLocation) {
		warehouseLocations.set(warehouseLocations.indexOf(warehouseLocation), warehouseLocation);
	}

	@Override
	public ArrayList<WarehouseLocation> findByProductID(int id) {
		ArrayList<WarehouseLocation> result = new ArrayList<WarehouseLocation>();
		for (WarehouseLocation wl : warehouseLocations){
			if(wl.getProductId() == id)
				result.add(wl);
		}
		return result;
	}
}