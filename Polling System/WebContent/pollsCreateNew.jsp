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
<title>Polls - Create New</title>
</head>


<body>


<div style="text-align: right">
  <p><% System.out.println("session = " + session); %></p>

  <a href="main.jsp">Polls - Open</a> | 
  <a href="pollsSummary.jsp">Polls - Summary</a> | 
  <a href="pollsModify.jsp">Polls - Modify</a> | 
  <a href="userCreateNew.jsp">User - Create New</a> | 
  <a href="userModify.jsp">User - Modify</a> | 
  <a href="logout.jsp">Logout</a>
</div>



<h1>Polls - Create New</h1>

<%
/*
pollTitle
fullName
username (hidden)

creationDate
meetingLocation
meetingDescription
	
	
meetingDateTimeID (hidden)
meetingDateTime
	
SUBMIT > main.jsp
*/

%>	

<form action="main.jsp" method="POST">
<input name="username" type="hidden">
<input name="meetingDateTimeID" type="hidden">

<table border="1">
  <tr><td>Poll Title</td><td><input name="pollTitle" type="text"></td></tr>
  <tr><td>Full Name</td><td><input name="fullName" type="text"></td></tr>
  <tr><td>Creation Date</td><td><input name="creationDate" type="text"></td></tr>
  <tr><td>Meeting Location</td><td><input name="meetingLocation" type="text"></td></tr>
  <tr><td>Meeting Description</td><td><input name="meetingDescription" type="text"></td></tr>
  <tr><td>Meeting Date Time</td><td><input name="meetingDateTime" type="text"></td></tr>
  <tr><td colspan="6"><input value="Submit" type="submit"></td></tr>
</table>

</form>

</body>
</html>




