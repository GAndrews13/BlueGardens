package com.netbuilder.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entitymanagers.CustomerManager;

@Named
@RequestScoped
public class CustomerRegistrationController {
	@Inject
	private CustomerManager customerManager;
	
	public CustomerRegistrationController(){
	}

}
