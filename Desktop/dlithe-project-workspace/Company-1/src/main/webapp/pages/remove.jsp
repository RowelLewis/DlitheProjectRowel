<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deletinng</title>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0); %>
<div align="center">
${msg }
Enter Id of employee who is to be deleted
<form action="deletable">
<table border="4" cellspacing="4" cellpadding="4">
	
		<tr><td><input type="text" name="empid" placeholder="Enter Employee Id"></td></tr>
		<tr><td><input type="submit" value="Remove" ><input type="reset" value="clear"></td></tr>

</table>
</form>
</div>
<div align="center">
<a href="back">Back To Home</a>
<a href="logout">Logout</a>
</div>
</body>
</html>