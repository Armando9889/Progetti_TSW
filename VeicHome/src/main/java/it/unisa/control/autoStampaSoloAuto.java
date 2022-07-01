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

import it.unisa.model.ProductModelDS;
import it.unisa.model.bean.ProductCliente;
import it.unisa.model.bean.ProductVeicolo;
import it.unisa.query.QueryCliente;

import it.unisa.query.QueryVeicolo;
import it.unisa.utils.Utility;

@WebServlet("/autoStampaSoloAuto")
public class autoStampaSoloAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public autoStampaSoloAuto() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		QueryVeicolo model = new QueryVeicolo(ds);
		//QueryLogin model1 = new QueryLogin(ds);

		try {
			request.setAttribute("prova", model.cercaAuto(""));
			//request.setAttribute("login1", model1.doRetriveAll1(""));
		} catch (SQLException e) {
			Utility.print(e);
			
			request.setAttribute("error", e.getMessage());
		}
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/testingStampaSoloAuto.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
