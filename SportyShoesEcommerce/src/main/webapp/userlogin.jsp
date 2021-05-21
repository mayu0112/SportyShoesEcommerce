<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
<center>

<h2>User Login</h2>
<form method="post" action="validateuser">

	<table>
	<tr>
		<td><label>Enter User Name</label></td>
		<td><input type= "text" name="uName" /></td> 
	</tr>
	<tr>
		<td><label>Enter User Password</label></td>
		<td><input type="password" name="pwd" /></td>
	</tr>
	
</table>	
	<input type="submit" value="Sign In"/>
	<a href="usersignup.jsp">New User - Sign Up</a>
</form>
</center>

</body>
</html>