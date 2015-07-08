package com.netbuilder.entitymanagers;

import java.util.ArrayList;

import com.netbuilder.entities.Supplier;

public class SupplierManagerDummy implements SupplierManager {
	ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
	
	public void persistSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
			this.suppliers.add(supplier);
	}

	public void persistSupplier(ArrayList<Supplier> supplier) {
		// TODO Auto-generated method stub
		this.suppliers.addAll(supplier);
	}

	public void updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		
		suppliers.set(suppliers.indexOf(supplier), supplier);
	}

	public Supplier findByName(String name) {
		// TODO Auto-generated method stub
		
		ArrayList<Supplier> List = new ArrayList<Supplier>();
		for (Supplier s : suppliers) {
			if (s.getName().equals(name))
				List.add(s);
		}	
		return null;
	}

	public Supplier findById(int id) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
