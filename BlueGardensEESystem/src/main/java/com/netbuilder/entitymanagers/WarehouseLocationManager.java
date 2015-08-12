package com.netbuilder.entitymanagers;

import java.util.ArrayList;
/**
 * This is the warehouse location manager.
 * Coded by lczornyj, with input from abalgel
 * 
 * @author lczornyj
 * @author abalgel
 */
import com.netbuilder.entities.WarehouseLocation;

public interface WarehouseLocationManager {

	public void persistWarehouseLocation(WarehouseLocation warehouseLocation);
	
	public void persistWarehouseLocations(ArrayList<WarehouseLocation> warehouseLocations);

	public void updateWarehouseLocation(WarehouseLocation warehouseLocation);

	public ArrayList<WarehouseLocation> findByProductID(int id);

}
