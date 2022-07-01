package it.unisa.model.bean;

import java.io.Serializable;

public class ProductMoto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	String accessori;
	String custom;
	String codice_telaio;
	String targa;
	
	public ProductMoto() {
		accessori="";
		custom="";
		codice_telaio="";
		targa="";
	}

	public String getAccessori() {
		return accessori;
	}

	public void setAccessori(String accessori) {
		this.accessori = accessori;
	}

	public String getCustom() {
		return custom;
	}

	public void setCustom(String custom) {
		this.custom = custom;
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
		return accessori + " (" + codice_telaio + ") " + targa + ", " + custom;
	}
	

}
