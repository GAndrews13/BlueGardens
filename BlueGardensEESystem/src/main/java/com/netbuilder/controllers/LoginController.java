package com.netbuilder.controllers;

import javax.inject.Inject;
import javax.security.auth.login.LoginException;

import com.netbuilder.entitymanagers.CustomerLoginManager;
import com.netbuilder.util.UserDetails;

public class LoginController {
	@Inject
	private CustomerLoginManager clm;
	//@Inject
	private UserDetails ud;
	public String errormsg;
	
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
		return "account/uid";
	}
	
	public String logout() throws LoginException
	{
		//Slide 89?
		
		//loginContext.logout();
		ud = null;
		return "home";
	}
	
	public String loggedInUserName()
	{
		return ud.getUsername();
	}
}