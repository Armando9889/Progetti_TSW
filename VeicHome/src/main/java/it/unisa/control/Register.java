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


import it.unisa.model.bean.*;
import it.unisa.query.*;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		QueryCliente model = new QueryCliente(ds);

		String action = "delete";

		if (action.equals("delete")) {
			String codice = request.getParameter("id");
			String name = request.getParameter("name");
			String cognome = request.getParameter("surname");
			String sesso = request.getParameter("sesso");
			String indirizzo = request.getParameter("indirizzo");
			String data = request.getParameter("data");
			String password = request.getParameter("password");
			
			if(codice.isEmpty()||name.isEmpty()||cognome.isEmpty()||sesso.isEmpty()||indirizzo.isEmpty()||data.isEmpty()||password.isEmpty()){
				
			}
			else {
			
			
			ProductCliente cl = new ProductCliente();
			cl.setCodice_fiscale(codice);
			cl.setNome(name);
			cl.setCognome(cognome);
			cl.setSesso(sesso);
			cl.setIndirizzo(indirizzo);
			cl.setData_di_nascita(data);
			cl.setPassword(password);
			
			try {
				model.doSave(cl);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}

		RequestDispatcher dispatcher1 = this.getServletContext().getRequestDispatcher("/login.jsp");
		dispatcher1.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
