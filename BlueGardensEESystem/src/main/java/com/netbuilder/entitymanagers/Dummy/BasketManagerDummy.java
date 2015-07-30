package com.netbuilder.entitymanagers.Dummy;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;

import com.netbuilder.entities.Basket;
import com.netbuilder.entities.Product;
import com.netbuilder.entities.ProductOrderLine;
import com.netbuilder.entitymanagers.BasketManager;


/**
 * @author abalagel
 * links interface with db
 */
@Default
public class BasketManagerDummy implements BasketManager,Serializable {
Basket localbasket = new Basket(0, null); 
	
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
		for(int i = 0;i<localbasket.getProductOrderLine().size();i++)
		{
			total+=localbasket.getProductOrderLine().get(i).getQuantity()*localbasket.getProductOrderLine().get(i).getProduct().getPrice(); 
		}
		return total;
	}
	
	/**
	 * @author GAndrews
	 */
	public void addProduct(Product inProduct,int inQuantity)
	{
		localbasket.getProductOrderLine().add(new ProductOrderLine(inProduct,inQuantity));
	}
	public void changeQuantity(Product inProduct,int inQuantity)
	{
		for(int i = 0;i<localbasket.getProductOrderLine().size();i++)
		{
			ProductOrderLine temp = localbasket.getProductOrderLine().get(i);
			if(inProduct.getProductID() == temp.getProduct().getProductID())
			{
				temp.setQuantity(inQuantity);
				localbasket.getProductOrderLine().set(i, temp);
			}
		}
	}
	
	public void removeProduct(Product inProduct)
	{
		for(int i = 0;i<localbasket.getProductOrderLine().size();i++)
		{
			if(inProduct.getProductID()==localbasket.getProductOrderLine().get(i).getProduct().getProductID())
			{
				localbasket.getProductOrderLine().remove(i);
			}
		}
	}

	@Override
	public ArrayList<ProductOrderLine> products() {
		ArrayList<ProductOrderLine> POL = localbasket.getProductOrderLine();
		if(POL == null)
		{
			return new ArrayList<ProductOrderLine>();
		}
		return POL;
	}
}
