package com.netbuilder.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.junit.runner.Request;

import com.netbuilder.entities.Product;
import com.netbuilder.entitymanagers.ProductManager;


@Named
@RequestScoped
public class ProductController {
	
	@Inject
	private ProductManager productmanager;
	
	public Product product;
	
	//find product details by the findById(id) where the id is the specific product id.
	
	private String id =product.getImageLink().getPathInfo();
	
	public ProductController() {
		product = productmanager.findById(id);	
	}
}
