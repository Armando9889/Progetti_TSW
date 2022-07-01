package it.unisa.model.bean;

public class ProductCliente {

	String codice_fiscale;
	String nome;            
	String cognome;         
    String sesso;           
    String indirizzo;       
	String data_di_nascita;
	String password;
	
	
	public ProductCliente() {
		codice_fiscale="";
		nome="";            
		cognome="";         
	    sesso="";           
	    indirizzo="";       
		data_di_nascita="";
		password="";
		
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCodice_fiscale() {
		return codice_fiscale;
	}


	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
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


	public String getSesso() {
		return sesso;
	}


	public void setSesso(String sesso) {
		this.sesso = sesso;
	}


	public String getIndirizzo() {
		return indirizzo;
	}


	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}


	public String getData_di_nascita() {
		return data_di_nascita;
	}


	public void setData_di_nascita(String data_di_nascita) {
		this.data_di_nascita = data_di_nascita;
	}
	
	@Override
	public String toString() {
		return  codice_fiscale +"("+nome+")"+cognome+","+sesso+","+indirizzo+","+data_di_nascita;
	}
	
}
