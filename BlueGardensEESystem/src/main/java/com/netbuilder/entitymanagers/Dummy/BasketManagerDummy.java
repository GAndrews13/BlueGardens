package com.netbuilder.entitymanagers.Dummy;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.netbuilder.entities.Basket;
import com.netbuilder.entities.CustomerOrderLine;
import com.netbuilder.entities.Product;
import com.netbuilder.entitymanagers.BasketManager;
import com.netbuilder.entitymanagers.ProductManager;

/**
 * @author abalagel links interface with db
 */

@Alternative
public class BasketManagerDummy implements BasketManager, Serializable {
	Basket localbasket = new Basket(1, 1, new ArrayList<CustomerOrderLine>());
	@Inject
	ProductManager productManager;

	public void persistBasket(Basket basket) {
		localbasket = basket;
	}

	public void updateBasket(Basket basket) {
		// localbasket.set(localbasket.indexOf(basket),basket);
		localbasket = basket;
	}

	@Override
	public double findTotal() {
		double total = 0;
		if (localbasket.getCustomerOrderLines() != null) {
			for (int i = 0; i < localbasket.getCustomerOrderLines().size(); i++) {
				total += localbasket.getCustomerOrderLines().get(i)
						.getQuantity()
						* productManager.findById(
								localbasket.getCustomerOrderLines().get(i)
										.getProductId()).getPrice();
			}
		}
		return total;
	}

	/**
	 * @author GAndrews
	 */
	public void addProduct(int inProduct, int inQuantity) {
		System.out.println(inProduct + " x " + inQuantity + "VALUES");
		localbasket.getCustomerOrderLines().add(
				new CustomerOrderLine(inProduct, inQuantity));
	}

	public void changeQuantity(Product inProduct, int inQuantity) {
		for (int i = 0; i < localbasket.getCustomerOrderLines().size(); i++) {
			CustomerOrderLine temp = localbasket.getCustomerOrderLines().get(i);
			if (inProduct.getProductID() == temp.getProductId()) {
				temp.setQuantity(inQuantity);
				localbasket.getCustomerOrderLines().set(i, temp);
			}
		}
	}

	public void removeProduct(Product inProduct) {
		for (int i = 0; i < localbasket.getCustomerOrderLines().size(); i++) {
			if (inProduct.getProductID() == localbasket.getCustomerOrderLines()
					.get(i).getProductId()) {
				localbasket.getCustomerOrderLines().remove(i);
			}
		}
	}

	@Override
	public ArrayList<CustomerOrderLine> products() {
		ArrayList<CustomerOrderLine> POL = localbasket.getCustomerOrderLines();
		if (POL == null) {
			System.out.println("YEAH");
			return new ArrayList<CustomerOrderLine>();
		}
		return POL;
	}
}
