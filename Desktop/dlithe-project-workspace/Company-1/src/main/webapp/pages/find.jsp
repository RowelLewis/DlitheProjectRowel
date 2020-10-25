<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find Employees</title>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0); %>
<div align="center">
<form action="getemp">
	Note:<br>
	Department Number: 1 -> Research Department,
					   4 -> Administration,
					   5 -> Headquaters .<br>
	Salary searches salary of employee greater than the entered value<br>
	super ssn: gives the employees who work for the entered ssn(the ssn of person who is supervisor is superssn)<br>
	ssn -> social security number<br>
	sex -> sorts according to gender of employee(m/f)
	<br><br>
	<table border="2" cellpadding="5" cellspacing="5">
	
	<tr><td><select name="type">
		<option value="1">Employee Id</option>
		<option value="2">Department Number</option>
		<option value="3">Salary</option>
		<option value="4">Sex</option>
		<option value="5">Super SSN</option>
	</select></td></tr>
	<br>
	<tr><td><input type="text" name="val" placeholder="Enter value the selcted type"></td></tr>
	<tr><td><input type="submit" value="Find"></td>
	<td><input type="reset" value="Clear"></td></tr>
	
	</table>
	
</form>
</div>
<div align="center">
<a href="back">Back To Home</a>
<a href="logout">Logout</a>
</div>
</body>
</html>