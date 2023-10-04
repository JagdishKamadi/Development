<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Section Page</title>
</head>
<body>
<% if(session.getAttribute("USERNAME")==null){
%>
<h2>Select below section</h2>
<form action="/quizupdate/getsectionpage" >
<select name="sectionname"  required="required" >
	Select section name:&nbsp;
   						 <c:forEach items="${sectionnamelist}" var="each">
        				<option value="${each}">${each}</option>
    					</c:forEach>
						</select><br><br>
						<button class="login-button" type="submit">Show Section</button>

<%} else { %>
 <h2> Something went wrong</h2>
   <h3> You are log out</h3>
<%} %>
</html>