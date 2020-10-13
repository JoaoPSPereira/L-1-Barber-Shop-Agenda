package objects;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Produto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//------------------------------------------------------//
	//Atributos
	private String nome;
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static String pathClientes = System.getProperty("user.home") + "\\Desktop\\clientes.ser";
	
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
	@SuppressWarnings("unchecked")
	public boolean addCliente(String alvo) throws IOException, ClassNotFoundException {
		
		FileInputStream input = new FileInputStream(pathClientes);
		ObjectInputStream leitor = new ObjectInputStream(input);
		ArrayList<Cliente> clientesSer = (ArrayList<Cliente>) leitor.readObject();
		leitor.close();
		
		String nomealvo = alvo.toLowerCase().trim();
		
		for(Cliente c : clientesSer) {
			
			String nomec = c.getNome().toLowerCase().trim();
			
			if (nomec.equals(nomealvo)) {
				this.clientes.add(c);
				return true;
			}
			
		}
		return false;
	}

}
