<%@ page language="java" import="uts.polsys.User" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Testing Page</title>
</head>
<body>
	
	<% String filePath = application.getRealPath("WEB-INF/polling.xml"); %>
	<jsp:useBean id="polSysApp" class="uts.polsys.PolSysApp" scope="application">
		    <jsp:setProperty name="polSysApp" property="filePath" value="<%=filePath%>"/>
	</jsp:useBean>
	
	<%
		polSysApp.setFilePath(filePath);
//		out.println(polSysApp.test());
		//Polling pol = polSysApp.getPolling();
		for(User u: polSysApp.getUsers()){
			out.println("name " + u.getUserName());
		}
		
		polSysApp.voteOnPoll("1", "1");
		out.println("vote = " + polSysApp.getMeetingDateTime("1", "1").getVotes());
		
	%>
	asdf
</body>
</html>