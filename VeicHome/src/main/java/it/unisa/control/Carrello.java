package it.unisa.control;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;

import it.unisa.model.bean.ProductCarrello;
import it.unisa.model.bean.ProductCliente;
import it.unisa.query.QueryCarrello;
import it.unisa.query.QueryCliente;


@MultipartConfig
@WebServlet("/Carrello")
public class Carrello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Carrello() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		QueryCarrello model = new QueryCarrello(ds);
		//QueryLogin model1 = new QueryLogin(ds);
		QueryCliente model4 = new QueryCliente(ds);

		String codice = request.getParameter("codice");
		String targa = request.getParameter("targa");
		String modello = request.getParameter("modello");
		String prezzo = request.getParameter("prezzo");
		String idsession = request.getParameter("session");
		//String path = request.getParameter("path");
		//Part filePart = request.getPart("path");
	//	InputStream inputStream = filePart.getInputStream();

		if (codice.isEmpty() || targa.isEmpty() || modello.isEmpty() || prezzo.isEmpty()||idsession.isEmpty() ) {
			System.out.println("Sono qui non faccio niente");
		} else {

			int pre = Integer.parseInt(prezzo);
			// System.out.println("ok");
			System.out.println("Faccio qualocsa");
			ProductCarrello cl = new ProductCarrello();
			cl.setTarga(targa);
			cl.setCodice_telaio(codice);
			cl.setModello(modello);
			cl.setPrezzo(pre);
			cl.setSessionid(idsession);
			//cl.setPath(inputStream);
			try {
				model.doSave(cl);
				//request.setAttribute("login1", model1.doRetriveAll1(""));

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/homeUfficiale.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
