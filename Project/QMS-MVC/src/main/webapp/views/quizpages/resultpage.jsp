<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result Page</title>
</head>
<body>

 

 <center>
        <h2  style="color:green;">Section Name : ${sectionname}</h2>
        <br><br>
        <h3>Your score :  ${score}</h4>
        
        
         <span class="loginlogoutlink">
   				<a title="Log Out" class="loginlogoutlink-logout" href="http://localhost:8080/">Attend Test Again</a>
		</span>			
    </center>


</body>
</html>