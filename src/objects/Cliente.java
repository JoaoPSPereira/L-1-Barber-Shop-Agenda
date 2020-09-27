package objects;

import java.io.Serializable;

/*Classe que representa o objeto Cliente*/


public class Cliente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//------------------------------------------------------//
	//Atributos
	private String nome;
	private String telefone;
	private String nascimento;
	private int genero;
	
	//------------------------------------------------------//
	//Construtor
	public Cliente(String nome, String telefone, String nascimento, int genero) {
		this.nome = nome;
		this.telefone = telefone;
		this.nascimento = nascimento;
		this.genero = genero;
	}
	
	//------------------------------------------------------//
	//Método toString
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", telefone=" + telefone + ", nascimento=" + nascimento + ", genero=" + genero
				+ "]";
	}

	
	
	//------------------------------------------------------//
	//Getters e Setters
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	public int getGenero() {
		return genero;
	}
	public void setGenero(int genero) {
		this.genero = genero;
	}
	

	
}
