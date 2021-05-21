<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="salesProduct">
<h1>PRODUCT HOME PAGE</h1>


	<div id="box2" class="col-lg-8">
		<h1>Product list</h1>
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Item Details</th>
					<th>Category</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
	<%

	java.sql.Connection con;
	Class.forName("com.mysql.cj.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","Chauhan@83");
    Statement st=con.createStatement();
    ResultSet rs=st.executeQuery("select * from product");

    while(rs.next())
    {
    	%>		
				<tr>
					<td><%=rs.getString("id") %></td>
					<td><%=rs.getString("item") %></td>
					<td><%=rs.getString("category") %></td>
					<td><%=rs.getString("price") %></td>
				</tr>

	<%} %>
			</tbody>
		</table>
	</div>

	<table>
	<tr>
		<td><label>Enter Product ID to Buy</label></td>
		<td><input type="number" name="id" /></td> 
	</tr>
	</table>	
	<input type="submit" value="Buy"/>
</form>
</body>
</html>