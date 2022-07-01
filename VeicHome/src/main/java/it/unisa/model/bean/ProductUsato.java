package it.unisa.model.bean;

import java.io.Serializable;

public class ProductUsato implements Serializable {
	private static final long serialVersionUID = 1L;

	String anno_immatricolazione;
	int numero_km;
	String codice_telaio;
	String targa;
	
	public ProductUsato() {
		anno_immatricolazione = "";
		numero_km = 0;
		codice_telaio = "";
		targa = "";
	}

	public String getAnno_immatricolazione() {
		return anno_immatricolazione;
	}

	public void setAnno_immatricolazione(String anno_immatricolazione) {
		this.anno_immatricolazione = anno_immatricolazione;
	}

	public int getNumero_km() {
		return numero_km;
	}

	public void setNumero_km(int numero_km) {
		this.numero_km = numero_km;
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
		return anno_immatricolazione + "(" + numero_km + ")" + codice_telaio + "," + targa;
	}
}
