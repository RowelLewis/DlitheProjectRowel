<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0); %>
<div align="center">
${msg }

<%@ taglib prefix="com" uri="http://www.springframework.org/tags/form" %>
<com:errors path="employee.*"/>

<form action="change" method="post">
	<table>
		<tr><td><input type="text" name="empid" value="${one.getEmpid() }"></td></tr>
		<tr><td><input type="text" name="ename" value="${one.getEname() }"></td></tr>
		<tr><td><input type="text" name="ssn" value="${one.getSsn() }"></td></tr>
		<tr><td><input type="text" name="address"  value="${one.getAddress() }"></td></tr>
		<tr><td><input type="text" name="dno"  value="${one.getDno() }"></td></tr>
		<tr><td><input type="text" name="salary"  value="${one.getSalary() }"></td></tr>
		<tr><td><input type="text" name="sex"  value="${one.getSex() }"></td></tr>
		<tr><td><input type="text" name="superssn"  value="${one.getSuperssn() }"></td></tr>
		<tr>
			<td><input type="submit" value="Update"></td>
			<td><input type="reset" value="Clear"></td>
		</tr>
	</table>
</form>
</div>
<div align="center">
<a href="back">Back To Home</a>
<a href="logout">Logout</a>
</div>
	
</body>
</html>