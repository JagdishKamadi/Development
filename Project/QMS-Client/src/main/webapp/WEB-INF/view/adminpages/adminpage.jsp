<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" xml:lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Admin Operation</title>
</head>
<body>
<h1>Welcome Admin</h1>

<form action= "/adminquiz/operation">
    Choose the following option:&nbsp;
    <select name="optionchoice">
            <option value=1>Add new question</option>
            <option value=2>Remove question</option>
            <option value=3>Update question</option>
            <option value=4>To see all question </option>
          
    </select>
    <br/><br/>
    <input type="submit" value="Submit" />
</form>
<br>
<br>
<span class="loginlogoutlink">
   <a title="Log Out" class="loginlogoutlink-logout" href="http://localhost:8080/">Log Out</a>
</span>



</body>
</html>