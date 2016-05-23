<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login - Creator</title>
</head>
<body>

<div style="text-align: right">
  <a href="main.jsp">Polls - Open</a> | 
  <a href="pollsSummary.jsp">Polls - Summary</a> | 
  <a href="userCreateNew.jsp">User - Create New</a> | 
  <a href="logout.jsp">Logout</a>
</div>

<h1>Login - Creator</h1>

<form action="pollsSummary.jsp" method="POST">

<table>
  <tr><td>Username</td><td><input name="username" type="text"></td></tr>
  <tr><td>Password</td><td><input name="password" type="password"></td></tr>
  <tr><td></td><td><input value="Login" type="submit"></td></tr>
</table>
</form>


</body>
</html>