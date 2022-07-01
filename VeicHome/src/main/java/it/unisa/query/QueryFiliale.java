package it.unisa.query;
import it.unisa.model.bean.ProductFiliale;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.sql.DataSource;


import it.unisa.utils.Utility;

public class QueryFiliale{

	private DataSource ds = null;

	public QueryFiliale(DataSource ds) {
		this.ds = ds;
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
}
