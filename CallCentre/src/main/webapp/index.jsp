<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Call Centre Application</title>
</head>
<body>
  <h1>Add New Customer</h1>
  <form:form commandName="exercise">
    <table>
      <tr>
        <td>Name:</td>
        <td><input type="text"
            name="${}"
            value="$!" /></td>
      </tr>
      <tr>
        <td>Address:</td>
        <td><input type="text"
            name="${}"
            value="$!" /></td>
      </tr>
      <tr>
        <td>Email:</td>
        <td><input type= "text"
            name="${}"
            value="$!" /></td>
      </tr>
      <tr>
        <td>Phone Number:</td>
        <td><input type="text"
            name="${}"
            value="$!" /></td>
      </tr>
    </table>
  </form:form>
</body>
</html>
