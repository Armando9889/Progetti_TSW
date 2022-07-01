package it.unisa.query;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Collection;
import java.util.LinkedList;

import javax.sql.DataSource;

import it.unisa.model.bean.ProductCarrello;
import it.unisa.model.bean.ProductMoto;
import it.unisa.model.bean.ProductVeicolo;
import it.unisa.utils.Utility;

public class QueryCarrello {

	
	private DataSource ds = null;

	public QueryCarrello(DataSource ds) {
		this.ds = ds;
	}

public void doSave(ProductCarrello product) throws SQLException {
	Connection connection = null;
	PreparedStatement preparedStatement = null;

	String insertSQL = "INSERT INTO carrello"+ " (targa,codice_telaio,modello,prezzo,sessionid) VALUES (?, ?,?,?,?)";

	try {
		connection = ds.getConnection();
		connection.setAutoCommit(false);
		preparedStatement = connection.prepareStatement(insertSQL);

		preparedStatement.setString(1, product.getTarga());
		preparedStatement.setString(2, product.getCodice_telaio());
		preparedStatement.setString(3, product.getModello());
		preparedStatement.setInt(4, product.getPrezzo());
		preparedStatement.setString(5, product.getSessionid());
		//preparedStatement.setBlob(5, product.getPath());
		
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
	



public Collection<ProductCarrello> doRetriveAll(String order) throws SQLException, IOException {
	Connection connection =null;
	PreparedStatement preparedStatement=null;
	
	String selectSQL="SELECT * FROM carrello";
	
	if(order!=null && !order.equals("")) {
		selectSQL +=" ORDER BY "+ order;
	}
	
	Collection<ProductCarrello> products7= new LinkedList<ProductCarrello>();
	
	try {
		connection = ds.getConnection();
		preparedStatement=connection.prepareStatement(selectSQL);
		
		Utility.print("doRetriveAll: "+preparedStatement.toString());
		
		ResultSet rs= preparedStatement.executeQuery();
		
		while(rs.next()) {
			ProductCarrello cr= new ProductCarrello();
			cr.setTarga(rs.getString("targa"));
			cr.setCodice_telaio(rs.getString("codice_telaio"));
			cr.setModello(rs.getString("modello"));
			cr.setPrezzo(rs.getInt("prezzo"));
			cr.setSessionid(rs.getString("sessionid"));
			//cr.setPath(rs.getString("path"));
			
			//Blob blob = rs.getBlob("path");
			//InputStream inputStream = blob.getBinaryStream();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			//byte [] buffer = new byte [4096];
			//int bytesRead = -1;
			
			//while((bytesRead = inputStream.read(buffer)) != -1) {
				//outputStream.write(buffer,0,bytesRead);
			//}
			
			//byte [] imageBytes = outputStream.toByteArray();
			//String base64Image = Base64.getEncoder().encodeToString(imageBytes);
			//inputStream.close();
			outputStream.close();
			//cr.setBase64Image(base64Image);
			

			
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

	String deleteSQL1 = "DELETE FROM carrello";

	

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


public ProductCarrello doRetrieveByKey(String sessionid) throws SQLException {
	Connection connection = null;
	PreparedStatement preparedStatement = null;

	ProductCarrello bean = new ProductCarrello();

	String selectSQL1 = "SELECT * FROM carrello WHERE sessionid = ?";

	try {
		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(selectSQL1);
		preparedStatement.setString(1, sessionid);

		Utility.print("doRetrieveByKey: " + preparedStatement.toString());
		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			bean.setModello(rs.getString("sessionid"));
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


public void doDelete(String product) throws SQLException {

	Connection connection = null;
	PreparedStatement preparedStatement = null;

	String deleteSQL1 = "DELETE FROM carrello WHERE sessionid = ?";

	try {
		connection = ds.getConnection();
		connection.setAutoCommit(false);

		preparedStatement = connection.prepareStatement(deleteSQL1);
		preparedStatement.setString(1, product);


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
	



