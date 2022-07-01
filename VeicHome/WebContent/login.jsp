<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*,it.unisa.model.bean.*"%>




<!DOCTYPE html>
<html lang="en">
<head>

<script type="text/javascript">
function validateForm(){
	let a=document.forms["myForm"]["id"].value;
	let f=document.forms["myForm"]["sesso"].value;
	if(a==""||b==""){
		alert("Inserire dati mancanti");
		return false;
	}
	
}

</script>


<meta charset="ISO-8859-1">
<meta name="author" content="Michele Del Mastro">
<title>Store</title>

<link href="ProductView.css" rel="stylesheet" type="text/css">
</head>
<body>

	<a href ="homeUfficiale.jsp">
	<img src = "images/VEICHOME (2)1 (1).png" alt = "Logo VeicHome">
	</a>	


	<%
	ProductCliente cl = new ProductCliente();
	ProductImpiegato im = new ProductImpiegato();
	%>


	<form id = "frm" action="<%=response.encodeURL("ProductControl")%>" method="POST" name="myForm" onsubmit="return validateForm()">
			<input type="hidden" name="action" value="delete"> 
			<p id = "login">LOGIN </p>
			<label for="id">Username:</label>
				<br> 
				<input type="text" name="id" value="<%=cl.getNome()%>"  value="<%=im.getNome()%>"> 
				<br>
			<label for="sesso">Password:</label>
			<br> 
			<input name="sesso" type="password" maxlength="20" value="<%=cl.getPassword()%>"
				value="<%=im.getPassword()%>"> <!-- si deve mettere input name e type password -->
				<br><br> 
				<input id ="ok" type="submit" name="ok" value="Ok"> &nbsp 
				<input id = "reset" type="reset" value="Reset">
	</form>








</body>
</html>