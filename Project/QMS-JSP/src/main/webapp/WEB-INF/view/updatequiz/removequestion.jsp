<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" xml:lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Deleting the question</title>
</head>
<body>
<h2>Enter question number to delete</h2>
<form action="/quizupdate/removequestion">  
		 <input type = "number"  name="questionid"  required="required">
		<br><br>
		<input type = "submit" value="Delete Question">  
</form>

</body>
</html>