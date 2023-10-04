<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" xml:lang="en">
<head>
<meta charset="ISO-8859-1">
<title>User Login Page</title>
</head>
<body>
   
	<form action="getlogindetails"  method="post">
		<div class="container">
			<!--Data or Content-->
			<div class="box-1">
				<div class="content-holder">
					<h2>Welcome to Quiz Application</h2>

				</div>
			</div>

			<!--Forms-->
			<div class="box-2">
				<div class="login-form-container">
					<h1>User Login</h1>
					<input type="text" placeholder="Username" class="input-field"
						name="username" required="required"> <br> <br> <input
						type="password" placeholder="Password" class="input-field"
						name="password" required="required"> <br> <br>
					<button class="login-button" type="submit">Login</button>
				</div>
	</form>
	<br>
	<button class="btn btn-lg btn-primary" id="submit" onclick="location.href ='userregister' " >Sign Up</button>
</body>
</html>