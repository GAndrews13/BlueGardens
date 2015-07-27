package com.netbuilder.controllers;

import javax.inject.Inject;

import com.netbuilder.service.ContactEmail;
import com.netbuilder.util.ContactFormDetails;

/**
 * @author abalagel
 */
public class ContactController {
	@Inject
	private ContactEmail email;
	@Inject
	private ContactFormDetails cfd;
	public String errorMessage;
	
	public String sendMessage(){
		if (cfd.getName().isEmpty() || cfd.getEmail().isEmpty() || cfd.getMessage().isEmpty()) {
			errorMessage = "please enter details";
			return "ContactUs";
		}
		email.sendEmail(cfd.getName(), cfd.getEmail(), cfd.getMessage());
		return "LandingPage";
	}
	
}
