package it.unisa.model.bean;

import java.io.Serializable;

public class ProductAuto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	String sconto;
	int numero_di_passgeri;
	String codice_telaio;
	String targa;
	
	public ProductAuto() {
		sconto="";
		numero_di_passgeri=0;
		codice_telaio="";
		targa="";
	}

	public String getSconto() {
		return sconto;
	}

	public void setSconto(String sconto) {
		this.sconto = sconto;
	}

	public int getNumero_di_passgeri() {
		return numero_di_passgeri;
	}

	public void setNumero_di_passgeri(int numero_di_passgeri) {
		this.numero_di_passgeri = numero_di_passgeri;
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
		return sconto + " (" + numero_di_passgeri + ") " + codice_telaio + ", " + targa;
	}

}
