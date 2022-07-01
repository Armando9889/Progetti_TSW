package it.unisa.model.bean;

import java.io.Serializable;

public class ProductImpiegato implements Serializable{
	
	private static final long serialVersionUID = 1L;
	String codice;
	String nome;
	String cognome;
	String codice_fiscale;
	String data_assunzione;
	String partita_iva;
	String password;
	
	public ProductImpiegato() {
		codice = "";
		nome = "";
		cognome = "";
		codice_fiscale = "";
		data_assunzione = "";
		partita_iva = "";
		password = "";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodice_fiscale() {
		return codice_fiscale;
	}

	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}

	public String getData_assunzione() {
		return data_assunzione;
	}

	public void setData_assunzione(String data_assunzione) {
		this.data_assunzione = data_assunzione;
	}

	public String getPartita_iva() {
		return partita_iva;
	}

	public void setPartita_iva(String partita_iva) {
		this.partita_iva = partita_iva;
	}
}