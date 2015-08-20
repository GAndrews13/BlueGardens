<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Customer Search: ${surName}, ${firstName} </title>
  <link href="resources/css/style.css" rel="stylesheet">
</head>

<body>
	<div class="site-header">
		<table>
			<tr>
				<th rowspan="2">
					<img src="resources/img/logo.png" alt="NB Gardens" width=180px height=90px />
				</th>
				<td width="80%">
					
				</td>
			</tr>
			<tr>
				<td width="100%">
					<ul class="menu">
						<li><a href="index" class="active"><span>Home</span></a></li>
						<li><a href="customerSearch"><span>Customer Search</span></a></li>
						<li><a href="customerPage"><span>Customer Page</span></a></li>
						<li><a href="basket"><span>Basket</span></a></li>
					</ul>
				</td>
				<td>
				</td>
			</tr>
		</table>
	</div>
	
	<div class="content" >
		<center>
			<h3>
				<a href="javascript:history.back()">Back</a>
			</h3>
			<table>
				<tr>
					<th colspan="2">
						Customer Name: ${surName}, ${firstName}
					</th>
				</tr>
				<tr>
					<th colspan="2">
						Status: ${accountStatus}
					</th>
				</tr>
				<tr>
					<td>
						Customer ID:
					</td>
					<td>
						${id}
					</td>
				</tr>
				<tr>
					<td>
						Email: 
					</td>
					<td>
						${email}
					</td>
				</tr>
				<tr>
					<td>
						Contact Number:  
					</td>
					<td>
						${contactNumber}
					</td>
				</tr>
				<tr>
					<td>
						Address: 
					</td>
					<td>
						${address}
					</td>
				</tr>
			</table>
		</center>
	</div>
	
  	<footer class="site-footer">
	  <div>
			<div>
				<ul class="bottommenu">
					
				</ul>
			</div>
		</div>
		<div class="center">
			2015 NBGardens.
			<a href="">Design by DelphiSoft Consulting</a> 
		</div>
	</footer>
</body>
</html>