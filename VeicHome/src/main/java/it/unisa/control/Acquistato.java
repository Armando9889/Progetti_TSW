package it.unisa.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import it.unisa.query.QueryCliente;

import it.unisa.query.QueryVeicolo;


@WebServlet("/Acquistato")
public class Acquistato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Acquistato() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RequestDispatcher dispatcher1 = this.getServletContext().getRequestDispatcher("/homeUfficiale.html");
		//dispatcher1.forward(request, response);
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		QueryCliente model4 = new QueryCliente(ds);
		//QueryLogin model1 = new QueryLogin(ds);
		//QueryVeicolo model2 = new QueryVeicolo(ds);
		
			String mode=request.getParameter("modello");
		System.out.println(mode);
		//PrintWriter out = response.getWriter();
		//out.println("<script type=\"text/javascript\">");
		//request.setAttribute("login1", model1.doRetriveAll1("")); 
			//request.setAttribute("products", model2.doRetriveAll5(""));
		  // out.println("alert('Hai acquistato:"+mode+"');");
		//out.println("location='homeUfficiale.jsp';");
		   //out.println("</script>");
	
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/homeUfficiale.jsp");
		dispatcher.forward(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
