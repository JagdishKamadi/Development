<%-- <%@page import="com.epam.quiz.service.QuestionServiceImpl"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page import="java.util.List"%>
   <%@page import="com.epam.quiz.model.*"%>
   
<!DOCTYPE html>
<html lang="en" xml:lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Display question</title>
</head>
<body>
   <c:forEach var="item" items="${questionList}">
		<h4><c:out value="${item.questionId})   ${item.questionDescription}"></c:out></h4>
	</c:forEach>
</body>
</html>