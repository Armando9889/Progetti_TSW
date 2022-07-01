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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;



import it.unisa.model.bean.*;
import it.unisa.query.QueryCarrello;
import it.unisa.query.QueryCliente;
import it.unisa.query.QueryImpiegato;

import it.unisa.query.login;



@WebServlet("/ProductControl")
public class ProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
protected String n;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		login model = new login(ds);
		QueryCliente model2 = new QueryCliente(ds);
		//QueryLogin model3 = new QueryLogin(ds);	
		//QueryCliente model4 = new QueryCliente(ds);
		QueryImpiegato model5 = new QueryImpiegato(ds);

		String action = "delete";

		boolean cl = false;
		boolean cl1 = false;
		String cod;
		HttpSession sessione = request.getSession();
		ProductCliente c= new ProductCliente();
		
		ProductImpiegato c1= new ProductImpiegato();
		
		if (action.equals("delete")) {
			 String nome = request.getParameter("id");
			// String name = request.getParameter("name");
			// String cognome = request.getParameter("surname");
			String password = request.getParameter("sesso");
			
			if(nome.isEmpty()||password.isEmpty()) {
				//System.out.println("ciao");
			}
			else {
		 
			try {
				cl = model.login_user(nome, password);
				
					cl1 = model.login_admin(nome, password);
					
					if(cl==true) {
					
				c=model2.doRetrieveByKey(nome,password);
				cod=c.getCodice_fiscale();
				sessione.setAttribute("cf",cod);
				// ProductLogin ca= new ProductLogin();
					//ca.setCodice_fiscale(cod);
				//model3.doSave(ca);
					System.out.println(cod);
					
					}
					if(cl1==true) {
					c1=model5.doRetrieveByKey(nome,password);
					cod=c1.getCodice_fiscale();
					sessione.setAttribute("cf",cod);
					// ProductLogin ca1= new ProductLogin();
						//ca1.setCodice_fiscale(cod);
					//model3.doSave(ca1);
						System.out.println(cod);
					}
		
			
				System.out.println(cl);
				
				sessione.setAttribute("login",nome);
		
				
				String x = sessione.getId();
				System.out.println(x);
				//request.setAttribute("login1",model3.doRetriveAll1(""));
				
					}
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
			
			
		}

		if (cl == false && cl1 == false) {
			RequestDispatcher dispatcher1 = this.getServletContext().getRequestDispatcher("/errore.jsp");
			
			dispatcher1.forward(request, response);
		}

		if (cl == true) {
			RequestDispatcher dispatcher1 = this.getServletContext().getRequestDispatcher("/homeUfficiale.jsp");
			dispatcher1.forward(request, response);
			//response.sendRedirect("Login?user_name="+nome);
		}
		if (cl1 == true) {
			RequestDispatcher dispatcher1 = this.getServletContext().getRequestDispatcher("/adminHome.jsp");
			dispatcher1.forward(request, response);
	
		}
		}
		
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}