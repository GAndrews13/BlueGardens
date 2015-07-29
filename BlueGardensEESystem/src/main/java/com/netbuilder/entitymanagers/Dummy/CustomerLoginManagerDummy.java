package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;

import com.netbuilder.entities.CustomerLogin;
import com.netbuilder.entitymanagers.CustomerLoginManager;
import com.netbuilder.util.LoginUtils;
@Alternative
public class CustomerLoginManagerDummy implements CustomerLoginManager {
private ArrayList<CustomerLogin> customerLogins = new ArrayList<CustomerLogin>();

	public CustomerLoginManagerDummy()
	{
		try
		{
			byte[] tempSalt = LoginUtils.getNextSalt();
			customerLogins.add(new CustomerLogin("root",LoginUtils.hash("password",tempSalt),tempSalt));
			tempSalt = LoginUtils.getNextSalt();
			customerLogins.add(new CustomerLogin("docker",LoginUtils.hash("linux",tempSalt),tempSalt));
		}
		catch (Exception e)
		{
			//TODO add error handling
		}
	}

	public long checkDetails(String inUsername, byte[] inPassword){
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

	public ArrayList<String> findAll() {
		ArrayList<String> ra = new ArrayList<String>();
		for(int i = 0; i<customerLogins.size();i++)
		{
			ra.add(customerLogins.get(i).getCustomerUsername());
		}
		return ra;
	}

	@Override
	public String getCustomerUsername(String inUserEmail) {
		for(int i = 0; i<customerLogins.size();i++)
		{
			if(inUserEmail == customerLogins.get(i).getCustomerEmail())
			{
				return customerLogins.get(i).getCustomerUsername();
			}
		}
		return null;
	}
}
