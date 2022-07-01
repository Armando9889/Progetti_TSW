package it.unisa.model.bean;

import java.io.Serializable;

public class ProductFiliale implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String partita_iva;
	String indirizzo;
	String cap;
	String nome;
	int numerotelefono;
	String email;
	int numerodipendenti;
	int fax;
	
	public ProductFiliale() {
		partita_iva="";
		indirizzo="";
		cap="";
		nome="";
		numerotelefono=0;
		email="";
		numerodipendenti=0;
		fax=0;
	}

	public String getPartita_iva() {
		return partita_iva;
	}

	public void setPartita_iva(String partita_iva) {
		this.partita_iva = partita_iva;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumerotelefono() {
		return numerotelefono;
	}

	public void setNumerotelefono(int numerotelefono) {
		this.numerotelefono = numerotelefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumerodipendenti() {
		return numerodipendenti;
	}

	public void setNumerodipendenti(int numerodipendenti) {
		this.numerodipendenti = numerodipendenti;
	}

	public int getFax() {
		return fax;
	}

	public void setFax(int fax) {
		this.fax = fax;
	}
	
	@Override
	public String toString() {
		return indirizzo + " (" + partita_iva + ") " + cap + ", " + nome + ", " + numerotelefono + ", " + email + ", " + numerodipendenti + ", " + fax;
	}

}
