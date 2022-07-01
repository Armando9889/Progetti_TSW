package it.unisa.query;
import it.unisa.model.bean.ProductProprietari;
import it.unisa.model.bean.ProductUsato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.sql.DataSource;


import it.unisa.utils.Utility;

public class QueryProprietari{

	private DataSource ds = null;

	public QueryProprietari(DataSource ds) {
		this.ds = ds;
	}

	public Collection<ProductProprietari> doRetriveAll3(String order) throws SQLException {
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		
		String selectSQL="SELECT * FROM proprietari";
		
		if(order!=null && !order.equals("")) {
			selectSQL +=" ORDER BY "+ order;
		}
		
		Collection<ProductProprietari> products3= new LinkedList<ProductProprietari>();
		
		try {
			connection = ds.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			
			Utility.print("doRetriveAll: "+preparedStatement.toString());
			
			ResultSet rs= preparedStatement.executeQuery();
			
			while(rs.next()) {
				ProductProprietari pro= new ProductProprietari();
				pro.setProprietari(rs.getString("proprietari"));
				pro.setCodice_telaio(rs.getString("codice_telaio"));
				pro.setTarga(rs.getString("targa"));
				products3.add(pro);
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
		return products3;
	}
	
	
	public ProductProprietari doRetrieveByKey1(String targa,String codice_telaio) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ProductProprietari bean = new ProductProprietari();

		String selectSQL = "SELECT * FROM proprietari WHERE targa = ? and codice_telaio = ?";

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

	
	
public void doDelete1(ProductProprietari product) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//ProductVeicolo product1;
		//String deleteSQL = "DELETE FROM moto WHERE t = ?";
		String deleteSQL = "DELETE FROM proprietari WHERE targa = ? and codice_telaio = ?";
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
