package com.netbuilder.controller.Dummy;

import java.util.ArrayList;

import javax.enterprise.inject.Alternative;

import com.netbuilder.model.CustomerLogin;
import com.netbuilder.controller.CustomerLoginManager;
import com.netbuilder.model.Utility.DummyData;
import com.netbuilder.model.Utility.LoginUtils;
import com.netbuilder.service.DummyDataLoader;

/**
 * @author gandrews
 * @author jmander
 * **/

@Alternative
public class CustomerLoginManagerDummy implements CustomerLoginManager {

	DummyData dd = new DummyData();

	public void persistCustomerLogin(CustomerLogin customerLogin) {
			DummyDataLoader.dd().setCustomerLogin(customerLogin);
	}

	public long checkDetails(String inUsername, byte[] inPassword) {
		for (CustomerLogin cl : DummyDataLoader.dd().getCustomerLogins()) {
			if (cl.getCustomerUsername() == inUsername)
				return cl.getCustomerID();
		}
		return 0;
	}

	public long checkCustomerID(String inUsername) {
		for (CustomerLogin cl : DummyDataLoader.dd().getCustomerLogins()) {
			if (cl.getCustomerUsername().equals(inUsername)) {
				return cl.getCustomerID();
			}
		}
		return 0;
	}

	public String getCustomerUsername(String inUserEmail) {
		for (CustomerLogin cl : DummyDataLoader.dd().getCustomerLogins()) {
			if (cl.getCustomerEmail().equals(inUserEmail)) {
				return cl.getCustomerUsername();
			}
		}
		return null;
	}

	public byte[] getCustomerSalt(String inUsername) {
		for (CustomerLogin cl : DummyDataLoader.dd().getCustomerLogins()) {
			if (cl.getCustomerUsername().equals(inUsername)) {
				return cl.getSalt();
			}
		}
		return null;
	}

	@Override
	public ArrayList<CustomerLogin> findAll() {
		return DummyDataLoader.dd().getCustomerLogins();
	}

	@Override
	public void updateCustomerPassword(long id, String password) {
		for (CustomerLogin cl : DummyDataLoader.dd().getCustomerLogins()) {
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
