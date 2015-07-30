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
	private String username;
	private String password;
	public String errormsg;
	
	public LoginController(){
		ud = new UserDetails();
	}
	
	public LoginController(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public void setUsername(String username) {
		System.out.println(username);
		this.username = username;
	}
	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		System.out.println(password);
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
		
	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String login(String password, String username) {
		Long uid;
		this.password = password;
		this.username = username;
		
		System.out.println(username);
		System.out.println(password);
		
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