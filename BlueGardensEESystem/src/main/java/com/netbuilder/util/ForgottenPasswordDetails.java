package com.netbuilder.util;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 * @author jmander
 **/
@Named
@SessionScoped
public class ForgottenPasswordDetails {
	private String username;
	private String email;

	public ForgottenPasswordDetails(String username, String email) {
		this.username = username;
		this.email = email;
	}

	public String getUsername() { return username; }
	public String getEmail() { return email; }
	
	public void setUsername(String username) { this.username = username; }
	public void setEmail(String email) { this.email = email; }
}