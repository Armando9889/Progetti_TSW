package it.unisa.model.bean;

import java.io.Serializable;

public class ProductPagamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String tipo_di_pagamento;
	String data_acquisto;
	int numero_pagamento;
	String codice_fiscale;
	
	public ProductPagamento() {
		tipo_di_pagamento="";
		data_acquisto="";
		numero_pagamento=0;
		codice_fiscale="";
	}

	public String getTipo_di_pagamento() {
		return tipo_di_pagamento;
	}

	public void setTipo_di_pagamento(String tipo_di_pagamento) {
		this.tipo_di_pagamento = tipo_di_pagamento;
	}

	public String getData_acquisto() {
		return data_acquisto;
	}

	public void setData_acquisto(String data_acquisto) {
		this.data_acquisto = data_acquisto;
	}

	public int getNumero_pagamento() {
		return numero_pagamento;
	}

	public void setNumero_pagamento(int numero_pagamento) {
		this.numero_pagamento = numero_pagamento;
	}

	public String getCodice_fiscale() {
		return codice_fiscale;
	}

	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}
	
	public String toString() {
		return tipo_di_pagamento + " (" + numero_pagamento + ") " + data_acquisto + ", " + codice_fiscale;
	}

}
