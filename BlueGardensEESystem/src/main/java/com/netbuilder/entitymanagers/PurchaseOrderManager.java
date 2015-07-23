package com.netbuilder.entitymanagers;

import java.util.ArrayList;

import com.netbuilder.entities.DeliveryLocation;
import com.netbuilder.entities.PurchaseOrder;
import com.netbuilder.entities.Supplier;

public interface PurchaseOrderManager {

	public void persistPurchaseOrder(PurchaseOrder po);
	public void persistPurchaseOrders(ArrayList<PurchaseOrder> purchaseOrders);
	
	public void updatePurchaseOrder(PurchaseOrder po);
	
	public PurchaseOrder findByDeliveryLocation(DeliveryLocation dl);
	public PurchaseOrder findByOutSupplier(Supplier supp);
	public PurchaseOrder findById(int id);
	public ArrayList<PurchaseOrder> findAll();
}
