package it.unisa.query;
import it.unisa.model.bean.ProductPagamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.sql.DataSource;
import it.unisa.utils.Utility;

public class QueryPagamento{

	private DataSource ds = null;

	public QueryPagamento(DataSource ds) {
		this.ds = ds;
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
}
