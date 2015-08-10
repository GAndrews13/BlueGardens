package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;

import com.netbuilder.entities.PurchaseOrderLine;
import com.netbuilder.entitymanagers.PurchaseOrderLineManager;

@Alternative
public class PurchaseOrderLineManagerDummy implements PurchaseOrderLineManager {
	private ArrayList<PurchaseOrderLine> pols;
	
	public void persistPurchaseOrderLine(PurchaseOrderLine pol) {
		pols.add(pol);
	}
	
	public void persistPurchaseOrderLines(ArrayList<PurchaseOrderLine> pols) {
		pols.addAll(pols);
	}
	
	@Override
	public void updatePurchaseOrderLine(PurchaseOrderLine pol) {
		for(PurchaseOrderLine pol1: pols) {
			pols.set(pols.indexOf(pol1), pol);
		}
	}
	
	@Override
	public ArrayList<PurchaseOrderLine> findbyPurchaseOrderID(int poid) {
		ArrayList<PurchaseOrderLine> thesePOLs = new ArrayList<PurchaseOrderLine>();
		for(PurchaseOrderLine pol : pols) {
			if(pol.getPurchaseOrderID() == poid)
				thesePOLs.add(pol);
		}
		return thesePOLs;
	}
	
	@Override
	public ArrayList<PurchaseOrderLine> findbyProductID(int pid) {
		ArrayList<PurchaseOrderLine> thesePOLs = new ArrayList<PurchaseOrderLine>();
		for(PurchaseOrderLine pol : pols) {
			if(pol.getProductID() == pid)
				thesePOLs.add(pol);
		}
		return thesePOLs;
	}
}