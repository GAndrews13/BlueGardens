package com.netbuilder.entitymanagers.Dummy;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.netbuilder.entities.CustomerLogin;
import com.netbuilder.entitymanagers.CustomerLoginManager;
import com.netbuilder.util.DummyData;
import com.netbuilder.util.LoginUtils;

@Alternative
public class CustomerLoginManagerDummy implements CustomerLoginManager {

	@Inject
	private DummyData dd;

	public void persistCustomerLogin(CustomerLogin customerLogin) {
			dd.setCustomerLogin(customerLogin);
	}

	public long checkDetails(String inUsername, byte[] inPassword) {
		for (CustomerLogin cl : dd.getCustomerLogins()) {
			if (cl.getCustomerUsername() == inUsername)
				return cl.getCustomerID();
		}
		return 0;
	}

	public long checkCustomerID(String inUsername) {
		for (CustomerLogin cl : dd.getCustomerLogins()) {
			if (cl.getCustomerUsername().equals(inUsername)) {
				return cl.getCustomerID();
			}
		}
		return 0;
	}

	public String getCustomerUsername(String inUserEmail) {
		for (CustomerLogin cl : dd.getCustomerLogins()) {
			if (cl.getCustomerEmail().equals(inUserEmail)) {
				return cl.getCustomerUsername();
			}
		}
		return null;
	}

	public byte[] getCustomerSalt(String inUsername) {
		for (CustomerLogin cl : dd.getCustomerLogins()) {
			if (cl.getCustomerUsername().equals(inUsername)) {
				return cl.getSalt();
			}
		}
		return null;
	}

	@Override
	public ArrayList<CustomerLogin> findAll() {
		return dd.getCustomerLogins();
	}

	@Override
	public void updateCustomerPassword(long id, String password) {
		for (CustomerLogin cl : dd.getCustomerLogins()) {
			if (cl.getCustomerID() == id) {
				try {
					cl.setCustomerPassword(LoginUtils.hash(password,
							cl.getSalt()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
