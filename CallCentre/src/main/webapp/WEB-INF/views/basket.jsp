<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Basket</title>
</head>

<body>

	<center>
	
		<table>
			<tr>
				<th colspan="2">
					Customer Name: ${surName}, ${firstName}
				</th>
			</tr>
			<tr>
				<th colspan="2">
					Customer ID: ${customerID}
				</th>
			</tr>
			<tr>
				<th colspan="2">
					Customer Order ID: ${customerOrderID}
				</th>
			</tr>
		</table>
		
		<c:forEach items="${products}" var="product">
		<br/>
		<img src="${product.getImageLink()}" />
		    ${product.getProductID()}<br/>
		    ${product.getProductName()}<br/>
		    ${product.getStockLevel()}<br/>
		    ${product.getPrice()}<br/><br/><br/>
		</c:forEach>
		
	</center>
</body>
</html>