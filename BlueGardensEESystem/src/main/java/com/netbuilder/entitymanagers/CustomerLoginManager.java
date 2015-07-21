package com.netbuilder.entitymanagers;
import com.netbuilder.entities.CustomerLogin;
import java.util.ArrayList;
/**
 * 
 * @author gandrews
 *
 */
public interface CustomerLoginManager {
	public long checkDetails(String inUsername, String inPassword);
	public long checkCustomerID(String inUsername);
	public ArrayList<String> findAll();
}
