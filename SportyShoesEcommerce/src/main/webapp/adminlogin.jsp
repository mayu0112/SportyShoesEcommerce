<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IAdmin Login</title>
</head>
<body>


<h2>Admin Login</h2>
<form method="post" action="adminlogin">

	<table>
	<tr>
		<td><label>Enter Admin Name</label></td>
		<td><input type= "text" name="adminName" /></td> 
	</tr>
	<tr>
		<td><label>Enter Admin Password</label></td>
		<td><input type="password" name="adminPass" /></td>
	</tr>
	
</table>	
	<input type="submit" value="Login"/>
</form>


<h2>Admin Password Change</h2>
<form method="post" action="changePass">

	<table>
	<tr>
		<td><label>Enter Admin new password</label></td>
		<td><input type= "text" name="newPass" /></td> 
	</tr>
	
</table>	
	<input type="submit" value="Change Password"/>
</form>

</body>
</html>