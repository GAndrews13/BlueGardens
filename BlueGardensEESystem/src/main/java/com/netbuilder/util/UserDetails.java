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