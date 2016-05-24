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
<title>Polls - Detail</title>
</head>


<body>


<div style="text-align: right">
  <a href="main.jsp">Polls - Open</a> | 
  <a href="pollsSummary.jsp">Polls - Summary</a> | 
  <a href="pollsCreateNew.jsp">Polls - Create New</a> | 
  <a href="pollsModify.jsp">Polls - Modify</a> | 
  <a href="userCreateNew.jsp">User - Create New</a> | 
  <a href="userModify.jsp">User - Modify</a> | 
  <a href="logout.jsp">Logout</a>
</div>


<h1>Polls - Detail</h1>

<%
/*
pollTitle
fullName
username (hidden)
	
creationDate
meetingLocation
meetingDescription
	
voterName *** added to xml **
	
meetingDateTimeID (hidden)
meetingDateTime  *** multiple selections
	
SUBMIT > pollsSummary.jsp

*/	
%>	

<form action="pollsSummary.jsp" method="POST">

<input name="username" type="hidden">
<input name="meetingDateTimeID" type="hidden">

<table border="1">
  <tr><td>Poll Title</td><td></td></tr>
  <tr><td>Full Name</td><td></td></tr>
  <tr><td>Creation Date</td><td></td></tr>
  <tr><td>Meeting Location</td><td></td></tr>
  <tr><td>Meeting Description</td><td></td></tr>
</table>
<p></p>
<table border="1">
  <tr><td>Enter your name to vote:</td><td><input name="voterName" type="text"></td></tr>
</table>
<p></p>

<table border="1">
  <tr>
    <th>Meeting Date Time</th> 
    <th>Vote</th> 
  </tr>
  <tr>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td colspan="2"><input value="Submit" type="submit"></td> 
  </tr>
</table>

</form>

</body>
</html>




