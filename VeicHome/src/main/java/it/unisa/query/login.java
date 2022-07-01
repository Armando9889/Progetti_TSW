package it.unisa.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import it.unisa.model.bean.ProductCliente;
import it.unisa.model.bean.ProductImpiegato;
import it.unisa.utils.Utility;

public class login {

	private DataSource ds = null;

	public login(DataSource ds) {
		this.ds = ds;
	}

	public boolean login_user(String nome, String password) throws SQLException {

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
				// bean.setAccessori(rs.getString("accessori"));
				/// bean.setCustom(rs.getString("custom"));
				bean.setNome(rs.getString("nome"));
				bean.setPassword(rs.getString("password"));

				return true;
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

		return false;
	}

	public boolean login_admin(String nome, String password) throws SQLException {
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
				// bean.setAccessori(rs.getString("accessori"));
				/// bean.setCustom(rs.getString("custom"));
				bean.setNome(rs.getString("nome"));
				bean.setPassword(rs.getString("password"));

				return true;
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

		return false;
	}

}
