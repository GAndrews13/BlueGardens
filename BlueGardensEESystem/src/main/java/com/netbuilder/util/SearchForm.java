package com.netbuilder.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netbuilder.controllers.SearchController;
/**
 * Servlet to connect search form to java controller
 * @author Jake
 *
 */
@WebServlet("/SearchServlet")
public class SearchForm extends HttpServlet 
{
	/**
	 * Called by the search form
	 */
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException 
		{
			/**
			 * Variables retrieved from form as strings and converted to types needed by the controller
			 */
			String pName = request.getParameter("productname");
			String pID = request.getParameter("productid");
			long id = Long.parseLong(pID);
			String inStock = request.getParameter("instock");
			boolean stock = Boolean.parseBoolean(inStock);
			//String outStock = request.getParameter("outstock");
			
			/**
			 * Get writer used on webpage
			 */
			PrintWriter display =  response.getWriter();
			
			/**
			 * setup display of acknowledgement of search being made
			 */
			String htmlResponse = "<html>";
			htmlResponse += "<h2>Search results returned with " + "</h2>";
			htmlResponse += "<div id= productgrid >";
			htmlResponse += "</html>";
			
			/**
			 * Call Search controller and display the amended HTML code
			 */
			SearchController sc = new SearchController(id, pName, stock);
			display.println(htmlResponse);

		}

	
}
