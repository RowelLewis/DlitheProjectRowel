<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0); %>
<div align="center">
	${msg }
	<br>
	<br>
	Login
	<br>
	<form action="home">
	<table>
		<tr><td><input type="text" name="username" placeholder="Username"></td></tr>
		<tr><td><input type="password" name="password" placeholder="password"></td></tr>
		
	</table>
	<br>
	<table>
		<tr><td><input type="submit" name="login" value="login"></td></tr>
	</table>
	</form>
</div>
</body>
</html>