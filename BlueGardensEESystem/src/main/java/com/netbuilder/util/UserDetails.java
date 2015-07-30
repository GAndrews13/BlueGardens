package com.netbuilder.util;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;
// @Author Gareth
@Named
@SessionScoped
public class UserDetails {
	private String username;
	private String password;
	private int userID;
	private byte[] salt;
	private boolean loggedIn = false;
	
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

	public UserDetails(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public UserDetails(String username, String password, int userID)
	{
		this.username = username;
		this.password = password;
		this.userID = userID;
	}

	public UserDetails() {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}