<%@page import="java.util.List"%>
<%@page import="com.epam.quiz.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" xml:lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Adding the question</title>
</head>
<body>

		<div class="container">
			<!--Data or Content-->
			<div class="box-1">
				<div class="content-holder">

				</div>
			</div>

			<!--Forms-->
			<div class="box-2">
				<div class="login-form-container">
					<h1> Question details</h1>


             Enter question id :
            <input type="text" class="input-field"
                name="questionId"  value= "${question.questionId}"   readonly> <br> <br>
            Question :
            <input type="text" value=" ${question.questionDescription}" class="input-field"
                 size="100" readonly> <br> <br>

                A)  <input type="text" value=" ${question.option1}" class="input-field"
                  readonly> <br> <br>

                B)  <input type="text"  value=" ${question.option2}"  class="input-field"
                 required="required" readonly> <br> <br>

                C) <input type="text" value=" ${question.option3}" class="input-field"
                readonly > <br> <br>

                D) <input type="text" value=" ${question.option4}" class="input-field"
                readonly  > <br> <br>


                Answer :  <input type="text" value=" ${question.answer}" class="input-field"
                readonly> <br> <br>

                Section :  <input type="text" value=" ${question.sectionTag}" class="input-field"
                readonly> <br> <br>

                TopicTag :  <input type="text" value=" ${question.section.topicTag}" class="input-field"
                readonly> <br> <br>

                DifficultTag :  <input type="text" value=" ${question.section.difficultyTag}" class="input-field"
                readonly> <br> <br>


				</div>

</body>
</html>