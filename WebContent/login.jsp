<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<form action="LoginRegister"method="post">
<table style="background-color:lightgreen;margin-left:20px;">
<tr><td style="text-align:center;"><h3 style="color:red;">Login Page !!!!</h3></td></tr>
<tr><td>
<h3>${message}</h3>
<h3 style="color:green;">${successMessage}</h3>
</td></tr>
<tr><td>USERNAME:</td><td><input type="text"name="username"placeholder="username"></td></tr>
<tr><td>PASSWORD:</td><td><input type="password"name="password1"placeholder="password"></td></tr>
<tr><td><input type="submit"name="submit"value="login"></td><td><a href="register.jsp">Register</a></td></tr>
</table>
</form>
</body>
</html>