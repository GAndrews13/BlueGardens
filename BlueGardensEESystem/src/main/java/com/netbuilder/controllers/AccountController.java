package com.netbuilder.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.netbuilder.entities.Customer;
import com.netbuilder.entitymanagers.ProductOrderLineManager;
import com.netbuilder.entitymanagers.WishListManager;

@Named
@RequestScoped
public class AccountController 
{
	@Inject
	private Customer cust;
	private WishListManager wishListManager;
	private ProductOrderLineManager colm;
}
