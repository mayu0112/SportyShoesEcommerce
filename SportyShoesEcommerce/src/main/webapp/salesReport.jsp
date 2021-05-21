<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sales Report</title>
</head>
<body>
<form method="get" action="salesReport" >
<h1>Sales Report for Admin Only</h1>
  Select Sales Report Filter:
  <select name="filter">
    <option value="all">All</option>
    <option value="date">Date</option>
    <option value="category">Category</option>
  </select> <br><br>
  Enter filter criteria details (if Applicable):<br>
  <input type= "text" name="details" /><br>
  <input type="submit" value="Display Sales Report">
</form>
</body>
</html>