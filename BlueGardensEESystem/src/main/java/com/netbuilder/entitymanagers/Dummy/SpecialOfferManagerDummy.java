package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;

import com.netbuilder.entities.SpecialOffer;
import com.netbuilder.util.DummyData;
import com.netbuilder.entitymanagers.SpecialOfferManager;

/**
 * 
 * @author GAndrews
 * @author ABalagel
 */
public class SpecialOfferManagerDummy implements SpecialOfferManager {

	private DummyData dd = new DummyData();
	/**
	 * Creates an instance of the special offer within the duummy data
	 */
	@Override
	public void persistSpecialOffer(SpecialOffer inSpecialOffer) {
		ArrayList<SpecialOffer> tso = dd.getSpecialOffers();
		tso.add(inSpecialOffer);
		dd.setSpecialOffers(tso);
	}	
	/**
	 * Returns a special offer that uses the provided special offer ID
	 * WARNING: May return null
	 */
	@Override
	public SpecialOffer findSpecialOffer(String inSpecialOfferID) {
		ArrayList<SpecialOffer> tso = dd.getSpecialOffers();
		for (SpecialOffer so : tso){
			if(so.getSpecialOfferID() == inSpecialOfferID){
				return so;
			}
		}
		return null;
	}

	/**
	 * Updates the initial instance of a special offer with the updated format
	 */
	@Override
	public void updateSpecialOffer(SpecialOffer inSpecialOffer) {
		ArrayList<SpecialOffer> tso = dd.getSpecialOffers();
		for(int i=0; i<tso.size();i++){
			SpecialOffer so = tso.get(i);
			if(so.getSpecialOfferID() == inSpecialOffer.getSpecialOfferID()){
				tso.set(i, inSpecialOffer);
				break;
			}
		}
		dd.setSpecialOffers(tso);
	}
}
