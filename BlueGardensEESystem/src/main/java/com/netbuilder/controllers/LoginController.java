package com.netbuilder.controllers;

/**
 * @Author GAndrews 
 */


import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.auth.login.LoginException;

import com.netbuilder.entitymanagers.CustomerLoginManager;
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
		if (ud.getUsername().isEmpty() || ud.getPassword().isEmpty()) {
			errormsg = "please enter details";
			return "login";
		}
		Long uid = clm.checkDetails(ud.getUsername(), ud.getPassword());
		if(uid == null)
		{
			errormsg = "Incorrect details";
			return "login";
		}
		ud.setLoggedIn(true);
		return "account/uid";
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