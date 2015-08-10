package com.netbuilder.controllers;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

import com.netbuilder.entities.CustomerLogin;
import com.netbuilder.util.LoginUtils;
import com.netbuilder.util.PasswordReset;

/**
 * @author jmander
 **/

@Named
@Dependent
public class PasswordResetController {
	// @Inject
	private CustomerLogin customerLogin;
	// @Inject
	private PasswordReset passwordReset;
	public String errormsg;

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String passwordReset() {
		if (passwordReset.getNewPassword() != passwordReset
				.getConfirmNewPassword()) {
			errormsg = "Passwords do not match";
			return "passwordReset";
		}
		try {
			customerLogin.setCustomerPassword(LoginUtils.hash(
					passwordReset.getNewPassword(), customerLogin.getSalt()));
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return "login";
	}
}
