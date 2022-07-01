package it.unisa.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import it.unisa.model.bean.ProductAuto;
import it.unisa.model.bean.ProductCarrello;
import it.unisa.model.bean.ProductMoto;
import it.unisa.model.bean.ProductVeicolo;
import it.unisa.query.QueryAuto;
import it.unisa.query.QueryCarrello;
import it.unisa.query.QueryCliente;

import it.unisa.query.QueryMoto;
import it.unisa.query.QueryVeicolo;


@WebServlet("/EliminaCarrello")
public class EliminaCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public EliminaCarrello() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		QueryCarrello model = new QueryCarrello(ds);
		//QueryLogin model3 = new QueryLogin(ds);	
		QueryCliente model4 = new QueryCliente(ds);

		String action = "delete";

		if (action.equals("delete")) {
			try {
				
				HttpSession sessione = request.getSession(false);
				sessione.getAttribute("login");
				
			
				String id=(String)sessione.getId();
				
					
			model.doDelete(id);
			//request.setAttribute("login1",model3.doRetriveAll1(""));

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/VisualizzaCarrello.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
