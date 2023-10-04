<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Updating Section Name</title>
</head>
<body>
<form action="/sectionupdate/updatesection" method="post">  
		Old section name :  <input type = "text"  name="oldsectionname"  value="${oldsectionname}" readonly="readonly">
		<br><br>
		
		New section name :  <input type = "text"  name="newsectionname" placeholder="Enter new section name" required="required"  >
		<br><br>
		<input type = "submit" value="Update Section Tag">  
</form>
</body>
</html>