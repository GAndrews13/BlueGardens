package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;

import com.netbuilder.BlueGardensEESystem.DeliveryLocation;
import com.netbuilder.entities.PurchaseOrder;
import com.netbuilder.entities.PurchaseOrderLine;
import com.netbuilder.entities.Supplier;
import com.netbuilder.entitymanagers.PurchaseOrderLineManager;
import com.netbuilder.entitymanagers.PurchaseOrderManager;

public class PurchaseOrderLineManagerDummy implements PurchaseOrderLineManager {

	private ArrayList<PurchaseOrderLine> pols;
	
	public void persistPurchaseOrderLine(PurchaseOrderLine pol)
	{
		pols.add(pol);
	}
	public void persistPurchaseOrderLines(ArrayList<PurchaseOrderLine> pols)
	{
		pols.addAll(pols);
	}
	@Override
	public void updatePurchaseOrderLine(PurchaseOrderLine pol) {
		// TODO Auto-generated method stub
		for(PurchaseOrderLine pol1: pols)
		{
			pols.set(pols.indexOf(pol1), pol);
		}
	}
	@Override
	public void updatePurchaseOrderLines(ArrayList<PurchaseOrderLine> pols) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<PurchaseOrderLine> findbyPurchaseOrderID(int poid) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<PurchaseOrderLine> findbyProductID(int pid) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
