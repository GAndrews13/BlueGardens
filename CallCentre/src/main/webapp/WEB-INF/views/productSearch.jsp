<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Search</title>
</head>
<body>
	<form>
		<input name="productName" title="productname" value=""/>
		<input type="submit" value = "Search by Product Name" />
	</form>
	<br/>
	<form>
		<input name="productID" title="productid" value=""/>
		<input type="submit" value = "Search by Product ID" />
	</form>
	<br />
	<hr />
	<br />
	<table>
		<tr>
			<td>Product Name</td>
			<td>Product Price (£)</td>
			<td>Product Stock Level</td>
			<td></td>
		</tr>
		<c:forEach items="${products}" var="product">
			<tr>
				<td>${product.getProductName()}</td>
				<td>${product.getPrice()}<br />
				<br />
				<br />
				</td>
				<td>${product.getStockLevel()}<br />
				</td>
				<td><a href="#"> Add to basket</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>