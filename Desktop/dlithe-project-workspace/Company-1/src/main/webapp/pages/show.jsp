<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employees</title>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0); %>
${msg }
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="rowel"%>
<div align="center">
<br>
<a href="back">Back To Home</a>
<a href="logout">Logout</a>
<br>
<br>
<table border="4" cellspacing="4" cellpadding="4">

	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>SSN</th>
		<th>Address</th>
		<th>DNO</th>
		<th>Salary</th>
		<th>Sex</th>
		<th>SuperSSN</th>
		<th>Modification</th>
	</tr>
	<rowel:forEach var="data" items="${all }">
	<tr>
		<td>${data.getEmpid() }</td>
		<td>${data.getEname() }</td>
		<td>${data.getSsn() }</td>
		<td>${data.getAddress() }</td>
		<td>${data.getDno() }</td>
		<td>${data.getSalary() }</td>
		<td>${data.getSex() }</td>
		<td>${data.getSuperssn() }</td>
	
	<td>
		<ol type="1">
			<li>	<a href="editable?empid=${data.getEmpid() }">Edit</a></li>
			<li>    <a href="deletable?empid=${data.getEmpid() }">Delete</a></li>
		</ol>
	</td></tr>
	</rowel:forEach>
</table>
</div>
</body>
</html>