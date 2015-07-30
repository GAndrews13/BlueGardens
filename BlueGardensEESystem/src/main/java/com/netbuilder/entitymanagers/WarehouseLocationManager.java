package com.netbuilder.entitymanagers;

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
	
	public void updateWarehouseLocation(WarehouseLocation warehouseLocation);
	
	public WarehouseLocation findoutbyproductID(int id);
	
}
