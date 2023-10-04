<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html lang="en" xml:lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Quiz Test</title>
</head>
<body>

 <form align="right" name="form1" action="/user/logout">
  <label>
  <input name="submit2" type="submit" id="submit2" value="Log Out">
  </label>
</form>
	
Welcome ${username}
<form action="/userquiz/startquiz" method = "post">
<div style="text-align:center">
        <h1 style="color:green;">Welcome to Quiz Management System</h1>
        <br><br>
        <h4>Select the following section to give the test</h4>
       
		<!-- Select question difficulty :&nbsp; -->
						<select name="sectionname"  required="required" >
   						 <c:forEach items="${sectionlist}" var="each">
        				<option value="${each}">${each}</option>
    					</c:forEach>
						</select><br><br>
						<button class="login-button" type="submit">Attend Test</button>
								
</div>
   						 <h2>Note :</h2>
						<h3>No of question : 5</h3>
						<h3>1 question [easy/medium] : 1 mark</h3>
						<h3>1 question [hard]        : 2 mark</h3>
						<h3>No negative marking</h3>
   
</form>   

</body>
 
</html>