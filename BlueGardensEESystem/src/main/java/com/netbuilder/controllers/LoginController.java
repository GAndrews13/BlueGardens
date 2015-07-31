package com.netbuilder.controllers;

/**
 * @Author GAndrews 
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.security.auth.login.LoginException;

import com.netbuilder.entitymanagers.CustomerLoginManager;
import com.netbuilder.util.LoginUtils;
import com.netbuilder.util.UserDetails;

@ManagedBean(name = "loginController")
@RequestScoped
public class LoginController {
	@Inject
	private CustomerLoginManager clm;
	//@Inject
	private UserDetails ud;
	private String username;
	private String password;
	private int userID;
	private byte[] salt;
	private boolean loggedIn = false;
	public String errormsg;
	
	public LoginController(){
	}
	
	public LoginController(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public byte[] getSalt() {
		return salt;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
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

	public String login() {
		Long uid;
		
		if (username.isEmpty() || password.isEmpty()) {
			errormsg = "please enter details";
			return "login";
		}
		try
		{
			uid = clm.checkCustomerID(username);
			System.out.println(uid);
			if(uid != null)
			{
				setLoggedIn(true);
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
			errormsg = "Error logging in";
		}
		
		System.out.println(username);
			return "login";
	}
	
	public String logout() throws LoginException
	{
		//Slide 89?
		
		//loginContext.logout();
		setLoggedIn(false);
		username = null;
		password = null;
		return "home";
	}
	
	public String loggedInUserName()
	{
		if(loggedIn)
		{
			return username;
		}
		else
		{
			return null;
		}
	}
}