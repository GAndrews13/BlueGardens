package com.netbuilder.BlueGardensEESystem;

import java.util.ArrayList;

import com.netbuilder.entities.CustomerOrder;
import com.netbuilder.entities.CustomerOrderLine;
import com.netbuilder.entities.WarehouseLocation;
import com.netbuilder.entities.WarehouseWorker;
import com.netbuilder.entitymanagers.CustomerOrderLineManager;
import com.netbuilder.entitymanagers.CustomerOrderManager;
import com.netbuilder.entitymanagers.WarehouseLocationManager;
import com.netbuilder.entitymanagers.WarehouseWorkerManager;
import com.netbuilder.entitymanagers.Dummy.CustomerOrderLineManagerDummy;
import com.netbuilder.entitymanagers.Dummy.CustomerOrderManagerDummy;
import com.netbuilder.entitymanagers.Dummy.WarehouseLocationManagerDummy;
import com.netbuilder.entitymanagers.Dummy.WarehouseWorkerManagerDummy;

public class WarehouseOperation 
{
	WarehouseWorkerManager wwm = new WarehouseWorkerManagerDummy();
	CustomerOrderManager com = new CustomerOrderManagerDummy();
	CustomerOrderLineManager colm = new CustomerOrderLineManagerDummy();
	WarehouseLocationManager wlm = new WarehouseLocationManagerDummy();
	ArrayList<CustomerOrder> openOrders;
	ArrayList<CustomerOrder> assignedOrders;
	
	public WarehouseOperation() {
		openOrders = com.findByDeliveryStatus(DeliveryStatus.ORDER_PLACED);	
		assignedOrders = com.findByDeliveryStatus(DeliveryStatus.PROCESSING);
	}
	
	public void assignWorkerToOrder(int id) {
		WarehouseWorker worker = wwm.findById(id);
		CustomerOrder order = openOrders.get(1);
		worker.setAssigned(true);
		order.setIsAssigned(true);
		order.setWorker(worker);
		order.setStatus(DeliveryStatus.PROCESSING);
	}
	
	public void completeOrder(int id) {
		WarehouseWorker worker = wwm.findById(id);
		CustomerOrder order = openOrders.get(1);
		worker.setAssigned(false);
		order.setIsAssigned(false);
		order.setWorker(worker);
		order.setStatus(DeliveryStatus.READY);
	} 
	
	@SuppressWarnings("unchecked")
	public ArrayList<CustomerOrderLine> setPickingOrder(int coid) {
		ArrayList<CustomerOrderLine> currentOrderLines = colm.findByCOID(coid);
		ArrayList<CustomerOrderLine> pickingOrder = new ArrayList<CustomerOrderLine>();
		ArrayList<String> ssectionA = new ArrayList<String>();
		ArrayList<CustomerOrderLine> sectionA = new ArrayList<CustomerOrderLine>();
		ArrayList<String> ssectionB = new ArrayList<String>();
		ArrayList<CustomerOrderLine> sectionB = new ArrayList<CustomerOrderLine>();
		ArrayList<String> ssectionC = new ArrayList<String>();
		ArrayList<CustomerOrderLine> sectionC = new ArrayList<CustomerOrderLine>();
		ArrayList<String> ssectionD = new ArrayList<String>();
		ArrayList<CustomerOrderLine> sectionD = new ArrayList<CustomerOrderLine>();
		ArrayList<String> ssectionE = new ArrayList<String>();
		ArrayList<CustomerOrderLine> sectionE = new ArrayList<CustomerOrderLine>();
		ArrayList<String> ssectionF = new ArrayList<String>();
		ArrayList<CustomerOrderLine> sectionF = new ArrayList<CustomerOrderLine>();
		ArrayList<String> ssectionG = new ArrayList<String>();
		ArrayList<CustomerOrderLine> sectionG = new ArrayList<CustomerOrderLine>();
		ArrayList<String> ssectionH = new ArrayList<String>();
		ArrayList<CustomerOrderLine> sectionH = new ArrayList<CustomerOrderLine>();
		ArrayList<String> ssectionI = new ArrayList<String>();
		ArrayList<CustomerOrderLine> sectionI = new ArrayList<CustomerOrderLine>();
		for(CustomerOrderLine col : currentOrderLines) {
			int productID = col.getProductId();
			ArrayList<WarehouseLocation> thisIDLocations = wlm.findByProductID(productID);
			WarehouseLocation selected = thisIDLocations.get(1);
			String locID = selected.getLocationId();
			Object[] sections = new Object[2];
			if(locID.startsWith("A")) {
				sections = addProduct("A", col, ssectionA, sectionA, locID);
				ssectionA = (ArrayList<String>) sections[0];
				sectionA = (ArrayList<CustomerOrderLine>) sections[1];
			} else { if(locID.startsWith("B")) {		
					sections = addProduct("B", col, ssectionB, sectionB, locID);
					ssectionB = (ArrayList<String>) sections[0];
					sectionB = (ArrayList<CustomerOrderLine>) sections[1];
				} else { if(locID.startsWith("C")) {	
						sections = addProduct("C", col, ssectionC, sectionC, locID);
						ssectionC = (ArrayList<String>) sections[0];
						sectionC = (ArrayList<CustomerOrderLine>) sections[1];
					} else { if(locID.startsWith("D")) {
							sections = addProduct("C", col, ssectionC, sectionC, locID);
							ssectionD = (ArrayList<String>) sections[0];
							sectionD = (ArrayList<CustomerOrderLine>) sections[1];
						} else { if(locID.startsWith("E")) {
								sections = addProduct("C", col, ssectionC, sectionC, locID);
								ssectionE = (ArrayList<String>) sections[0];
								sectionE = (ArrayList<CustomerOrderLine>) sections[1];
							} else { if(locID.startsWith("F")) {
									sections = addProduct("C", col, ssectionC, sectionC, locID);
									ssectionF = (ArrayList<String>) sections[0];
									sectionF = (ArrayList<CustomerOrderLine>) sections[1];
								} else { if(locID.startsWith("G")) {
										sections = addProduct("C", col, ssectionC, sectionC, locID);
										ssectionG = (ArrayList<String>) sections[0];
										sectionG = (ArrayList<CustomerOrderLine>) sections[1];
									} else { if(locID.startsWith("H")) {	
											sections = addProduct("C", col, ssectionC, sectionC, locID);
											ssectionH = (ArrayList<String>) sections[0];
											sectionH = (ArrayList<CustomerOrderLine>) sections[1];
										} else { if(locID.startsWith("I")) {
												sections = addProduct("C", col, ssectionC, sectionC, locID);
												ssectionI = (ArrayList<String>) sections[0];
												sectionI = (ArrayList<CustomerOrderLine>) sections[1];
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		pickingOrder = addToPicking(pickingOrder, sectionA);
		pickingOrder = addToPicking(pickingOrder, sectionB);
		pickingOrder = addToPicking(pickingOrder, sectionC);
		pickingOrder = addToPicking(pickingOrder, sectionD);
		pickingOrder = addToPicking(pickingOrder, sectionE);
		pickingOrder = addToPicking(pickingOrder, sectionF);
		pickingOrder = addToPicking(pickingOrder, sectionG);
		pickingOrder = addToPicking(pickingOrder, sectionH);
		pickingOrder = addToPicking(pickingOrder, sectionI);
		return pickingOrder;
	}
	
	private ArrayList<CustomerOrderLine> addToPicking(ArrayList<CustomerOrderLine> pickOrder, ArrayList<CustomerOrderLine> section) {
		for (CustomerOrderLine line : section) {
			pickOrder.add(line);
		}
		return pickOrder;
	}
	
	private Object[] addProduct(String spliter, CustomerOrderLine col, ArrayList<String> ssection, ArrayList<CustomerOrderLine> section, String locid) {
		String[] s = locid.split(spliter);
		int row = Integer.parseInt(s[1]); 
		if(section.size() == 0) {
			ssection.add(locid);
			section.add(col);
		} else {
			for(int i = 0; i < ssection.size(); i++) {
				String[] tempS = ssection.get(i).split(spliter);
				int tempRow = Integer.parseInt(tempS[1]); 						
				if(row > tempRow) {
					ssection.add(i, locid);
					section.add(i, col);
				}
			}
		}
		return new Object[]{ssection, section};
	}
	
	public void showNextProduct(int coid) {
		ArrayList<CustomerOrderLine> currentOrderLines = colm.findByCOID(coid);
	}
}