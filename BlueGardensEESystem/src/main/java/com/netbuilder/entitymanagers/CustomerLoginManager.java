package com.netbuilder.entitymanagers;
import com.netbuilder.entities.CustomerLogin;

/**
 * 
 * @author gandrews
 *
 */
public interface CustomerLoginManager {
	public boolean checkUsername(String inUsername);
	public boolean checkPassword(String inPassword);
	public long checkDetails(String inUsername, String inPassword);
	public long checkCustomerID(String inUsername);
}
