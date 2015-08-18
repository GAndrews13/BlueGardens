<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Details</title>
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
</body>
</html>