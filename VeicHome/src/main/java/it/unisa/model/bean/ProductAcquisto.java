package it.unisa.model.bean;

import java.io.Serializable;

public class ProductAcquisto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	String targa;
	String codice_telaio;
	String modello;
	int prezzo;
	String codice_fiscale;
	//String path;
	
	

	public ProductAcquisto(){
		targa="";
		codice_telaio="";
		modello="";
		prezzo=0;
		codice_fiscale="";
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public String getCodice_telaio() {
		return codice_telaio;
	}

	public void setCodice_telaio(String codice_telaio) {
		this.codice_telaio = codice_telaio;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public String getCodice_fiscale() {
		return codice_fiscale;
	}

	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}	
	
	
	/*public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}*/

}
