package com.netbuilder.entitymanagers;

import java.util.ArrayList;

import com.netbuilder.entities.PurchaseOrderLine;

public interface PurchaseOrderLineManager 
{
	public void persistPurchaseOrderLine(PurchaseOrderLine pol);
	public void persistPurchaseOrderLines(ArrayList<PurchaseOrderLine> pols);
	
	public void updatePurchaseOrderLine(PurchaseOrderLine pol);
	
	public PurchaseOrderLine findbyPurchaseOrderID(int poid);
	public PurchaseOrderLine findbyProductID(int pid);
}
