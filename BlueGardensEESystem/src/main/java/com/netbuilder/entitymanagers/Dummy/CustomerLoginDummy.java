package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;

import com.netbuilder.entities.CustomerLogin;
import com.netbuilder.entitymanagers.CustomerLoginManager;

public class CustomerLoginDummy implements CustomerLoginManager {
private ArrayList<CustomerLogin> customerLogins = new ArrayList<CustomerLogin>();

	public CustomerLoginDummy()
	{
		customerLogins.add(new CustomerLogin("root","password"));
		customerLogins.add(new CustomerLogin("docker","linux"));
	}

	public long checkDetails(String inUsername, String inPassword){
		for(int i = 0;i<customerLogins.size();i++)
		{
			CustomerLogin cl = customerLogins.get(i);
			if(cl.getCustomerUsername() == inUsername && cl.getCustomerPassword() == inPassword)
			{
				return cl.getCustomerID();
			}
		}
		return 0;
	}

	public long checkCustomerID(String inUsername) {
		for(int i = 0; i<customerLogins.size();i++)
		{
			if(customerLogins.get(i).getCustomerUsername() == inUsername)
			{
				return customerLogins.get(i).getCustomerID();
			}
		}
		return 0;
	}
}
