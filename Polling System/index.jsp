<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="uts.wsd.*" %>

<% String filePath = application.getRealPath("WEB-INF/users.xml"); %>
<jsp:useBean id="pollApp" class="uts.wsd.PollApplication" scope="application">
    <jsp:setProperty name="pollApp" property="filePath" value="<%=filePath%>"/>
</jsp:useBean>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Polls - Open</title>
</head>


<body>


<div style="text-align: right">
  <a href="pollsSummary.jsp">Polls - Summary</a> | 
  <a href="pollsCreateNew.jsp">Polls - Create New</a> | 
  <a href="pollsModify.jsp">Polls - Modify</a> | 
  <a href="userCreateNew.jsp">User - Create New</a> | 
  <a href="userModify.jsp">User - Modify</a> | 
  <a href="login.jsp">Login</a> | 
</div>


<h1>Polls - Open</h1>

<%
/*
pollTitle > pollsDetail.jsp
fullName
username (hidden)

*/
%>	

<form>
<table border="1">
  <tr>
    <th>Poll Title</th>
    <th>Full Name</th> 
  </tr>
  <tr>
    <td><a href="pollsDetail.jsp"></a></td>
    <td></td> 
  </tr>
</table>

</form>

</body>
</html>




