package it.unisa.query;
import it.unisa.model.bean.ProductAuto;
import it.unisa.model.bean.ProductUsato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.sql.DataSource;


import it.unisa.utils.Utility;

public class QueryUsato{

	private DataSource ds = null;

	public QueryUsato(DataSource ds) {
		this.ds = ds;
	}


	public Collection<ProductUsato> doRetriveAll4(String order) throws SQLException {

		Connection connection =null;
		PreparedStatement preparedStatement=null;
		
		String selectSQL="SELECT * FROM usato";
		
		if(order!=null && !order.equals("")) {
			selectSQL +=" ORDER BY "+ order;
		}
		
		Collection<ProductUsato> products4= new LinkedList<ProductUsato>();
		
		try {
			connection = ds.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			
			Utility.print("doRetriveAll: "+preparedStatement.toString());
			
			ResultSet rs= preparedStatement.executeQuery();
			
			while(rs.next()) {
				ProductUsato usa= new ProductUsato();
				usa.setAnno_immatricolazione(rs.getString("anno_immatricolazione"));
				usa.setNumero_km(rs.getInt("numero_km"));
				usa.setCodice_telaio(rs.getString("codice_telaio"));
				usa.setTarga(rs.getString("targa"));
				products4.add(usa);
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
		return products4;
	}
	
	public ProductUsato doRetrieveByKey1(String targa,String codice_telaio) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ProductUsato bean = new ProductUsato();

		String selectSQL = "SELECT * FROM usato WHERE targa = ? and codice_telaio = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, codice_telaio);
			preparedStatement.setString(2, targa);

			Utility.print("doRetrieveByKey: " + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				//bean.setAccessori(rs.getString("accessori"));
				///bean.setCustom(rs.getString("custom"));
				bean.setCodice_telaio(rs.getString("codice_telaio"));
				bean.setTarga(rs.getString("targa"));
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

	
	
public void doDelete1(ProductUsato product) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//ProductVeicolo product1;
		//String deleteSQL = "DELETE FROM moto WHERE t = ?";
		String deleteSQL = "DELETE FROM usato WHERE targa = ? and codice_telaio = ?";
		//String updateSQL = "UPDATE moto SET " + " targa = ?, codice_telaio= ?";

		//String deleteSQL = "DELETE FROM moto WHERE targa = ? and codice_telaio = ?";
		//String deleteSQL = "SELECT * FROM moto WHERE targa = ? and codice_telaio = ? and SELECT * FROM veicolo WHERE targa = ? and codice_telaio = ?";
		


		try {
			connection = ds.getConnection();
			connection.setAutoCommit(false);
			
			preparedStatement = connection.prepareStatement(deleteSQL);
			//preparedStatement = connection.prepareStatement(updateSQL);
			//preparedStatement = connection.prepareStatement(deleteSQL1);
			//preparedStatement.setString(1, product.getAccessori());
			//preparedStatement.setString(2, product.getCustom());
			preparedStatement.setString(1, product.getTarga());
			preparedStatement.setString(2, product.getCodice_telaio());
			

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
