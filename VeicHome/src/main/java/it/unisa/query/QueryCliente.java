
package it.unisa.query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.sql.DataSource;

import it.unisa.model.bean.ProductCliente;
import it.unisa.model.bean.ProductVeicolo;
import it.unisa.utils.Utility;

public class QueryCliente {

	private DataSource ds = null;

	public Collection<ProductCliente> doRetriveAll1(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "SELECT * FROM cliente";

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		Collection<ProductCliente> products1 = new LinkedList<ProductCliente>();

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			Utility.print("doRetriveAll: " + preparedStatement.toString());

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ProductCliente cliente = new ProductCliente();
				cliente.setCodice_fiscale(rs.getString("codice_fiscale"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCognome(rs.getString("cognome"));
				cliente.setSesso(rs.getString("sesso"));
				cliente.setIndirizzo(rs.getString("indirizzo"));
				cliente.setData_di_nascita(rs.getString("data_di_nascita"));
				products1.add(cliente);
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
		return products1;
	}

	public void doUpdate(ProductCliente product) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String updateSQL = "UPDATE product SET "
				+ " codice_fiscale = ?, nome = ?,  = ?, cognome = ? ,sesso = ?,indirizzo = ?,data_di_nascita = ?,password = ? ";

		try {
			connection = ds.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(updateSQL);

			preparedStatement.setString(1, product.getCodice_fiscale());
			preparedStatement.setString(2, product.getNome());
			preparedStatement.setString(3, product.getCognome());
			preparedStatement.setString(4, product.getSesso());
			preparedStatement.setString(5, product.getIndirizzo());
			preparedStatement.setString(6, product.getData_di_nascita());
			preparedStatement.setString(7, product.getPassword());

			Utility.print("doUpdate: " + preparedStatement.toString());
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

	public QueryCliente(DataSource ds) {
		this.ds = ds;
	}

	public void doSave(ProductCliente product) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO cliente"
				+ " (codice_fiscale,nome,cognome,sesso,indirizzo,data_di_nascita,password) VALUES (?, ?, ?, ?,?,?,?)";

		try {
			connection = ds.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setString(1, product.getCodice_fiscale());
			preparedStatement.setString(2, product.getNome());
			preparedStatement.setString(3, product.getCognome());
			preparedStatement.setString(4, product.getSesso());
			preparedStatement.setString(5, product.getIndirizzo());
			preparedStatement.setString(6, product.getData_di_nascita());
			preparedStatement.setString(7, product.getPassword());

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

	
	public ProductCliente doRetrieveByKey(String nome,String password) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ProductCliente bean = new ProductCliente();

		String selectSQL1 = "SELECT * FROM cliente WHERE nome = ? and password = ?";

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