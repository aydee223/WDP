<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="uts.polsys.*" %>

<% String filePath = application.getRealPath("WEB-INF/polling.xml"); %>
<jsp:useBean id="polSysApp" class="uts.polsys.PolSysApp" scope="application">
    <jsp:setProperty name="polSysApp" property="filePath" value="<%=filePath%>"/>
</jsp:useBean>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User - Create New</title>
</head>


<body>


<div style="text-align: right">
  <a href="main.jsp">Polls - Open</a> | 
  <a href="pollsSummary.jsp">Polls - Summary</a> | 
  <a href="pollsCreateNew.jsp">Polls - Create New</a> | 
  <a href="pollsModify.jsp">Polls - Modify</a> | 
  <a href="userModify.jsp">User - Modify</a> | 
  <a href="logout.jsp">Logout</a>
</div>


<h1>User - Create New</h1>

<%
/*
username
fullName
password

Create > pollsSummary.jsp

*/	
%>	

<form action="pollsSummary.jsp" method="POST">
<table>
  <tr><td>FullName</td><td><input name="fullName" type="text"></td></tr>
  <tr><td>Username</td><td><input name="username" type="text"></td></tr>
  <tr><td>Password</td><td><input name="password" type="password"></td></tr>
  <tr><td></td><td><input value="Create" type="submit"></td></tr>
</table>
</form>

</body>
</html>




