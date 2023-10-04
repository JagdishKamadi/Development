<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test Live</title>
</head>
<body>

<h1> ${sectionname} Section</h1>


	<br>
	<br>

	<form action="/userquiz/submittest" >
	
	<table>
   <%! int i=0; %>
		<c:forEach items="${quizsection}" var="quiz">
			<tr>
				<td>
					<table>
						<tr>
							<td> <%=++i %>) ${quiz.questionDescription}</td>
						</tr>
						<tr>
							<td>A) <input type="radio" name="${quiz.questionId }"
								value="A" /> <label>${quiz.option1}</label></td>
						</tr>
						<tr>
							<td>B) <input type="radio" name="${quiz.questionId }"
								value="B" /><label>${quiz.option2}</label></td>
						</tr>
						<tr>
							<td>C) <input type="radio" name="${quiz.questionId }"
								value="C" /><label>${quiz.option3}</label></td>
						</tr>
						<tr>
							<td>D) <input type="radio" name="${quiz.questionId }"
								value="D" /><label>${quiz.option4}</label></td>

						</tr>
					</table>
				</td>
			</tr>
		</c:forEach>

	</table>
	<br>
	<button class="login-button" type="submit">Submit Test</button>
	</form>

</body>
</html>