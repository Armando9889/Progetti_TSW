package it.unisa.model.bean;

import java.io.Serializable;

public class ProductProprietari implements Serializable{
	private static final long serialVersionUID = 1L;
	String proprietari;
	String codice_telaio;
	String targa;
	
	public ProductProprietari() {
		proprietari = "";
		codice_telaio = "";
		targa = "";
	}

	public String getProprietari() {
		return proprietari;
	}

	public void setProprietari(String proprietari) {
		this.proprietari = proprietari;
	}

	public String getCodice_telaio() {
		return codice_telaio;
	}

	public void setCodice_telaio(String codice_telaio) {
		this.codice_telaio = codice_telaio;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}
	@Override
	public String toString() {
		return proprietari + "(" + codice_telaio + ")" +targa;
	}
}
