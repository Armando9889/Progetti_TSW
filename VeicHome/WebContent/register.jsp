<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*,it.unisa.model.bean.*"%>

<!DOCTYPE html>
<html lang="en">

<script type="text/javascript">
function validateForm(){
	let a=document.forms["myForm"]["name"].value;
	let b=document.forms["myForm"]["surname"].value;
	let c=document.forms["myForm"]["sesso"].value;
	let d=document.forms["myForm"]["indirizzo"].value;
	let e=document.forms["myForm"]["data"].value;
	let f=document.forms["myForm"]["password"].value;
	let g=document.forms["myForm"]["id"].value;
	if(a==""||b==""||c==""||d==""||e==""||f==""||g==""){
		alert("Inserire dati mancanti");
		return false;
	}
	
}

</script>

<head>
<link rel="stylesheet" type="text/css" href="ProductView.css">
<meta charset="ISO-8859-1">
<meta name="author" content="Michele Del Mastro">
<title>Store</title>


</head>
<body>
	<a href ="homeUfficiale.jsp">
	<img src = "images/VEICHOME (2)1 (1).png" alt = "Logo VeicHome">
	</a>
	
<%

		ProductCliente cl=new ProductCliente();
%>


<form action="<%=response.encodeURL("Register")%>" method="POST" name="myForm" onsubmit="return validateForm()">
			<fieldset>
				<legend><b>Registrazione</b></legend>
				
				<label for="id">codice-fiscale:</label>
				<input type="text" name="id" value="<%=cl.getCodice_fiscale() %>">
				
				<br><label for="name">nome:</label>
				<input type="text" name="name" value="<%=cl.getNome() %>">
				
				<br><label for="surname">cognome:</label>
				<input type="text" name="surname" value="<%=cl.getCognome() %>">
								
				<br><label for="sesso">sesso:</label>
				<input  name="sesso" type="text" maxlength="20" value="<%=cl.getSesso()%>">
				
				<br><label for="indirsizzo">indirizzo:</label>
				<input type="text" name="indirizzo" value="<%=cl.getIndirizzo() %>">
				
				<br><label for="data">data-di-nascita:</label>
				<input type="text" name="data" value="<%=cl.getData_di_nascita() %>">
				
				<br><label for="password">password:</label>
				<input type="text" name="password" value="<%=cl.getPassword() %>">
			<br>
				<input id = "ok" type="submit" name="ok" value="Ok">
				<input id = "reset" type="reset" value="Reset">
			</fieldset>
		</form>	
		

</body>
</html>