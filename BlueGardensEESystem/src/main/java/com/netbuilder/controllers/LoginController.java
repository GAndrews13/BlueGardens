package com.netbuilder.controllers;

/**
 * @Author GAndrews 
 */


import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.auth.login.LoginException;

import com.netbuilder.entitymanagers.CustomerLoginManager;
import com.netbuilder.util.LoginUtils;
import com.netbuilder.util.UserDetails;
@Named
@Dependent
public class LoginController {
	@Inject
	private CustomerLoginManager clm;
	//@Inject
	private UserDetails ud;
	public String errormsg;
	
	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String login() {
		Long uid;
		if (ud.getUsername().isEmpty() || ud.getPassword().isEmpty()) {
			errormsg = "please enter details";
			return "login";
		}
		try
		{
			uid = clm.checkDetails(ud.getUsername(), LoginUtils.hash(ud.getPassword(),ud.getSalt()));
			if(uid != null)
			{
				ud.setLoggedIn(true);
				return "account/uid";
			}
			else
			{
				errormsg = "Incorrect details";
				return "login";
			}
		}
		catch (Exception e)
		{

			
		}
		finally
		{
			errormsg = "Error logging in";
		}
		return "login";
	}
	
	public String logout() throws LoginException
	{
		//Slide 89?
		
		//loginContext.logout();
		ud.setLoggedIn(false);
		ud = null;
		return "home";
	}
	
	public String loggedInUserName()
	{
		if(ud.isLoggedIn())
		{
			return ud.getUsername();
		}
		else
		{
			return null;
		}
	}
}