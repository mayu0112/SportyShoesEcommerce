<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Sign Up</title>
</head>
<body>


<center>

<h2>User Sign Up</h2>
<form method="post" action="usersignup">

	<table>
	<tr>
		<td><label>User Name</label></td>
		<td><input type= "text" name="signupName" /></td> 
	</tr>
	<tr>
		<td><label>Password</label></td>
		<td><input type="password" name="signupPass" /></td>
	</tr>
	<tr>
		<td><label>Email</label></td>
		<td><input type="text" name="signupEmail" /></td>
	</tr>
		<tr>
		<td><label>City</label></td>
		<td><input type="text" name="signupCity" /></td>
	</tr>

	
</table>	
	<input type="submit" value="Sign Up"/>
</form>
</center>


</body>
</html>