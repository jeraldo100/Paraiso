<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<h3 class="err-msg">${error}</h3>
<form action="auth" method="post">
	<label>Enter username : </label><input type="text" name="username"><br>
	<label>Enter password : </label><input type="password" name="password"><br>
	<input type="submit" value="Submit"><br>
</form>
<a href="register">Register</a>
</body>
</html>