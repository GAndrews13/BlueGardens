package com.netbuilder.util;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;
/**
 * @author jmander
 **/
@Named
@SessionScoped
public class PasswordReset {
	private String newPassword;
	private String confirmNewPassword;
	
	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}

	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}	
	
	public PasswordReset(String newPassword, String confirmNewPassword) {
		this.newPassword = newPassword;
		this.confirmNewPassword = confirmNewPassword;
	}
	
}