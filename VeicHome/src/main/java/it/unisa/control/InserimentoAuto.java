package it.unisa.control;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
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

import it.unisa.model.bean.ProductAuto;
import it.unisa.model.bean.ProductCliente;
import it.unisa.model.bean.ProductVeicolo;
import it.unisa.query.QueryAuto;
import it.unisa.query.QueryCliente;
import it.unisa.query.QueryVeicolo;

@MultipartConfig
@WebServlet("/InserimentoAuto")
public class InserimentoAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		QueryVeicolo model = new QueryVeicolo(ds);
		QueryAuto model1 = new QueryAuto(ds);

		String codice_telaio = request.getParameter("codice_telaio");
		String targa = request.getParameter("targa");
		String colore = request.getParameter("colore");
		String marchio = request.getParameter("marchio");
		String modello = request.getParameter("modello");
		String kw = request.getParameter("kw");
		int x = Integer.parseInt(kw);
		
		//System.out.println(x);
		String prezzo = request.getParameter("prezzo");
		int y = Integer.parseInt(prezzo);
		String partita_iva = request.getParameter("partita_iva");
		//String codice_fiscale = request.getParameter("codice_fiscale");
		
		
		
		
		Part filePart = request.getPart("path");
		InputStream inputStream = filePart.getInputStream();
		
		
		
		 /*inputStream = null;
		String message = null;
		
		
		//System.out.println(filePart);
		if (filePart != null) {
			System.out.println(filePart.getName());
			System.out.println(filePart.getSize());
			System.out.println(filePart.getContentType());
			
			
		}
		/*String path = request.getParameter("path");
		System.out.println(path);
		 */
		
		ProductVeicolo cl = new ProductVeicolo();
		
		cl.setCodice_telaio(codice_telaio);
		cl.setTarga(targa);
		cl.setColore(colore);
		cl.setMarchio(marchio);
		cl.setModello(modello);
		cl.setKw(x);
		cl.setPrezzo(y);
		cl.setPartita_iva(partita_iva);
		//cl.setCodice_fiscale(codice_fiscale);
		cl.setPath(inputStream);
		if(codice_telaio.isEmpty()||targa.isEmpty()||colore.isEmpty()||marchio.isEmpty()||modello.isEmpty()||x==0||y==0||partita_iva.isEmpty()) {
			System.out.println("errore");
		}
		else {
		ProductAuto auto = new ProductAuto();
		
		String sconto = request.getParameter("sconto");
		String numero_di_passegeri = request.getParameter("numero_di_passegeri");
		int n = Integer.parseInt(numero_di_passegeri);
		
		auto.setSconto(sconto);
		auto.setNumero_di_passgeri(n);
		auto.setCodice_telaio(codice_telaio);
		auto.setTarga(targa);
		
		try {
			
			model.doInsertVeicolo(cl);
			model1.doInsertAuto(auto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


		RequestDispatcher dispatcher1 = this.getServletContext().getRequestDispatcher("/adminHome.jsp");
		dispatcher1.forward(request, response);

	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
