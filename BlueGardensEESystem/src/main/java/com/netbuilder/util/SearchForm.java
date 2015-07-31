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
			String inStock = request.getParameter("outstock");
			boolean stock = Boolean.parseBoolean(inStock);
			//String outStock = request.getParameter("outstock");
			
			/**
			 * Get writer used on webpage
			 */
			PrintWriter display =  response.getWriter();
			
			/**
			 * Call Search controller
			 */
			SearchController sc = new SearchController(id, pName, stock);
			
			/**
			 * setup display of acknowledgement of search being made
			 */
			String htmlResponse = "<html>";
			htmlResponse += "<h2>Search results returned with " + "</h2>" + "<div id= productgrid >" + "<div class=section group>";
			htmlResponse += "<div class=<col span_1_of_4>" + "<p>Result 1</p>" + "<hr/> <br/> <div class=description>"; 
			htmlResponse += "<img src= #'{SearchController.pResult.getImageLink()}' width='128' height='128'/>";
			htmlResponse += "<h2><h:outputLabel value='#{SearchController.pResult.getProductSeasonalName()}'/></h2>";
			htmlResponse += "</div></html>";
			
			/**
			 * Display the amended HTML code
			 */
			display.println(htmlResponse);

		}

	
}
