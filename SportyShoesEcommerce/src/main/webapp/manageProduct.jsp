<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Manage PRODUCTS</h1> <br>

<form method="get" action="listProduct">
<h2>List Products</h2>	
	<input type="submit" value="Get Product List"/>
</form>


<form method="post" action="addProduct">
<h2>Add Product Details</h2>

	<table>
	<tr>
		<td><label>Enter Product Item Details</label></td>
		<td><input type= "text" name="item" /></td> 
	</tr>
		<tr>
		<td><label>Enter Product Category</label></td>
		<td><input type= "text" name="category" /></td> 
	</tr>
		<tr>
		<td><label>Enter Product Price</label></td>
		<td><input type="number" name="price" /></td> 
	</tr>
	</table>	
	<input type="submit" value="Add Product"/>
</form>


<form method="post" action="deleteProduct">
<h2>Delete Product from List</h2>

	<table>
	<tr>
		<td><label>Enter Product ID</label></td>
		<td><input type= "number" name="productid" /></td> 
	</tr>
	</table>	
	<input type="submit" value="Delete Product"/>
</form>
</body>
</html>