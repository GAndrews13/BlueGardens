package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;

import com.netbuilder.BlueGardensEESystem.DeliveryLocation;
import com.netbuilder.entities.PurchaseOrder;
import com.netbuilder.entities.Supplier;
import com.netbuilder.entitymanagers.PurchaseOrderManager;
@Alternative
public class PurchaseOrderManagerDummy implements PurchaseOrderManager 
{
	private ArrayList<PurchaseOrder> pol;
	
	public void persistPurchaseOrder(PurchaseOrder po)
	{
		pol.add(po);
	}
	public void persistPurchaseOrders(ArrayList<PurchaseOrder> purchaseOrders)
	{
		pol.addAll(purchaseOrders);
	}
	
	public void updatePurchaseOrder(PurchaseOrder po)
	{
		for(PurchaseOrder po1: pol)
		{
			pol.set(pol.indexOf(po1), po);
		}
	}
	
	public PurchaseOrder findByDeliveryLocation(DeliveryLocation dl)
	{
		PurchaseOrder poInst = null;
		for(PurchaseOrder po1: pol)
		{
			if(po1.getDeliveryLocation() == dl) poInst = po1;
		}
		return poInst;
	}
	public PurchaseOrder findByOutSupplier(Supplier supp)
	{
		PurchaseOrder poInst = null;
		for(PurchaseOrder po1: pol)
		{
			if(po1.getSupplier().equals(supp)) poInst = po1;
		}
		return poInst;
	}
	public PurchaseOrder findById(int id)
	{
		PurchaseOrder poInst = null;
		for(PurchaseOrder po1: pol)
		{
			if(po1.getID() == id) poInst = po1;
		}
		return poInst;
	}
	@Override
	public ArrayList<PurchaseOrder> findAll() {
		return pol;
	}

}
