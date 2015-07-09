package com.netbuilder.entitymanagers.Dummy;
/**
 * Created Supplier manager with the methods below.
 * There is no findId method as there is no setter for ID
 * @author lczornyj
 */
import java.util.ArrayList;

import javax.enterprise.inject.Alternative;

import com.netbuilder.entities.Supplier;
import com.netbuilder.entitymanagers.SupplierManager;

@Alternative
public class SupplierManagerDummy implements SupplierManager {
	ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
	
	public void persistSupplier(Supplier supplier) {
			this.suppliers.add(supplier);
	}

	public void persistSupplier(ArrayList<Supplier> supplier) {
		this.suppliers.addAll(supplier);
	}

	public void updateSupplier(Supplier supplier) {
		for (int i = 0; i < suppliers.size(); i++){
		this.suppliers.set(suppliers.indexOf(supplier), supplier);
		}
	}

	public Supplier findByName(String name) {
		for(Supplier s : suppliers)
		{
			if(s.getName().equals(name))
			{
				return s;
			}
		}
		return null;
	}
	// keeping this here for future reference
	public Supplier findById(int id) {
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
