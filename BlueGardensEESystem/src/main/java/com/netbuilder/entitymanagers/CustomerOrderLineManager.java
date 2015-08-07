package com.netbuilder.entitymanagers;
/**
 * @author Jake
 *	
 */
import java.util.ArrayList;

import com.netbuilder.entities.CustomerOrderLine;

public interface CustomerOrderLineManager 
{	

	public void persistCOL(CustomerOrderLine col);
	public ArrayList<CustomerOrderLine> findByPOID(int po_ID);
	public ArrayList<CustomerOrderLine> findByCOID(int coid);
	public ArrayList<CustomerOrderLine> findByQuantity(int quantity);
	public void updateCOL(CustomerOrderLine pol);
	public ArrayList<CustomerOrderLine> findAll();
	
}
