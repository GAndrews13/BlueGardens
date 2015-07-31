package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.CustomerLogin;
import com.netbuilder.entitymanagers.CustomerLoginManager;
import com.netbuilder.util.LoginUtils;
@Alternative
public class CustomerLoginManagerDummy implements CustomerLoginManager {
private ArrayList<CustomerLogin> customerLogins = new ArrayList<CustomerLogin>();

	public CustomerLoginManagerDummy()
	{
		customerLogins.add(new CustomerLogin(1, "root","password",LoginUtils.getNextSalt()));
		customerLogins.add(new CustomerLogin(2, "docker","linux",LoginUtils.getNextSalt()));
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

	@Override
	public byte[] getCustomerSalt(String inUsername) {
		for(int i = 0;i<customerLogins.size();i++)
		{
			CustomerLogin cl = customerLogins.get(i);
			if(cl.getCustomerUsername() == inUsername)
			{
				return cl.getSalt();
			}
		}
		return null;
	}

	@Override
	public void persistCustomerLogin(CustomerLogin customerLogin) {
		customerLogins.add(customerLogin);
	}

}
