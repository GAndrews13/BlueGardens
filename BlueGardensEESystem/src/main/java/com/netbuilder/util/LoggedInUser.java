package com.netbuilder.util;

import javax.faces.bean.SessionScoped;
import javax.inject.Singleton;

@SessionScoped
@Singleton
public class LoggedInUser {

	private String username;
	private long userID;

	public long getUserID() { return userID; }
	public String getUsername() { return username; }
	
	public void setUserID(long userID) { this.userID = userID; }
	public void setUsername(String username) { this.username = username; }
}