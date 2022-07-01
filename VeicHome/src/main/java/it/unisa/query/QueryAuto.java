package it.unisa.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.sql.DataSource;

import it.unisa.model.bean.ProductAuto;
import it.unisa.model.bean.ProductMoto;
import it.unisa.model.bean.ProductVeicolo;
import it.unisa.utils.Utility;

public class QueryAuto {

	private DataSource ds = null;

	public QueryAuto(DataSource ds) {
		this.ds = ds;
	}

	public Collection<ProductAuto> doRetriveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "SELECT * FROM auto";

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		Collection<ProductAuto> products = new LinkedList<ProductAuto>();

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			Utility.print("doRetriveAll: " + preparedStatement.toString());

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ProductAuto auto = new ProductAuto();

				auto.setSconto(rs.getString("sconto"));
				auto.setNumero_di_passgeri(rs.getInt("numero_di_passegeri"));
				auto.setCodice_telaio(rs.getString("codice_telaio"));
				auto.setTarga(rs.getString("targa"));
				products.add(auto);
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

		return products;
	}

	public ProductAuto doRetrieveByKey1(String targa, String codice_telaio) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ProductAuto bean = new ProductAuto();

		String selectSQL = "SELECT * FROM auto WHERE targa = ? and codice_telaio = ?";

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

	public void doDelete1(ProductAuto product) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		// ProductVeicolo product1;
		// String deleteSQL = "DELETE FROM moto WHERE t = ?";
		String deleteSQL = "DELETE FROM auto WHERE targa = ? and codice_telaio = ?";
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

	public void doInsertAuto(ProductAuto product) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO auto" + " (sconto,numero_di_passegeri,codice_telaio,targa) VALUES (?, ?, ?, ?)";

		try {
			connection = ds.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setString(1, product.getSconto());
			preparedStatement.setInt(2, product.getNumero_di_passgeri());
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
