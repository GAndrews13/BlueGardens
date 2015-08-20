package com.netbuilder.entitymanagers;

import com.netbuilder.entities.Discount;
import com.netbuilder.entities.SpecialOffer;

/**
 *	Used to keep track of special offers on products  
 * @author GAndrews
 * @author ABalagel
 *
 */
public interface SpecialOfferManager {

	public void persistSpecialOffer(SpecialOffer inSpecialOffer);
	
	public void updateSpecialOffer(SpecialOffer inSpecialOffer);
	
	public SpecialOffer findSpecialOffer(String inSpecialOfferID);
}
