<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,it.unisa.model.bean.*"%>
    
<%
	Collection<?> products = (Collection<?>)request.getAttribute("impiegato");
	
%> 
 
 
    
<!doctype html>
<html lang="en">
  <head>
  
 <script type="text/javascript">
function validateForm(){
	let a=document.forms["myForm"].value;
		alert("Logout eseguito con successo");
	
}

</script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="adminHomeUfficiale.css" type="text/css">
    <script src="https://kit.fontawesome.com/b99e675b6e.js"></script>


    <title>VeicHome-Vendita di veicoli nuovi e usati</title>
  </head>
  <body>

   
    

    <nav class="navbar navbar-light bg-light">
        <div class="container-fluid">
                  <form action="prova" method="post"><a class="navbar-brand"><img src="images/logo.png" alt="" width="30" height="24" class="d-inline-block align-text-top"><input type="submit" value="VeicHome" style="border: none; outline: none; background-color: transparent;">
                       
          </a></form>
          <ul class="nav justify-content-end">
             <li class="nav-item"> 
              <form action="Logout" name ="myForm" onsubmit="return validateForm()">
              <a class="nav-link active" aria-current="page" href="homeUfficiale.jsp"><input style="outline:trasparent; border: none; 
              background-color: rgba(248,249,251,255); color: #0d6efd" id = "ok" type="submit" name="ok" value="Logout"></a>
              </form>
             	<!--  <a class="nav-link active" aria-current="page" href="Logout">Logout</a>-->
            </li>
          </ul>
        </div>
     </nav>


    <div class="wrapper">
        <div class="sidebar">
            <h2>ADMIN</h2>
            <ul>
                <li><a href="eliminaveicolo.jsp"><i class="fas fa-trash-alt"> Elimina</i></a></li>
                <li><a href="InserimentoAuto.jsp"><i class="fas fa-car"> Inserisci Auto</i></a></li>
                <li><a href="inserimentoMoto.jsp"><i class="fas fa-motorcycle"> Inserisci Moto</i></a></li>
                <li><a href="autoStampaSoloAuto"><i class="fas fa-print"> Stampa Auto</i></a></li>
                <li><a href="motoStampaSoloMoto"><i class="fas fa-print"> Stampa Moto</i></a></li> 
                 <li><a href="StampaOrdini"><i class="fas fa-print"> Stampa ordini</i></a></li>
              
               
            </ul> 
        </div>
        

        <div class="main_content">
        <form action="Impiegato" method="post">
            <div class="header" style="background-color: rgba(255,255,255,0.05);"><a><input style="outline: none; border: none; background-color: rgba(255,255,255,0.05);" id="ok" type="submit" value="DIPENDENTI VEICHOME"></a></div>
        </form>
            <div class="info">

                <div>
                <br />
                
             
       
				    

                    <table class="table table-sm">
                        <thead>
                          <tr>
                            <th scope="col">#</th>
                            <th scope="col">NOME</th>
                            <th scope="col">COGNOME</th>
                            <th scope="col">CODICE FISCALE</th>
                            <th scope="col">DATA ASSUNZIONE</th>
                          </tr>
                        </thead>
                                        
                                  <%
                                  int x = 0;
                                  if(products != null && products.size() > 0) { 
				    	 Iterator<?> it = products.iterator();
				    			 while(it.hasNext()) {
				    				 ProductImpiegato bean = (ProductImpiegato)it.next();
				    				 x++;
				    			 %>        
                         
				
                        <tbody>
                          <tr>
                            <th scope="row"><%=x %></th>
                            <td><%=bean.getNome() %></td>
                            <td><%=bean.getCognome() %></td>
                            <td><%=bean.getCodice_fiscale() %></td>
                            <td><%=bean.getData_assunzione() %></td>
                          </tr>
                         <% } } %>
                          
                        </tbody>
                      </table>
                      
                      


                </div>




            </div>
        </div>
    </div>



  </body>
</html>