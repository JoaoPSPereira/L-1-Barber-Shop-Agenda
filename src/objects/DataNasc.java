package objects;

public class DataNasc {
	

	int dia;
	int mes;
	int ano;
	public DataNasc(int dia, int mes, int ano) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	//------------------------------------------------------//
	//Getters e Setters
	
	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}
	
	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAno() {
		return ano;
	}

	
	
}
