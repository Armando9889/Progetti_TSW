package it.unisa.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.sql.DataSource;

import it.unisa.model.bean.ProductAcquisto;
import it.unisa.model.bean.ProductCarrello;
import it.unisa.model.bean.ProductMoto;
import it.unisa.utils.Utility;

public class QueryAcquisto {
	
	
	private DataSource ds = null;

	public QueryAcquisto(DataSource ds) {
		this.ds = ds;
	}
	

	public void doSave(ProductAcquisto product) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO acquisto"+ " (targa,codice_telaio,modello,prezzo,codice_fiscale) VALUES (?,?,?,?,?)";

		try {
			connection = ds.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setString(1, product.getTarga());
			preparedStatement.setString(2, product.getCodice_telaio());
			preparedStatement.setString(3, product.getModello());
			preparedStatement.setInt(4, product.getPrezzo());
			preparedStatement.setString(5, product.getCodice_fiscale());
			//preparedStatement.setString(6, product.getPath());
			
			Utility.print("doSave: " + preparedStatement.toString());
			preparedStatement.executeUpdate();

			connection.commit();
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
		}
		
	
	public ProductAcquisto doRetrieveByKey(String codice_fiscale) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ProductAcquisto bean = new ProductAcquisto();

		String selectSQL = "SELECT * FROM acquisto codice_fiscale = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			// preparedStatement = connection.prepareStatement(selectSQL1);
			preparedStatement.setString(1, codice_fiscale);

			Utility.print("doRetrieveByKey: " + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				// bean.setAccessori(rs.getString("accessori"));
				/// bean.setCustom(rs.getString("custom"));
				bean.setCodice_telaio(rs.getString("codice_telaio"));
				bean.setTarga(rs.getString("targa"));
				bean.setCodice_fiscale(rs.getString("codice_fiscale"));
				bean.setModello(rs.getString("modello"));
				bean.setPrezzo(rs.getInt("prezzo"));
				//bean.setModello(rs.getString("path"));
	
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
	
	
	public Collection<ProductAcquisto> doRetriveAll(String order) throws SQLException {
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		
		String selectSQL="SELECT * FROM acquisto";
		
		if(order!=null && !order.equals("")) {
			selectSQL +=" ORDER BY "+ order;
		}
		
		Collection<ProductAcquisto> products7= new LinkedList<ProductAcquisto>();
		
		try {
			connection = ds.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			
			Utility.print("doRetriveAll: "+preparedStatement.toString());
			
			ResultSet rs= preparedStatement.executeQuery();
			
			while(rs.next()) {
				ProductAcquisto cr= new ProductAcquisto();
				cr.setTarga(rs.getString("targa"));
				cr.setCodice_telaio(rs.getString("codice_telaio"));
				cr.setModello(rs.getString("modello"));
				cr.setPrezzo(rs.getInt("prezzo"));
				cr.setCodice_fiscale(rs.getString("codice_fiscale"));
				//cr.setPath(rs.getString("path"));
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
	
	public void doDelete() throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL1 = "DELETE FROM acquisto";

		

		try {
			connection = ds.getConnection();
			connection.setAutoCommit(false);
			
			
			preparedStatement = connection.prepareStatement(deleteSQL1);

			
			

			Utility.print("doDelete: " + preparedStatement.toString());
			preparedStatement.executeUpdate();

			connection.commit();

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
	}



	
	
}
