package com.netbuilder.entitymanagers;
import com.netbuilder.entities.CustomerLogin;

/**
 * 
 * @author gandrews
 *
 */
public interface CustomerLoginManager {
	public long checkDetails(String inUsername, String inPassword);
	public long checkCustomerID(String inUsername);
}
