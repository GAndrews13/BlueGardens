package com.netbuilder.controllers;

/**
 * @Author GAndrews
 * @author jmander 
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.netbuilder.entitymanagers.CustomerLoginManager;
import com.netbuilder.util.LoggedInUser;

@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController {
	@Inject
	private CustomerLoginManager clm;
	@Inject
	private LoggedInUser loggedInUser;
	public String username;
	private String password;
	private int userID;
	private byte[] salt;
	public boolean loggedIn = false;
	public String errormsg;

	public LoginController() {
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
		if (username.isEmpty() || password.isEmpty()) {
			errormsg = "please enter details";
			return "login";
		}
		try {
			if (clm.checkCustomerID(username) != 0) {
				setLoggedIn(true);
				loggedInUser.setUsername(username);
				loggedInUser.setUserID(clm.checkCustomerID(username));
				return "account";
			} else {
				errormsg = "Incorrect details";
				return "login";
			}
		} catch (Exception e) {
			errormsg = "Error logging in";
		}
		return "login";
	}

	public String loggedInUserName() {
		if (loggedIn) {
			return username;
		} else {
			return "Login";
		}
	}

	public void logOut() {
		setLoggedIn(false);
		username = null;
		password = null;
		loggedInUser.setUsername(null);
		loggedInUser.setUserID(clm.checkCustomerID(null));

		// Close the session
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
	}

	public String loggedOut() {
		if (username != null) {
			logOut();
		}
		if (loggedIn) {
			return "Log Out";
		} else {
			return "";
		}
	}
}