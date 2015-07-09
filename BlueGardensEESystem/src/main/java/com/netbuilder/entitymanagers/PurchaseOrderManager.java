package com.netbuilder.entitymanagers;

import java.util.ArrayList;

import com.netbuilder.entities.PurchaseOrder;

public interface PurchaseOrderManager {

	public void persistPurchaseOrder(PurchaseOrder po);
	public void persistPurchaseOrders(ArrayList<PurchaseOrder> purchaseOrders);
	
	public void updateProduct(PurchaseOrder po);
	
	public ArrayList<PurchaseOrder> findByName(String name);
	public ArrayList<PurchaseOrder> findByDeliveryLocation(double price);
	public ArrayList<PurchaseOrder> findByOutSupplier();
	public PurchaseOrder findById(long id);
	public ArrayList<PurchaseOrder> findAll();
}
