<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter Employee Details</title>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0); %>
<div align="center">
${msg }

<br>
Enter Employee details
<br>
<%@ taglib prefix="com" uri="http://www.springframework.org/tags/form" %>
<com:errors path="employee.*"/>

<form action="newemployee" method="post">
<table>
<tr><td><input type="text" name="ename" placeholder="Employee Name"></td></tr>
<tr><td><input type="text" name="ssn" placeholder="Social Security number"></td></tr>
<tr><td><input type="text" name="address" placeholder="Address"></td></tr>
<tr><td><input type="text" name="dno" placeholder="Department Number"></td></tr>
<tr><td><input type="text" name="salary" placeholder="Salary"></td></tr>
<tr><td><input type="text" name="sex" placeholder="Sex"></td></tr>
<tr><td><input type="text" name="superssn" placeholder="Supervisor's SSN"></td></tr>
<tr>
<td><input type="submit" value="Insert"></td>
<td><input type="reset" value="Clear"></td>
</tr>
</table>
</form>

<a href="back">Back To Home</a>
<a href="logout">Logout</a>
</div>
</body>
</html>