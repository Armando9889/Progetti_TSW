<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*,it.unisa.model.bean.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" type="text/css" href="ProductView.css">
<meta charset="ISO-8859-1">
<meta name="author" content="Michele Del Mastro">
<title>Store</title>

<script type="text/javascript">
function validateForm(){
	let a=document.forms["myForm"]["targa"].value;
	let b=document.forms["myForm"]["codice_telaio"].value;
	let c=document.forms["myForm"]["colore"].value;
	let d=document.forms["myForm"]["marchio"].value;
	let e=document.forms["myForm"]["modello"].value;
	let f=document.forms["myForm"]["kw"].value;
	let g=document.forms["myForm"]["prezzo"].value;
	let h=document.forms["myForm"]["partita_iva"].value;
	let i=document.forms["myForm"]["path"].value;
	let l=document.forms["myForm"]["accessori"].value;
	let m=document.forms["myForm"]["custom"].value;
	
	
	if(a==""||b==""||c==""||d==""||e==""||f==""||g==""||h==""||i==""||l==""||m==""){
		alert("Inserisci dati mancanti");
		return false;
	}
	
}

</script>
</head>
<body>
	<a href ="adminHome.jsp">
	<img src = "images/VEICHOME (2)1 (1).png" alt = "Logo VeicHome">
	</a>
	
<%

		ProductVeicolo cl=new ProductVeicolo();
		ProductMoto cl1 = new ProductMoto();
%>


<form action="<%=response.encodeURL("InserimentoMoto")%>" method="POST" name="myForm" enctype="multipart/form-data" onsubmit="return validateForm()">
			<fieldset>
				<legend><b>Insrimento moto</b></legend>
				
				<label for="codice_telaio">Codice Telaio:</label>
				<input type="text" name="codice_telaio" value="<%=cl.getCodice_telaio() %>" value="<%= cl1.getCodice_telaio()%>">
				
				<br><label for="targa">Targa:</label>
				<input type="text" name="targa" value="<%=cl.getTarga()%>" value="<%= cl1.getTarga()%>">
				
				<br><label for="colore">Colore:</label>
				<input type="text" name="colore" value="<%=cl.getColore() %>">
								
				<br><label for="marchio">Marchio:</label>
				<input  name="marchio" type="text" maxlength="20" value="<%=cl.getMarchio()%>">
				
				<br><label for="modello">Modello:</label>
				<input type="text" name="modello" value="<%=cl.getModello() %>">
				
				<br><label for="kw">Kw:</label>
				<input type="text" name="kw" value="<%=cl.getKw() %>">
				
				<br><label for="prezzo">Prezzo:</label>
				<input type="text" name="prezzo" value="<%=cl.getPrezzo() %>">
				
				<br><label for="partita_iva">Partita Iva:</label>
				<input type="text" name="partita_iva" value="<%=cl.getPartita_iva() %>">
				
				<br><label for="path">Foto:</label>
				<input type="file" name="path" value="<%=cl.getPath() %>">
				
				<br><label for="accessori">Accessori:</label>
				<input type="text" name="accessori" value="<%=cl1.getAccessori() %>">
				
				<br><label for="custom">Custom:</label>
				<input type="text" name="custom" value="<%=cl1.getCustom() %>">
	
			<br>
				<input id = "ok" type="submit" name="ok" value="Ok">
				<input id = "reset" type="reset" value="Reset">
			</fieldset>
		</form>	
		

</body>
</html>