package objects;

import java.io.Serializable;
import java.util.ArrayList;

public class Servico implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//------------------------------------------------------//
	//Atributos
	
	private String nome;
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	//------------------------------------------------------//
	//Construtor
	
	public Servico(String nome) {
		this.nome = nome;
	}
	
	//------------------------------------------------------//
	//Getters e Setters
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	
}
