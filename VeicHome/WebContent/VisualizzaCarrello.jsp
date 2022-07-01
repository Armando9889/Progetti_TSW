<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,it.unisa.model.bean.*,it.unisa.control.*"%>
    
<!doctype html>
<html lang="en">
  <head>
  
    <script type="text/javascript">
function validateForm(){
	let a=document.forms["myForm"].value;
		alert("Logout eseguito con successo");
	
}


function acquisto(){
	let prova=document.forms["myForm"].value;
	alert("Grazie per l'acqusto");
}

</script>
  

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="VisualizzaCarrello.css" type="text/css">

    <title>VeicHome-Vendita di veicoli nuovi e usati</title>
  </head>
  <body>
  
  	<% 
  	//Collection<?> products2 = (Collection<?>)request.getAttribute("login1");
  	%>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>


<nav class="navbar navbar-light bg-light">
        <div class="container-fluid">
        
        <form action="prova" method="post"><a class="navbar-brand"><img src="images/logo.png" alt="" width="30" height="24" class="d-inline-block align-text-top"><input type="submit" value="VeicHome" style="border: none; outline: none; background-color: transparent;">
                       
          </a></form>
          
          <ul class="nav justify-content-end">
                     <li class="nav-item">
              <a id="prova" class="nav-link active" aria-current="page" href="login.jsp">Login</a>
            </li>
          <%
    	  String cf = (String) session.getAttribute("cf");
 		 if(cf==null){
 		 System.out.println(cf);
		
	
	%>
            <%}else{ System.out.println("Ciao");%>
 			<style type="text/css"> #prova{display:none; outline:none;}</style>
			<li class="nav-item">
              <a class="nav-link active" aria-current="page" href="MyProfilo.jsp">Mio Profilo</a>
            </li>
            <%} %>
             <li class="nav-item"> 
              <form action="Logout" name ="myForm" onsubmit="return validateForm()">
              <a class="nav-link active" aria-current="page" href="homeUfficiale.jsp"><input style="outline:trasparent; border: none; 
              background-color: rgba(248,249,251,255); color: #0d6efd" id = "ok" type="submit" name="ok" value="Logout"></a>
              </form>
             	<!--  <a class="nav-link active" aria-current="page" href="Logout">Logout</a>-->
            </li>
            <li class="nav-item">
             <a id="prova" class="nav-link" href="register.jsp">Registrati</a>
            </li>
          </ul>
        </div>
     </nav>


     
        <table>
            <tr>
                <th>Prodotto</th>
                <th id="ok" style="padding-left: 850px;">Quantit&#224;</th>
                <th>Totale</th>
            </tr>
        </table>
        
        <%
		Collection<?> products = (Collection<?>)request.getAttribute("carrello");
    	//Collection<?> products1 = (Collection<?>)request.getAttribute("login1");
    	Collection<?> products3 = (Collection<?>)request.getAttribute("products");
		%>	


		<%
		 String idsession = session.getId();
        
		ProductCarrello ca = new ProductCarrello();
		if(products != null && products.size() > 0) {		
			Iterator<?> it = products.iterator();
			while(it.hasNext()) {
				ProductCarrello bean = (ProductCarrello)it.next();
				
				if(bean.getSessionid().equals(idsession)){
				
				
					if(products3 != null && products3.size() > 0) {
					
					Iterator<?> it2 = products3.iterator();
					while(it2.hasNext()) {
						ProductVeicolo bean2 = (ProductVeicolo)it2.next();				
						if(bean2.getModello().equals(bean.getModello())){
						
				
				
		%>
            
        <div class="small-container cart-page">    
            <table>
            <tr>
                <td>
                    <div class="cart-info">
                        <img src="data:image/jpg;base64,<%= bean2.getBase64Image()%>">
                        <%}}} %>
                        <div>
                            <p><%= bean.getModello()%></p>
                            <small>Prezzo:&euro;<%= bean.getPrezzo()%></small>
                            <br>
                            <small>Pagamento alla consegna</small>
                            <br>
                        </div>
                    </div>

                </td>
                <td><input type="number" value="1" disabled></td>
                <td>&euro;<%= bean.getPrezzo()%></td>
            </tr>
		</table>
	</div>
            
            
            
            	<%
          	  String cf1 = (String) session.getAttribute("cf");
       		 if(cf1==null){
       		 System.out.println(cf);
	%>
	<%}else{ %>

<form action="Acquisto" method="POST" name="myForm" onsubmit=" return acquisto()" >
				
							
	
				<input type="text" name="targa" id="tar" value=<%= bean.getTarga()%>>
				
				
				<input type="text" name="codice" id="cod"  value="<%=bean.getCodice_telaio()%>" >
				
				
				
				<input type="text" name="modello" id="tar" value=<%= bean.getModello()%>>
				
				<input type="text" name="prezzo" id="tar" value=<%= bean.getPrezzo()%>>
				
				
				<input type="text" name="codice_fiscale" id="cod"  value="<%=cf1%>" >
				
			<br>
				<input id = "ok" type="submit" name="ok" value="Acquista">
					
		</form>	
	 

	<% } }} } %> 

<form action="EliminaCarrello">
		<input id = "ok" type="submit" name="ok" value="Svuota carrello">
		</form>



       










    




</body>
</html>