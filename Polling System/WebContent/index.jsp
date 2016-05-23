<%@ page language="java" import = "uts.polsys.MeetingDateTime" import="uts.polsys.User" import="uts.polsys.Vote" contentType="text/html; charset=UTF-8"
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
		 
		//DISPLAY ALL USERS
		for(User u: polSysApp.getUsers()){
			out.println("<h1> " + u.getUserName()+"<br></h1>");
		}
		
		//DISPLAY ALL POLLS FOR OWNED BY THE FIRST USER AND THEIR RUNNING TIMES
		for(MeetingDateTime mdt : polSysApp.getPollVotingOptions("1")){
			out.println("<h2>Polltime = "+ mdt.getMeetingDateTime() + " Vote Count=" + mdt.getVoteCount() +"<br></h2>");
			for(Vote v : polSysApp.getMeetingDateTime("1", mdt.getId()).getVotes()){
				//DISPLAY THE PEOPLE THAT HAVE VOTEd
				out.println("<h3>" + v.getUserId()+"<br></h3>");
			}
		}
		
		polSysApp.voteOnPoll("1", "1", "Jane Mamble");
		
		/*out.println("vote = " + polSysApp.getMeetingDateTime("1", "1").getVoteCount()+"<br>");
		for(Vote v : polSysApp.getMeetingDateTime("1","1").getVotes() ){
			out.println(v.getUserId()+"<br>");
		}*/
		
	%>
	asdf
</body>
</html>