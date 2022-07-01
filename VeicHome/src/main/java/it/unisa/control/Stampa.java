package it.unisa.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

//import it.unisa.query.QueryLogin;
import it.unisa.query.QueryVeicolo;
import it.unisa.utils.Utility;

@WebServlet("/Stampa")
public class Stampa extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Stampa() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		QueryVeicolo model = new QueryVeicolo(ds);
		//QueryLogin model1 = new QueryLogin(ds);

		
		String x = (String)request.getAttribute("CIAOS");
		
		
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/auto.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
