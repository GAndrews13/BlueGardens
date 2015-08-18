<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 4 MVC -HelloWorld</title>
</head>
<body>

<fieldset>
		
	<legend>Customer Registration:</legend>
		
	<form method="get" action="registeredCustomer" >
		First Name: <input name="firstName" title="firstName" value="" size="30" maxlength="2048" /><br/><br/>
	  	Last Name: <input name="lastName" title="lastName" value="" size="30" maxlength="2048" /><br/><br/>
	  	Username: <input name="username" title="username" value="" size="30" maxlength="2048" /><br/><br/>
	  	Password: <input name="password" type="password" title="password" value="" size="30" maxlength="2048" /><br/><br/>
	  	Confirm Password: <input name="confirmPassword" type="password" title="confirmPassword" value="" size="30" maxlength="2048" /><br/><br/>
	  	Email: <input name="email" title="email" value="" size="30" maxlength="2048" /><br/><br/>
	  	Confirm Password: <input name="confirmEmail" title="confirmEmail" value="" size="30" maxlength="2048" /><br/><br/>
	  	Address: <input name="address" title="address" value="" size="30" maxlength="2048" /><br/><br/>
	  	Contact Number: <input name="contactNumber" title="contactNumber" value="" size="30" maxlength="2048" /><br/><br/>
	  	<input type="submit" value=" Register Customer " width="100">
	</form>
	
	</fieldset>

</body>
</html>