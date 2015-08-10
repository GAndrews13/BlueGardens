package com.netbuilder.service;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.netbuilder.controllers.ProductController;
import com.netbuilder.controllers.SearchController;
import com.netbuilder.entities.Product;

@WebServlet(name="/specificProduct")
public class SpecificProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductController productController;
	private SearchController searchController;
	
	protected void doPost(HttpServletRequest request) {
		String link;
		for(Product p : searchController.getResults()) {
			link = request.getParameter("#{product.getImageLink()}");
			if(link==p.getImageLink())
				productController.search();
		}
	}
}