package com.netbuilder.BlueGardensEESystem;

import java.util.ArrayList;

import com.netbuilder.entities.Supplier;

public interface SupplierManager {

	///////// Create /////////
	public void persistSupplier(Supplier supplier);
	public void persistSupplier(ArrayList<Supplier> supplier);
	
	///////// UPDATE /////////
	public void updateSupplier(Supplier supplier);
	
	///////// READ //////////
	public Supplier findByName(String name);
	public Supplier findById(int id); 
	
}
