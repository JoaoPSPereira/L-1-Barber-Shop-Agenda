package objects;

import java.util.ArrayList;

import interfaces.Crud;

public class Servicos implements Crud{
	//------------------------------------------------------//
	//Atributos
	
	private String nome;
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	//------------------------------------------------------//
	//Construtor
	
	public Servicos(String nome) {
		super();
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

	//------------------------------------------------------//	
	//Métodos da Interface Crud 
	
	@Override
	public void cadastrar() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void editar() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void excluir() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void listar() {
		// TODO Auto-generated method stub
		
	}
	
	
}
