<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 4 MVC -HelloWorld</title>
</head>
<body>

	<fieldset>
		
	<legend>Customer Search:</legend>
		
	<form method="get" action="customer" >
	  	<input name="id" title="ID" value="" size="30" maxlength="2048" />
	  	<input type="submit" value="     Search by ID     " width="100">
	</form>
	
	<br/><br/>
	
	<form method="get" action="customer" >
		<input name="username" title="Username" value="" size="30" maxlength="2048" />
	  	<input type="submit" value="Search by username" maxlength="100">
	</form>
	
	</fieldset>
	
	<br/><br/>
	
	<a href="basket?id=1">Basket</a>

</body>
</html>