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
<title>Polls - Summary</title>
</head>

<body>

<%
/*
pollTitle
fullName
username (hidden)
	
creationDate
meetingLocation
meetingDescription
	
voterName *** added to xml **
	
meetingDateTimeID
meetingDateTime *** multiple selections
	
*/
%>	


<p><% System.out.println("session = " + session); %></p>

<%
String username = request.getParameter("username");
String password = request.getParameter("password");

Polling users = polSysApp.getPolling();
User user = users.login(username, password);

//System.out.println("username = " + username + " | password = " + password + " | userId = " + user.getUserId());
System.out.println("users = " + users);
System.out.println("user = " + user);


if (user != null) { // the login was successful
	session.setAttribute("user", user);

%>

<div style="text-align: right">

  <a href="main.jsp">Polls - Open</a> | 
  <a href="pollsCreateNew.jsp">Polls - Create New</a> | 
  <a href="pollsModify.jsp">Polls - Modify</a> | 
  <a href="userCreateNew.jsp">User - Create New</a> | 
  <a href="userModify.jsp">User - Modify</a> | 
  <a href="logout.jsp">Logout</a>
</div>

<h1>Polls - Summary</h1>


<form>

<select>
  <option value="pollTitle">Poll Title</option>
</select>

<p>Voter Name: <input name="voterName" type="text"></p>

<table border="1">
  <tr><td>Full Name</td><td></td></tr>
  <tr><td>Creation Date</td><td></td></tr>
  <tr><td>Meeting Location</td><td></td></tr>
  <tr><td>Meeting Description</td><td></td></tr>
</table>
<p></p>

<table border="1">
  <tr>
    <th>Meeting Date Time</th> 
    <th>Number of Votes</th> 
  </tr>
  <tr>
    <td></td>
    <td></td>
  </tr>
</table>

<% } else { %>
	<p>Incorrect username/password.</p>
	<p>Click <a href="login.jsp">here</a> to try again.</p>
<% } %>

</form>

</body>
</html>
