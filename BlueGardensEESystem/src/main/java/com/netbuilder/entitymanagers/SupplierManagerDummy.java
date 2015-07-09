package com.netbuilder.entitymanagers;
/**
 * Created Supplier manager with the methods below.
 * There is no findId method as there is no setter for ID
 * @author lczornyj
 */
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
		for (int i = 0; i < suppliers.size(); i++){
		this.suppliers.set(suppliers.indexOf(supplier), supplier);
		}
	}

	public Supplier findByName(String name) {
		// TODO Auto-generated method stub
		
		for(Supplier s : suppliers)
		{
			if(s.getName() == name)
			{
				return s;
			}
		}
		return null;
	}
	// keeping this here for future reference
	public Supplier findById(int id) {
		// TODO Auto-generated method stub
		
		for(Supplier s : suppliers)
		{
			if(s.getSupplierId() == id)
			{
				return s;
			}
			
		}
		return null;

}
}
