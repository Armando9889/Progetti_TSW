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

import it.unisa.model.bean.ProductAcquisto;
import it.unisa.model.bean.ProductCarrello;
import it.unisa.query.QueryAcquisto;
import it.unisa.query.QueryCarrello;
import it.unisa.query.QueryCliente;

import it.unisa.query.QueryVeicolo;

@WebServlet("/Acquisto")
public class Acquisto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Acquisto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		QueryAcquisto model = new QueryAcquisto(ds);
		QueryCliente model4 = new QueryCliente(ds);
		//QueryLogin model1 = new QueryLogin(ds);
		//QueryVeicolo model2 = new QueryVeicolo(ds);
		
	




	
			String codice = request.getParameter("codice");
			String targa = request.getParameter("targa");
			String modello = request.getParameter("modello");
			String prezzo = request.getParameter("prezzo");
			String codice_fiscale = request.getParameter("codice_fiscale");
			//String path = request.getParameter("path");
			
			int pre=Integer.parseInt(prezzo);
            //System.out.println("ok");

		     ProductAcquisto cl= new ProductAcquisto();
			cl.setTarga(targa);
			cl.setCodice_telaio(codice);
			cl.setModello(modello);
			cl.setPrezzo(pre);
			cl.setCodice_fiscale(codice_fiscale);
		//	cl.setPath(path);
			try {
				model.doSave(cl);
				//request.setAttribute("login1", model1.doRetriveAll1(""));
				//request.setAttribute("products", model2.doRetriveAll5(""));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/VisualizzaCarrello.jsp");
			//dispatcher.forward(request, response);
			response.sendRedirect("Acquistato?modello="+modello);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
