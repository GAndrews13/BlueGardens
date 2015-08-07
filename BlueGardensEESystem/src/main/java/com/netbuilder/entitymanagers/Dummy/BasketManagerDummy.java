package com.netbuilder.entitymanagers.Dummy;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import com.netbuilder.entities.Basket;
import com.netbuilder.entities.Product;
import com.netbuilder.entities.CustomerOrderLine;
import com.netbuilder.entitymanagers.BasketManager;
import com.netbuilder.entitymanagers.ProductManager;


/**
 * @author abalagel
 * links interface with db
 */

@Alternative
public class BasketManagerDummy implements BasketManager,Serializable {
	Basket localbasket = new Basket(0, null); 
	@Inject
	ProductManager productManager;
	
	public void persistBasket(Basket basket){
		localbasket = basket;
	}
	
	public void updateBasket(Basket basket){
	//localbasket.set(localbasket.indexOf(basket),basket);
		localbasket = basket;
	}

	@Override
	public double findTotal() {
		double total = 0;
		if(localbasket.getCustomerOrderLine()!= null)
		{
			for(int i = 0;i<localbasket.getCustomerOrderLine().size();i++)
			{
				total+=localbasket.getCustomerOrderLine().get(i).getQuantity()*productManager.findById(
						localbasket.getCustomerOrderLine().get(i).getProductId()).getPrice(); 
			}
		}
		return total;
	}
	
	/**
	 * @author GAndrews
	 */
	public void addProduct(int inProduct,int inQuantity)
	{
		localbasket.getCustomerOrderLine().add(new CustomerOrderLine(inProduct,inQuantity));
	}
	
	public void addProduct(Product inProduct,int inQuantity)
	{
		localbasket.getCustomerOrderLine().add(new CustomerOrderLine(inProduct.getProductID(),inQuantity));
	}
	
	public void changeQuantity(Product inProduct,int inQuantity)
	{
		for(int i = 0;i<localbasket.getCustomerOrderLine().size();i++)
		{
			CustomerOrderLine temp = localbasket.getCustomerOrderLine().get(i);
			if(inProduct.getProductID() == temp.getProductId())
			{
				temp.setQuantity(inQuantity);
				localbasket.getCustomerOrderLine().set(i, temp);
			}
		}
	}
	
	public void removeProduct(Product inProduct)
	{
		for(int i = 0;i<localbasket.getCustomerOrderLine().size();i++)
		{
			if(inProduct.getProductID()==localbasket.getCustomerOrderLine().get(i).getProductId())
			{
				localbasket.getCustomerOrderLine().remove(i);
			}
		}
	}

	@Override
	public ArrayList<CustomerOrderLine> products() {
		ArrayList<CustomerOrderLine> POL = localbasket.getCustomerOrderLine();
		if(POL == null)
		{
			return new ArrayList<CustomerOrderLine>();
		}
		return POL;
	}
}
