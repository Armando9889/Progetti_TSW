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

import it.unisa.model.bean.ProductAuto;
import it.unisa.model.bean.ProductMoto;
import it.unisa.model.bean.ProductVeicolo;
import it.unisa.query.QueryAuto;
import it.unisa.query.QueryMoto;
import it.unisa.query.QueryVeicolo;

@MultipartConfig
@WebServlet("/InserimentoMoto")
public class InserimentoMoto extends HttpServlet {


	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		QueryVeicolo model = new QueryVeicolo(ds);
		QueryMoto model1 = new QueryMoto(ds);

		String codice_telaio = request.getParameter("codice_telaio");
		String targa = request.getParameter("targa");
		String colore = request.getParameter("colore");
		String marchio = request.getParameter("marchio");
		String modello = request.getParameter("modello");
		String kw = request.getParameter("kw");
		int x = Integer.parseInt(kw);
		String prezzo = request.getParameter("prezzo");
		int y = Integer.parseInt(prezzo);
		String partita_iva = request.getParameter("partita_iva");
		// String codice_fiscale = request.getParameter("codice_fiscale");
		//String path = request.getParameter("path");

		
		Part filePart = request.getPart("path");
		InputStream inputStream = filePart.getInputStream();
		
		
		
		ProductVeicolo cl = new ProductVeicolo();

		cl.setCodice_telaio(codice_telaio);
		cl.setTarga(targa);
		cl.setColore(colore);
		cl.setMarchio(marchio);
		cl.setModello(modello);
		cl.setKw(x);
		cl.setPrezzo(y);
		cl.setPartita_iva(partita_iva);
		// cl.setCodice_fiscale(codice_fiscale);
		cl.setPath(inputStream);
if(codice_telaio.isEmpty()||targa.isEmpty()||colore.isEmpty()||marchio.isEmpty()||modello.isEmpty()||x==0||y==0||partita_iva.isEmpty()) {
			
		}
else {
		ProductMoto moto = new ProductMoto();

		String accessori = request.getParameter("accessori");
		String custom = request.getParameter("custom");

		moto.setAccessori(accessori);;
		moto.setCustom(custom);
		moto.setCodice_telaio(codice_telaio);
		moto.setTarga(targa);

		try {
			model.doInsertVeicolo(cl);
			model1.doInsertMoto(moto);
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
