package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;

import com.netbuilder.entities.CustomerOrderLine;
import com.netbuilder.entities.ProductOrderLine;
import com.netbuilder.entitymanagers.CustomerOrderLineManager;
/**
 * 
 * @author Jake
 *	Dummy class for testing the customer order line
 */

public class CustomerOrderLineManagerDummy implements CustomerOrderLineManager
{
	ArrayList<CustomerOrderLine> col_Array = new ArrayList<CustomerOrderLine>();
	@Override
	public void persistCOL(CustomerOrderLine col) 
	{
		col_Array.add(col);
	}

	@Override
	public ArrayList<CustomerOrderLine> findByPOID(int po_ID) {
		return null;
	}

	@Override
	public ArrayList<CustomerOrderLine> findByCOID(int customerID) 
	{
		ArrayList<CustomerOrderLine> localLine = new ArrayList<CustomerOrderLine>();
		for(CustomerOrderLine col : col_Array)
		{
			if(col.getCustomerOrderLineID() == customerID)
			{
				localLine.add(col);
			}
		}
		
		return localLine;
	}

	@Override
	public ArrayList<CustomerOrderLine> findByQuantity(int quantity)
	{
		ArrayList<CustomerOrderLine> localLine = new ArrayList<CustomerOrderLine>();
		for(CustomerOrderLine col : col_Array)
		{
			if(col.getQuantity() <= quantity)
			{
				localLine.add(col);
			}
		}
		return localLine;
	}

	@Override
	public void updateCOL(CustomerOrderLine pol) 
	{
		col_Array.set(col_Array.indexOf(pol), pol);

	}

	@Override
	public ArrayList<CustomerOrderLine> findAll() {
		// TODO Auto-generated method stub
		return col_Array;
	}

}
