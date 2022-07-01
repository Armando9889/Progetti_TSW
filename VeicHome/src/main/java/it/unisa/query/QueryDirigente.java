package it.unisa.query;
import it.unisa.model.bean.ProductDirigente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.sql.DataSource;


import it.unisa.utils.Utility;

public class QueryDirigente {

	private DataSource ds = null;

	public QueryDirigente(DataSource ds) {
		this.ds = ds;
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

}
