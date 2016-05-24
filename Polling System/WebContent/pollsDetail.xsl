<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">


	<xsl:template match="/">
		<!-- TODO: Auto-generated template -->
		<html>
 		  <head>
  		    <style>
   		      
  		    </style>
 		  </head>
 		  <body>
		    <table border="1">
			  <xsl:apply-templates/>
			</table>
 		  </body>
		</html>
	</xsl:template>


<!-- 
pollTitle
fullName
username (hidden)
	
creationDate
meetingLocation
meetingDescription
	
voterName *** added to xml **
	
meetingDateTimeID (hidden)
meetingDateTime  *** multiple selections

-->

<xsl:template match="user">
  <p>
  <xsl:apply-templates select="meetings/meeting/pollTitle"/>
  <xsl:apply-templates select="fullName"/>
  <xsl:apply-templates select="meetings/meeting/creationDate"/>
  <xsl:apply-templates select="meetings/meeting/meetingLocation"/>
  <xsl:apply-templates select="meetings/meeting/meetingDescription"/>
  <xsl:apply-templates select="meetings/meeting/meetingDateTime/meeting/voters/voterName"/>
  <xsl:apply-templates select="meetings/meeting/meetingDateTime/meeting/meetingDateTime"/>
  </p>
</xsl:template>



<xsl:template match="meetings/meeting/pollTitle">
  <tr><td>Poll Title:</td><td><xsl:value-of select="."/></td></tr>
</xsl:template>

<xsl:template match="fullName">
  <tr><td>Full Name:</td><td><xsl:value-of select="."/></td></tr>
</xsl:template>

<xsl:template match="meetings/meeting/creationDate">
  <tr><td>Creation Date:</td><td><xsl:value-of select="."/></td></tr>
</xsl:template>

<xsl:template match="meetings/meeting/meetingLocation">
  <tr><td>Meeting Location:</td><td><xsl:value-of select="."/></td></tr>
</xsl:template>

<xsl:template match="meetings/meeting/meetingDescription">
  <tr><td>Meeting Description:</td><td><xsl:value-of select="."/></td></tr>
</xsl:template>


<xsl:template match="meetings/meeting/meetingDateTime/meeting/voters/voterName">
  <tr><td colspan="2">
  
  	<table border="1">
	  <tr>
	    <td>Enter your name to vote: </td>
	    <td><input name="voterName" type="text"/></td>
	  </tr>
	</table>
  
  </td></tr>
</xsl:template>


<xsl:template match="meetings/meeting/meetingDateTime/meeting/meetingDateTime">
  <tr><td colspan="2">

	<table border="1">
	  <tr>
	    <th>Meeting Date Time</th> 
	    <th>Vote</th> 
	  </tr>
	  <tr>
	    <td><xsl:value-of select="."/></td>
	    <td><input type="checkbox" name="vote" value="vote"/></td>
	  </tr>
	</table>

  
  </td></tr>
</xsl:template>






</xsl:stylesheet>