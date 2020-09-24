package objects;

import java.util.ArrayList;

import interfaces.crud;

public class Servicos implements crud{
	private String nome;
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	
	public Servicos(String nome) {
		super();
		this.nome = nome;
	}
	
	
	
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



	@Override
	public void Cadastrar() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void Editar() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void Excluir() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void Listar() {
		// TODO Auto-generated method stub
		
	}
	
	
}
