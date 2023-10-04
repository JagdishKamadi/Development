<%@page import="java.util.List"%>
<%@page import="com.epam.quiz.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding the question</title>
</head>
<body>
<form action= "/quizupdate/updatequestion"  method="post">
		<div class="container">
			<!--Data or Content-->
			<div class="box-1"> 
				<div class="content-holder">

				</div>
			</div>

			<!--Forms-->
			<div class="box-2">
				<div class="login-form-container">
					<h1>Enter question details</h1>
					
			
					 Enter question id :
					<input type="text" class="input-field"
						name="questionid"  value= "${questionid}"   readonly> <br> <br>
					Question :  
					<input type="text" value=" ${question.questionDescription}" class="input-field"
						name="questionDescription" required="required" size="100" > <br> <br>
						
						A)  <input type="text" value=" ${question.option1}" class="input-field"
						name="option1" required="required"> <br> <br>
						
						B)  <input type="text"  value=" ${question.option2}"  class="input-field"
						name="option2" required="required"> <br> <br>
						
						C) <input type="text" value=" ${question.option3}" class="input-field"
						name="option3" > <br> <br>
						
					    D) <input type="text" value=" ${question.option4}" class="input-field"
						name="option4"  > <br> <br>
						
						<small>Enter option in the form of A,B,C,D</small><br>
						 <input type="text" value=" ${question.answer}" class="input-field"
						name="answer"   required="required"> <br> <br>
						
						Select section name:&nbsp;
						<select name="sectionName"  required="required" >
   						 <c:forEach items="${sectionnamelist}" var="each">
        				<option value="${each}">${each}</option>
    					</c:forEach>
						</select><br><br>
						
						Select question topic name:&nbsp;
						<select name="questiontopic"  required="required" >
   						 <c:forEach items="${questiontopicnamelist}" var="each">
        				<option value="${each}">${each}</option>
    					</c:forEach>
						</select><br><br>
		
						Select question difficulty :&nbsp;
						<select name="questiondifficulty"  required="required" >
   						 <c:forEach items="${questiondifficultynamelist}" var="each">
        				<option value="${each}">${each}</option>
    					</c:forEach>
						</select><br><br>
				        
						
						
					<button class="login-button" type="submit">Update Question</button>
				</div>
	</form>
</body>
</html>