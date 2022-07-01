package it.unisa.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.sql.DataSource;

import it.unisa.model.bean.ProductCarrello;
import it.unisa.model.bean.ProductCliente;
import it.unisa.model.bean.ProductImpiegato;
import it.unisa.utils.Utility;

public class QueryImpiegato {

	private DataSource ds = null;

	public QueryImpiegato(DataSource ds) {
		this.ds = ds;
	}
	
	public Collection<ProductImpiegato> doRetriveAll(String order) throws SQLException {
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		
		String selectSQL="SELECT * FROM impiegato";
		
		if(order!=null && !order.equals("")) {
			selectSQL +=" ORDER BY "+ order;
		}
		
		Collection<ProductImpiegato> products7= new LinkedList<ProductImpiegato>();
		
		try {
			connection = ds.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			
			Utility.print("doRetriveAll: "+preparedStatement.toString());
			
			ResultSet rs= preparedStatement.executeQuery();
			
			while(rs.next()) {
				ProductImpiegato cr= new ProductImpiegato();
				cr.setCodice(rs.getString("codice"));
				cr.setNome(rs.getString("nome"));
				cr.setCognome(rs.getString("cognome"));
				cr.setCodice_fiscale(rs.getString("codice_fiscale"));
				cr.setData_assunzione(rs.getString("data_assunzione"));
				cr.setPartita_iva(rs.getString("partita_iva"));
				cr.setPassword(rs.getString("password"));
				products7.add(cr);
			}
			
			
		}finally {
			try {
			if(preparedStatement!=null)
				preparedStatement.close();
			}finally {
			if(connection!=null)
				connection.close();
			}
		}
		return products7;
	}
	
	public ProductImpiegato doRetrieveByKey(String nome,String password) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ProductImpiegato bean = new ProductImpiegato();

		String selectSQL1 = "SELECT * FROM impiegato WHERE nome = ? and password = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL1);
			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, password);

			Utility.print("doRetrieveByKey: " + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setNome(rs.getString("nome"));
				bean.setCodice_fiscale(rs.getString("codice_fiscale"));
				
			}

			Utility.print(bean.toString());
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null) {
					connection.close();
				}
			}
		}

		return bean;
	}

	

	
}
