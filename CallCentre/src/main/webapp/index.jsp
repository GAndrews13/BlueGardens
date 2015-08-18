<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Call Centre Application</title>
  <link href="resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="site-header">
		<table>
			<tr>
				<th rowspan="2">
					<img src="resources/img/NB-Gardens.png" alt="NB Gardens" width=180px height=90px />
				</th>
				<td width="80%">
					
				</td>
				<td>
					<img src="" alt="Login"/>
				</td>
			</tr>
			<tr>
				<td width="100%">
					<ul class="menu">
						<li><a href="/index" class="active"><span><spring:message code="index.title"/></span></a></li>
						<li><a href="/customerSearch"><span><spring:message code="index.searchcustomer"/></span></a></li>
					</ul>
				</td>
				<td>
					<form target="paypal" action="https://www.paypal.com/cgi-bin/webscr" method="post">		  		
	   					<input type="hidden" name="business" value="garethedwardfrankandrews@hotmail.com"/>
		    					<input type="hidden" name="cmd" value="_cart"/>
	    				<input type="hidden" name="display" value="1"/>
	   					<input type="image" name="submit" src="https://www.paypalobjects.com/en_US/i/btn/btn_viewcart_LG.gif" alt="PayPal - The safer, easier way to pay online"/>
	   					<img alt="" border="0" width="1" height="1"     src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" />
					</form>
				</td>
			</tr>
		</table>
	</div>
  <a href="hello?name=Eric">Click Here</a>
  <a href="customerSearch">Customer Search</a>
  <br/><br/>
  <a href="customer?name=Eric">Customer</a>
</body>
</html>