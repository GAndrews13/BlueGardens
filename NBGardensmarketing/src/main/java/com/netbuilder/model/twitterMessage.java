package com.netbuilder.model;

import twitter4j.User;

public class twitterMessage {
	private String username;
	private String message;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public twitterMessage(String inUsername, String inMessage)
	{
		setUsername(inUsername);
		setMessage(inMessage);
	}
	public twitterMessage(User inUser, String inMessage)
	{
		setUsername(inUser.getName());
		setMessage(inMessage);
	}
}
