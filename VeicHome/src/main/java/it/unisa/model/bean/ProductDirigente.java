package it.unisa.model.bean;

public class ProductDirigente {
	
	 int sssn;   
	 int salario;
	 String livello;
	 String codice;
	 
	 public ProductDirigente() {
		 sssn=0;   
		 salario=0;
		 livello="";
		 codice="";
	 }

	public int getSssn() {
		return sssn;
	}

	public void setSssn(int sssn) {
		this.sssn = sssn;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public String getLivello() {
		return livello;
	}

	public void setLivello(String livello) {
		this.livello = livello;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}
	 
	@Override
	public String toString() {
		return  sssn +"("+salario+")"+livello+","+codice;
	}

}
