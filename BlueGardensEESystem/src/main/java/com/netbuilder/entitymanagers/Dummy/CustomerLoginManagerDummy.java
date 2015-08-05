package com.netbuilder.entitymanagers.Dummy;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.netbuilder.entities.CustomerLogin;
import com.netbuilder.entitymanagers.CustomerLoginManager;
import com.netbuilder.util.DummyData;

@Alternative
public class CustomerLoginManagerDummy implements CustomerLoginManager {

	@Inject
	private DummyData dd;
	
	public void persistCustomerLogin(CustomerLogin customerLogin) {

	}

	public long checkDetails(String inUsername, byte[] inPassword){
		for(CustomerLogin cl : dd.getCustomerLogins())
		{
			if (cl.getCustomerUsername()==inUsername)
				return cl.getCustomerID();
		}	
		return 0;
	}

	public long checkCustomerID(String inUsername) {
		for(CustomerLogin cl : dd.getCustomerLogins())
		{
			if (cl.getCustomerUsername().equals(inUsername)){
				return cl.getCustomerID();
			}
		}	
		return 0;
	}

	public String getCustomerUsername(String inUserEmail) {
		for(CustomerLogin cl : dd.getCustomerLogins()){
			if(cl.getCustomerEmail() == inUserEmail){
				return cl.getCustomerUsername();
			}
		}
		return null;
	}

	public byte[] getCustomerSalt(String inUsername) {
		for(CustomerLogin cl : dd.getCustomerLogins()){
			if(cl.getCustomerUsername() == inUsername){
				return cl.getSalt();
			}
		}
		return null;
	}

}
