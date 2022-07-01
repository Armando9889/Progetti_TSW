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

import it.unisa.model.bean.ProductAuto;
import it.unisa.model.bean.ProductMoto;
import it.unisa.model.bean.ProductProprietari;
import it.unisa.model.bean.ProductUsato;
import it.unisa.model.bean.ProductVeicolo;
import it.unisa.query.QueryAuto;
import it.unisa.query.QueryMoto;
import it.unisa.query.QueryProprietari;
import it.unisa.query.QueryUsato;
import it.unisa.query.QueryVeicolo;


@WebServlet("/EliminaVeicolo")
public class EliminaVeicolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EliminaVeicolo() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		QueryVeicolo model = new QueryVeicolo(ds);
		QueryMoto model1 = new QueryMoto(ds);
		QueryAuto model2 = new QueryAuto(ds);
		QueryUsato model3 = new QueryUsato(ds);
		QueryProprietari model4 = new QueryProprietari(ds);

		String action = "delete";

		if (action.equals("delete")) {
			String targa = request.getParameter("targa");
			String codice = request.getParameter("telaio");
			
			if(targa.isEmpty()||codice.isEmpty()) {
				
			}
			else {


			
			
			try {
				ProductProprietari proprietari=model4.doRetrieveByKey1(codice,targa);
				model4.doDelete1(proprietari);
				ProductUsato usato=model3.doRetrieveByKey1(codice,targa);
				model3.doDelete1(usato);
				ProductAuto auto=model2.doRetrieveByKey1(codice,targa);
				model2.doDelete1(auto);
				ProductMoto moto=model1.doRetrieveByKey1(codice,targa);
				model1.doDelete(moto);
			ProductVeicolo x=model.doRetrieveByKey1(codice,targa);
			model.doDelete(x);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		RequestDispatcher dispatcher1 = this.getServletContext().getRequestDispatcher("/adminHome.jsp");
		dispatcher1.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
