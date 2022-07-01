package it.unisa.query;

import it.unisa.model.bean.ProductMoto;
import it.unisa.model.bean.ProductVeicolo;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Collection;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.servlet.http.Part;
import javax.sql.DataSource;
import javax.swing.ImageIcon;

import org.apache.catalina.tribes.group.Response;



import it.unisa.utils.Utility;

public class QueryVeicolo {

	private DataSource ds = null;

	public QueryVeicolo(DataSource ds) {
		this.ds = ds;
	}

	public Collection<ProductVeicolo> doRetriveAll5(String order) throws SQLException, IOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "SELECT * FROM veicolo";

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		Collection<ProductVeicolo> products5 = new LinkedList<ProductVeicolo>();

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			Utility.print("doRetriveAll: " + preparedStatement.toString());
			OutputStream img;
			ResultSet rs = preparedStatement.executeQuery();
			String path="";
			byte b[] = null;
			
			
			while (rs.next()) {
				ProductVeicolo vei = new ProductVeicolo();
				vei.setCodice_telaio(rs.getString("codice_telaio"));
				vei.setTarga(rs.getString("targa"));
				vei.setColore(rs.getString("colore"));
				vei.setMarchio(rs.getString("marchio"));
				vei.setModello(rs.getString("modello"));
				vei.setKw(rs.getInt("kw"));
				vei.setPrezzo(rs.getInt("prezzo"));
				vei.setPartita_iva(rs.getString("partita_iva"));
				vei.setCodice_fiscale(rs.getString("codice_fiscale"));
				//vei.setPath(rs.getBinaryStream("path"));
				
				
				Blob blob = rs.getBlob("path");
				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte [] buffer = new byte[4096];
				int bytesRead = -1;
				
				while((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer,0,bytesRead);
				}
				
				byte [] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);
				inputStream.close();
				outputStream.close();
				vei.setBase64Image(base64Image);
				
				System.out.println(base64Image);
				//b = rs.getBytes("path");
				//
				//System.out.println(bis);
				//vei.setPath(bis);
				/*Blob imageBlob = rs.getBlob("path");
				b = imageBlob.getBytes(1, (int) imageBlob.length());
				ByteArrayInputStream bis = new ByteArrayInputStream(b);
				ImageIcon imageIcon = new ImageIcon(b);
				imageIcon.getImage();
				/*OutputStream os = rs.;
				os.write(b);
				os.flush();
				os.close();*/
				//InputStream binaryStream = imageBlob.getBinaryStream(0,imageBlob.length());
				
				//InputStream binaryStream = rs.getBinaryStream("path");vei.setPath(binaryStream);
				System.out.println("anche qui");

				//vei.setPath(rs.getBlob("path"));
				//vei.setPath(rs.getString("path"));
				products5.add(vei);
				System.out.println(products5);
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
		return products5;
	}

	public ProductVeicolo doRetrieveByKey1(String targa, String codice_telaio) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ProductVeicolo bean = new ProductVeicolo();

		String selectSQL1 = "SELECT * FROM veicolo WHERE targa = ? and codice_telaio = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL1);
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

	public ProductVeicolo doRetrieveByKey(String modello) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ProductVeicolo bean = new ProductVeicolo();

		String selectSQL1 = "SELECT * FROM veicolo WHERE modello = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL1);
			preparedStatement.setString(1, modello);

			Utility.print("doRetrieveByKey: " + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setModello(rs.getString("modello"));
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

	public void doDelete(ProductVeicolo product) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL1 = "DELETE FROM veicolo WHERE targa = ? and codice_telaio = ?";

		try {
			connection = ds.getConnection();
			connection.setAutoCommit(false);

			preparedStatement = connection.prepareStatement(deleteSQL1);
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
	
	
	public void doInsertVeicolo(ProductVeicolo product) throws SQLException, FileNotFoundException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO veicolo"
				+ " (codice_telaio,targa,colore,marchio,modello,kw,prezzo,partita_iva,codice_fiscale,path) VALUES (?, ?, ?, ?,?,?,?,?,null,?)";
		

		try {
			//System.out.println("ciao");
			//InputStream is = new FileInputStream(new File(product.getPath()));
			//System.out.println(product.getPath());
			connection = ds.getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setString(1, product.getCodice_telaio());
			System.out.println(product.getCodice_telaio());
			preparedStatement.setString(2, product.getTarga());
			preparedStatement.setString(3, product.getColore());
			preparedStatement.setString(4, product.getMarchio());
			preparedStatement.setString(5, product.getModello());
			preparedStatement.setInt(6, product.getKw());
			preparedStatement.setInt(7, product.getPrezzo());
			preparedStatement.setString(8, product.getPartita_iva());
			preparedStatement.setString(9, product.getCodice_fiscale());
			preparedStatement.setBlob(9,product.getPath());
			/*if(product.getPath() != null) {
				
			}*/
			
			
			
			
			
			
			
			
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
	
	
	
	public Collection<ProductVeicolo> cercaAuto(String order) throws SQLException, IOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		

		String selectSQL = "SELECT veicolo.modello,veicolo.path FROM veicolo INNER JOIN auto on veicolo.codice_telaio = auto.codice_telaio";
		
		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}
		
		Collection<ProductVeicolo> products5 = new LinkedList<ProductVeicolo>();

		try {
			connection = ds.getConnection();		
			preparedStatement = connection.prepareStatement(selectSQL);

			Utility.print("doRetriveAll: " + preparedStatement.toString());

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ProductVeicolo vei = new ProductVeicolo();
				//vei.setCodice_telaio(rs.getString("codice_telaio"));
				//vei.setTarga(rs.getString("targa"));
				//vei.setColore(rs.getString("colore"));
				//vei.setMarchio(rs.getString("marchio"));
				vei.setModello(rs.getString("modello"));
				//vei.setKw(rs.getInt("kw"));
				//vei.setPrezzo(rs.getInt("prezzo"));
				//vei.setPartita_iva(rs.getString("partita_iva"));
				//vei.setCodice_fiscale(rs.getString("codice_fiscale"));
				//vei.setPath(rs.getString("path"));
				
				Blob blob = rs.getBlob("path");
				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte [] buffer = new byte[4096];
				int bytesRead = -1;
				
				while((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer,0,bytesRead);
				}
				
				byte [] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);
				inputStream.close();
				outputStream.close();
				vei.setBase64Image(base64Image);
				
				System.out.println(base64Image);
				//b = rs.getBytes("path");
				//
				//System.out.println(bis);
				//vei.setPath(bis);
				/*Blob imageBlob = rs.getBlob("path");
				b = imageBlob.getBytes(1, (int) imageBlob.length());
				ByteArrayInputStream bis = new ByteArrayInputStream(b);
				ImageIcon imageIcon = new ImageIcon(b);
				imageIcon.getImage();
				/*OutputStream os = rs.;
				os.write(b);
				os.flush();
				os.close();*/
				//InputStream binaryStream = imageBlob.getBinaryStream(0,imageBlob.length());
				
				//InputStream binaryStream = rs.getBinaryStream("path");vei.setPath(binaryStream);
				System.out.println("anche qui");

				//vei.setPath(rs.getBlob("path"));
				//vei.setPath(rs.getString("path"));
				
				
				
				
				
				
				
				
				products5.add(vei);
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
		return products5;
	}
	
	public Collection<ProductVeicolo> cercaMoto(String order) throws SQLException, IOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		

		String selectSQL = "SELECT veicolo.modello,veicolo.path FROM veicolo INNER JOIN moto on veicolo.codice_telaio = moto.codice_telaio";
		
		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}
		
		Collection<ProductVeicolo> products5 = new LinkedList<ProductVeicolo>();

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			Utility.print("doRetriveAll: " + preparedStatement.toString());

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ProductVeicolo vei = new ProductVeicolo();
				//vei.setCodice_telaio(rs.getString("codice_telaio"));
				//vei.setTarga(rs.getString("targa"));
				//vei.setColore(rs.getString("colore"));
				//vei.setMarchio(rs.getString("marchio"));
				vei.setModello(rs.getString("modello"));
				//vei.setKw(rs.getInt("kw"));
				//vei.setPrezzo(rs.getInt("prezzo"));
				//vei.setPartita_iva(rs.getString("partita_iva"));
				//vei.setCodice_fiscale(rs.getString("codice_fiscale"));
				//vei.setPath(rs.getString("path"));
				
				Blob blob = rs.getBlob("path");
				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte [] buffer = new byte[4096];
				int bytesRead = -1;
				
				while((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer,0,bytesRead);
				}
				
				byte [] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);
				inputStream.close();
				outputStream.close();
				vei.setBase64Image(base64Image);
				
				System.out.println(base64Image);
				//b = rs.getBytes("path");
				//
				//System.out.println(bis);
				//vei.setPath(bis);
				/*Blob imageBlob = rs.getBlob("path");
				b = imageBlob.getBytes(1, (int) imageBlob.length());
				ByteArrayInputStream bis = new ByteArrayInputStream(b);
				ImageIcon imageIcon = new ImageIcon(b);
				imageIcon.getImage();
				/*OutputStream os = rs.;
				os.write(b);
				os.flush();
				os.close();*/
				//InputStream binaryStream = imageBlob.getBinaryStream(0,imageBlob.length());
				
				//InputStream binaryStream = rs.getBinaryStream("path");vei.setPath(binaryStream);
				System.out.println("anche qui");

				//vei.setPath(rs.getBlob("path"));
				//vei.setPath(rs.getString("path"));
				
				
				products5.add(vei);
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
		return products5;
	}
	
	
	
	
}
