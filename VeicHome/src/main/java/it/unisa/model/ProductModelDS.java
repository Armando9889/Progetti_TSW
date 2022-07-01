package it.unisa.model;

/*NON UTILIZIAMO*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.sql.DataSource;

import it.unisa.model.bean.ProductAuto;
import it.unisa.model.bean.ProductCliente;
import it.unisa.model.bean.ProductDirigente;
import it.unisa.model.bean.ProductFiliale;
import it.unisa.model.bean.ProductMoto;
import it.unisa.model.bean.ProductPagamento;
import it.unisa.model.bean.ProductProprietari;
import it.unisa.model.bean.ProductUsato;
import it.unisa.model.bean.ProductVeicolo;
import it.unisa.utils.Utility;

public class ProductModelDS implements ProductModel<ProductAuto> {

	private DataSource ds = null;

	public ProductModelDS(DataSource ds) {
		this.ds = ds;
	}

	
	@Override
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
	
	public Collection<ProductCliente> doRetriveAll1(String order) throws SQLException {
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		
		String selectSQL="SELECT * FROM cliente";
		
		if(order!=null && !order.equals("")) {
			selectSQL +=" ORDER BY "+ order;
		}
		
		Collection<ProductCliente> products1= new LinkedList<ProductCliente>();
		
		try {
			connection = ds.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			
			Utility.print("doRetriveAll: "+preparedStatement.toString());
			
			ResultSet rs= preparedStatement.executeQuery();
			
			while(rs.next()) {
				ProductCliente cliente= new ProductCliente();
				cliente.setCodice_fiscale(rs.getString("codice_fiscale"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCognome(rs.getString("cognome"));
				cliente.setSesso(rs.getString("sesso"));
				cliente.setIndirizzo(rs.getString("indirizzo"));
				cliente.setData_di_nascita(rs.getString("data_di_nascita"));
				products1.add(cliente);
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
		return products1;
	}
	
	public Collection<ProductDirigente> doRetriveAll2(String order) throws SQLException {
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		
		String selectSQL="SELECT * FROM dirigente";
		
		if(order!=null && !order.equals("")) {
			selectSQL +=" ORDER BY "+ order;
		}
		
		Collection<ProductDirigente> products2= new LinkedList<ProductDirigente>();
		
		try {
			connection = ds.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			
			Utility.print("doRetriveAll: "+preparedStatement.toString());
			
			ResultSet rs= preparedStatement.executeQuery();
			
			while(rs.next()) {
				ProductDirigente dir= new ProductDirigente();
				dir.setSssn(rs.getInt("sssn"));
				dir.setSalario(rs.getInt("salario"));
				dir.setLivello(rs.getString("livello"));
				dir.setCodice(rs.getString("codice"));
				products2.add(dir);
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
		return products2;
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
		
	public Collection<ProductVeicolo> doRetriveAll5(String order) throws SQLException {
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		
		String selectSQL="SELECT * FROM veicolo";
		
		if(order!=null && !order.equals("")) {
			selectSQL +=" ORDER BY "+ order;
		}
		
		Collection<ProductVeicolo> products5= new LinkedList<ProductVeicolo>();
		
		try {
			connection = ds.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			
			Utility.print("doRetriveAll: "+preparedStatement.toString());
			
			ResultSet rs= preparedStatement.executeQuery();
			
			while(rs.next()) {
				ProductVeicolo vei= new ProductVeicolo();
				vei.setCodice_telaio(rs.getString("codice_telaio"));
				vei.setTarga(rs.getString("targa"));
				vei.setColore(rs.getString("colore"));
				vei.setMarchio(rs.getString("marchio"));
				vei.setModello(rs.getString("modello"));
				vei.setKw(rs.getInt("kw"));
				vei.setPrezzo(rs.getInt("prezzo"));
				vei.setPartita_iva(rs.getString("partita_iva"));
				vei.setCodice_fiscale(rs.getString("codice_fiscale"));
				products5.add(vei);
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
		return products5;
	}
	
	public Collection<ProductFiliale> doRetriveAll6(String order) throws SQLException {
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		
		String selectSQL="SELECT * FROM filiale";
		
		if(order!=null && !order.equals("")) {
			selectSQL +=" ORDER BY "+ order;
		}
		
		Collection<ProductFiliale> products6= new LinkedList<ProductFiliale>();
		
		try {
			connection = ds.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			
			Utility.print("doRetriveAll: "+preparedStatement.toString());
			
			ResultSet rs= preparedStatement.executeQuery();
			
			while(rs.next()) {
				ProductFiliale filiale= new ProductFiliale();
				filiale.setPartita_iva(rs.getString("partita_iva"));
				filiale.setIndirizzo(rs.getString("indirizzo"));
				filiale.setCap(rs.getString("cap"));
				filiale.setNome(rs.getString("nome"));
				filiale.setNumerotelefono(rs.getInt("numerotelefono"));
				filiale.setEmail(rs.getString("email"));
				filiale.setNumerodipendenti(rs.getInt("numerodipendenti"));
				filiale.setFax(rs.getInt("fax"));
				products6.add(filiale);
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
		return products6;
	}
	
	public Collection<ProductMoto> doRetriveAll7(String order) throws SQLException {
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		
		String selectSQL="SELECT * FROM moto";
		
		if(order!=null && !order.equals("")) {
			selectSQL +=" ORDER BY "+ order;
		}
		
		Collection<ProductMoto> products7= new LinkedList<ProductMoto>();
		
		try {
			connection = ds.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			
			Utility.print("doRetriveAll: "+preparedStatement.toString());
			
			ResultSet rs= preparedStatement.executeQuery();
			
			while(rs.next()) {
				ProductMoto moto= new ProductMoto();
				moto.setAccessori(rs.getString("accessori"));
				moto.setCustom(rs.getString("custom"));
				moto.setCodice_telaio(rs.getString("codice_telaio"));
				moto.setTarga(rs.getString("targa"));
				products7.add(moto);
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
		
	public Collection<ProductPagamento> doRetriveAll8(String order) throws SQLException {
		Connection connection =null;
		PreparedStatement preparedStatement=null;
		
		String selectSQL="SELECT * FROM pagamento";
		
		if(order!=null && !order.equals("")) {
			selectSQL +=" ORDER BY "+ order;
		}
		
		Collection<ProductPagamento> products8= new LinkedList<ProductPagamento>();
		
		try {
			connection = ds.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			
			Utility.print("doRetriveAll: "+preparedStatement.toString());
			
			ResultSet rs= preparedStatement.executeQuery();
			
			while(rs.next()) {
				ProductPagamento pagamento = new ProductPagamento();
				pagamento.setTipo_di_pagamento(rs.getString("tipo_di_pagamento"));
				pagamento.setData_acquisto(rs.getString("data_acquisto"));
				pagamento.setNumero_pagamento(rs.getInt("numero_pagamento"));
				pagamento.setCodice_fiscale(rs.getString("codice_fiscale"));
				products8.add(pagamento);
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
		return products8;
	}
	
	
	
	
	
	/*
	@Override
	public Collection<ProductFiliale> doRetriveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "SELECT * FROM filiale";

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		Collection<ProductFiliale> products = new LinkedList<ProductFiliale>();

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			Utility.print("doRetriveAll: " + preparedStatement.toString());

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ProductFiliale filiale = new ProductFiliale();
				/*
				auto.setSconto(rs.getString("sconto"));
				auto.setNumero_di_passgeri(rs.getInt("numero_di_passegeri"));
				auto.setCodice_telaio(rs.getString("codice_telaio"));
				auto.setTarga(rs.getString("targa"));
				products.add(auto);
				
				filiale.setPartita_iva(rs.getString("partita_iva"));
				filiale.setIndirizzo(rs.getString("indirizzo"));
				filiale.setCap(rs.getString("cap"));
				filiale.setNome(rs.getString("nome"));
				filiale.setNumerotelefono(rs.getInt("numerotelefono"));
				filiale.setEmail(rs.getString("email"));
				filiale.setNumerodipendenti(rs.getInt("numerodipendenti"));
				filiale.setFax(rs.getInt("fax"));
				products.add(filiale);
				
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
	*/
	
	public ProductMoto doRetrieveByKey(String targa,String codice_telaio) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ProductMoto bean = new ProductMoto();

		String selectSQL = "SELECT * FROM moto WHERE targa = ? and codice_telaio = ?";
		
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			//preparedStatement = connection.prepareStatement(selectSQL1);
			preparedStatement.setString(1, codice_telaio);
			preparedStatement.setString(2, targa);

			Utility.print("doRetrieveByKey: " + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				//bean.setAccessori(rs.getString("accessori"));
				///bean.setCustom(rs.getString("custom"));
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
	
	public ProductVeicolo doRetrieveByKey1(String targa,String codice_telaio) throws SQLException {
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


	@Override
	public void doSave(ProductAuto item) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doUpdate(ProductAuto item) throws SQLException {
		// TODO Auto-generated method stub

	}
	
	public void doUpdate(ProductCliente product) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String updateSQL = "UPDATE product SET " + " codice_fiscale = ?, nome = ?,  = ?, cognome = ? ,sesso = ?,indirizzo = ?,data_di_nascita = ? ";

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
	
	public void doSave(ProductCliente product) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO cliente" + " (codice_fiscale,nome,cognome,sesso,indirizzo,data_di_nascita) VALUES (?, ?, ?, ?,?,?)";

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
	
public void doDelete(ProductMoto product) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		//ProductVeicolo product1;
		//String deleteSQL = "DELETE FROM moto WHERE t = ?";
		String deleteSQL = "DELETE FROM moto WHERE targa = ? and codice_telaio = ?";
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


	@Override
	public void doDelete(ProductAuto item) throws SQLException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public ProductAuto doRetriveByKey(String code) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public void doDelete(ProductAuto item) throws SQLException {
		// TODO Auto-generated method stub

	}*/

}
