package com.netbuilder.BlueGardensEESystem;

import java.util.HashMap;

public class WarehouseMap {
	
	public HashMap<String, Long> productLoc; 
	public String[] warehouseLoc;
	
	public WarehouseMap()
	{
		warehouseLoc[1] = "A1";
		warehouseLoc[2] = "A2";
		warehouseLoc[3] = "A3";
		warehouseLoc[4] = "A4";
		warehouseLoc[5] = "B1";
		warehouseLoc[6] = "B2";
		warehouseLoc[7] = "B3";
		warehouseLoc[8] = "B4";
		warehouseLoc[9] = "C1";
		warehouseLoc[10] = "C2";
		warehouseLoc[11] = "C3";
		warehouseLoc[11] = "C4";	
	}
	
	public HashMap<String, Long> getProductLoc()
	{
		return productLoc;
	}
	
	public void setProductLoc(HashMap<String, Long> pL)
	{
		productLoc = pL;
	}
	
	public void populateHashMap()
	{
		
	}
	 
}
