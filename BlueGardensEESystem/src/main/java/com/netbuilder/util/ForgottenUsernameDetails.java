package com.netbuilder.util;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 * @author jmander
 **/
@Named
@SessionScoped
public class ForgottenUsernameDetails {
	private String email;

	public ForgottenUsernameDetails(String email) { this.email = email; }

	public String getEmail() { return email; }

	public void setEmail(String email) { this.email = email; }
}