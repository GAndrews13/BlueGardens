package com.netbuilder.entitymanagers;
import java.util.ArrayList;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.CustomerLogin;
/**
 * 
 * @author gandrews
 *
 */
public interface CustomerLoginManager {
	public long checkDetails(String inUsername, byte[] inPassword);
	public long checkCustomerID(String inUsername);
	public ArrayList<String> findAll();
	public String getCustomerUsername(String inUserEmail);
	public byte[] getCustomerSalt(String inUsername);
	public void persistCustomerLogin(CustomerLogin customerLogin);
}
