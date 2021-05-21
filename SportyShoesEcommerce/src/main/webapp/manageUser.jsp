<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Manage Users</h1> <br>
<form method="get" action="listuser">
<h2>List Users</h2>	
	<input type="submit" value="Get Users List"/>
</form>


<form method="get" action="searchuser">
<h2>Search Specific User Details</h2>

	<table>
	<tr>
		<td><label>Enter User Name</label></td>
		<td><input type= "text" name="uName" /></td> 
	</tr>
	</table>	
	<input type="submit" value="Search User"/>
</form>

</body>
</html>