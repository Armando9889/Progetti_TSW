<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,it.unisa.model.bean.*"%>
    
    
    <%
	Collection<?> products = (Collection<?>)request.getAttribute("products");
   // Collection<?> products1 = (Collection<?>)request.getAttribute("login1");
	
	%>  
    
    
    
<!DOCTYPE html>
<html lang="en">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <script type="text/javascript">
        function validateForm(){
            let a=document.forms["myForm"].value;
                alert("Logout eseguito con successo");
            
        }
        
        </script>
        
	<script>
	$(document).ready(function(){
	  $("button").click(function(){
	    $.ajax({url: "informazioni.html", success: function(result){
	    	$("#div1").html(result);
	    }});
	  });
	});
	</script>



    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- font awesome cdn link  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <!-- custom css file link  -->
    <link rel="stylesheet"  type="text/css" href="style.css">

</head>
<body>


    <nav class="navbar navbar-light bg-light">
        <div class="container-fluid">
                  <form action="prova" method="post"><a class="navbar-brand"><img src="images/logo.png" alt="" width="30" height="24" class="d-inline-block align-text-top"><input type="submit" value="VeicHome" style="border: none; outline: none; background-color: transparent;">
                       
          </a></form>
          <ul class="nav justify-content-end">
                     <li class="nav-item">
              <a id="prova" class="nav-link active" aria-current="page" href="login.jsp">Login</a>
            </li>
          <%
          String idsession = session.getId();
			
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
		<%
	String x = (String) request.getParameter("ciao");
		if(products != null && products.size() > 0) {
			
			Iterator<?> it = products.iterator();
			while(it.hasNext()) {
				ProductVeicolo bean = (ProductVeicolo)it.next();				
				if(x.equals(bean.getModello())){
					System.out.println(bean.getBase64Image());
				
	%>


   
<div class="box-container">

    <div class="box">

        <div class="image-container">

            <div class="big-image">
                <img src="data:image/jpg;base64,<%= bean.getBase64Image()%>" alt="">
            </div>

            <div class="small-image">
                <img class="prova" src="data:image/jpg;base64,<%= bean.getBase64Image()%>" alt="">              
            </div>

        </div>

        <div class="content">

            <h3 class="title"><%= bean.getMarchio()%> <%=bean.getModello()%></h3>
            <div class="price">&euro;<%= bean.getPrezzo()%></div>
            <p></p>

            <form action="">

                <div class="dropDown">
                    <span> Codice Telaio : </span>
                    <select name="" id="" disabled>
                        <option value="small"><%= bean.getCodice_telaio()%></option>

                    </select>
                    <span> Targa : </span>
                    <select name="" id="" disabled>
                        <option value="black"><%= bean.getTarga()%></option>                 
                    </select>
                     <span> Colore : </span>
                    <select name="" id="" disabled>
                        <option value="small"><%= bean.getColore()%></option>

                    </select>
                     <span> KW : </span>
                    <select name="" id="" disabled>
                        <option value="small"><%= bean.getKw()%></option>

                    </select>

                </div>

            </form>

            <br />
            
            
            <form action="<%=response.encodeURL("Carrello")%>" method="POST">
				
	
				<input type="text" name="targa" id="tar" value=<%= bean.getTarga()%>>
				
				
				<input type="text" name="codice" id="cod"  value="<%=bean.getCodice_telaio()%>" >
				
				
				
				<input type="text" name="modello" id="tar" value=<%= bean.getModello()%>>
				
				<input type="text" name="prezzo" id="tar" value=<%= bean.getPrezzo()%>>
				
				<input type="text" name="session" id="tar" value=<%= idsession%>>
				
				
				
			<br>
				
				<input type="submit" class="btn" value="Aggiungere al carrello">
				
		</form>	
		<br>
		<button class="btn"> Informazioni Acquisto</button>
		<div id="div1"><h2></h2></div>
		

        </div>

    </div>

</div>    

	<% } } }%>

</body>
</html>