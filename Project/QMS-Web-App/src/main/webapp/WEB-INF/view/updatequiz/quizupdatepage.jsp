<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<htmllang="en">
<head>
<meta charset="ISO-8859-1">
<title>Quiz Update Page</title>
</head>
<body>
<h2> Welcome Admin</h2>
<hr>
	<h4>Available questions</h4>
	<a href="/quizupdate/add">Add Question</a>
	<table border="1" style="width:100%">
	<caption></caption>
		<tr>
			<th>Question Id</th>
			<th>Question description</th>
			<th>Quiz Section</th>
		</tr>
		<core:forEach items="${questions}" var="question">
			<tr>
				<td>${question.questionId}</td>
				<td>${question.questionDescription}</td>
	             <td>${question.sectionTag} </td>
	             <td>
                    <a
                        href="/quizupdate/view?questionid=${question.questionId}">View
                            question</a>
                    </td>
				<td>
				<a
					href="/quizupdate/edit?questionid=${question.questionId}">Edit
						question</a>
				</td>
				<td>
				<a
					href="/quizupdate/removequestion?questionid=${question.questionId}">Delete
						question</a></td>
			</tr>
		</core:forEach>
	</table>
	<br>
	<a href="/logout">Click Here to Logout</a>
</body>
</html>