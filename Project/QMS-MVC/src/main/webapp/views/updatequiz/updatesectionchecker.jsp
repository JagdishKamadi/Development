<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checking Section</title>
</head>
<body>
<h2>Enter section name to check weather it is exists or not</h2>
<form action="/sectionupdate/checksection" method="post">  
		 <input type = "text"  name="oldsectionname"  placeholder="Section Name" required="required">
		<br><br>
		<input type = "submit" value="Check Section">  
</form>
</body>
</html>