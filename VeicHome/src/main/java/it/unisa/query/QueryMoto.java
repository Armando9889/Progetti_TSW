package it.unisa.query;

import it.unisa.model.bean.ProductAuto;
import it.unisa.model.bean.ProductMoto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.sql.DataSource;

import it.unisa.utils.Utility;

public class QueryMoto {

	private DataSource ds = null;

	public QueryMoto(DataSource ds) {
		this.ds = ds;
	}

	public Collection<ProductMoto> doRetriveAll7(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "SELECT * FROM moto";

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		Collection<ProductMoto> products7 = new LinkedList<ProductMoto>();

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			Utility.print("doRetriveAll: " + preparedStatement.toString());

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ProductMoto moto = new ProductMoto();
				moto.setAccessori(rs.getString("accessori"));
				moto.setCustom(rs.getString("custom"));
				moto.setCodice_telaio(rs.getString("codice_telaio"));
				moto.setTarga(rs.getString("targa"));
				products7.add(moto);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return products7;
	}

	public ProductMoto doRetrieveByKey(String targa, String codice_telaio) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ProductMoto bean = new ProductMoto();

		String selectSQL = "SELECT * FROM moto WHERE targa = ? and codice_telaio = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			// preparedStatement = connection.prepareStatement(selectSQL1);
			preparedStatement.setString(1, codice_telaio);
			preparedStatement.setString(2, targa);

			Utility.print("doRetrieveByKey: " + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				// bean.setAccessori(rs.getString("accessori"));
				/// bean.setCustom(rs.getString("custom"));
				bean.setCodice_telaio(rs.getString("codice_telaio"));
				bean.setTarga(rs.getString("targa"));
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

	public void doDelete(ProductMoto product) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		// ProductVeicolo product1;
		// String deleteSQL = "DELETE FROM moto WHERE t = ?";
		String deleteSQL = "DELETE FROM moto WHERE targa = ? and codice_telaio = ?";
		// String updateSQL = "UPDATE moto SET " + " targa = ?, codice_telaio= ?";

		// String deleteSQL = "DELETE FROM moto WHERE targa = ? and codice_telaio = ?";
		// String deleteSQL = "SELECT * FROM moto WHERE targa = ? and codice_telaio = ?
		// and SELECT * FROM veicolo WHERE targa = ? and codice_telaio = ?";

		try {
			connection = ds.getConnection();
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(deleteSQL);
			// preparedStatement = connection.prepareStatement(updateSQL);
			// preparedStatement = connection.prepareStatement(deleteSQL1);
			// preparedStatement.setString(1, product.getAccessori());
			// preparedStatement.setString(2, product.getCustom());
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

	public ProductMoto doRetrieveByKey1(String targa, String codice_telaio) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ProductMoto bean = new ProductMoto();

		String selectSQL = "SELECT * FROM moto WHERE targa = ? and codice_telaio = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, codice_telaio);
			preparedStatement.setString(2, targa);

			Utility.print("doRetrieveByKey: " + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				// bean.setAccessori(rs.getString("accessori"));
				/// bean.setCustom(rs.getString("custom"));
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
	
	public void doInsertMoto(ProductMoto product) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO moto" + " (accessori,custom,codice_telaio,targa) VALUES (?, ?, ?, ?)";

		try {
			connection = ds.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setString(1, product.getAccessori());
			preparedStatement.setString(2, product.getCustom());
			preparedStatement.setString(3, product.getCodice_telaio());
			preparedStatement.setString(4, product.getTarga());

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

}