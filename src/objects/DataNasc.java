package objects;

import java.io.Serializable;


public class DataNasc implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		return "" + dia + "/" + mes + "/" + ano + "" ;
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
