package it.unisa.model.bean;

import java.io.InputStream;
import java.io.Serializable;

public class ProductCarrello implements Serializable {

	private static final long serialVersionUID = 1L;

	String codice_telaio;
	String targa;
	String modello;
	int prezzo;
	// String path;
	//InputStream path;
	String base64Image;
	String sessionid;
	
	public ProductCarrello() {
		codice_telaio = "";
		targa = "";
		modello = "";
		prezzo = 0;
		sessionid="";
	}

	//public InputStream getPath() {
		//return path;
	//}

	//public void setPath(InputStream path) {
	//	this.path = path;
	//}

	public String getSessionid() {
		return sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
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

}
