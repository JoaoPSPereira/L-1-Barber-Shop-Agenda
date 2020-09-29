package methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import objects.*;

public class Cadastrar implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Servico> servicos = new ArrayList<Servico>();
	private String pathClientes = System.getProperty("user.home") + "\\clientes.ser";
	private String pathServicos = System.getProperty("user.home") + "\\servicos.ser";
	
	@SuppressWarnings("unchecked")
	public void cliente(Cliente e) throws Exception {
		//Verifica se arquivo existe
		//Se não existir -> cria novo arquivo em branco
		File temp = new File(this.pathClientes);
		if(!temp.exists()) {
			FileOutputStream output = new FileOutputStream(this.pathClientes);
			ObjectOutputStream escritor = new ObjectOutputStream(output);
			escritor.writeObject(this.clientes);
			escritor.close();;
		}
		
		//Lendo o arquivo de cadastros e salvando em lista local temporaria
		FileInputStream input = new FileInputStream(this.pathClientes);
		ObjectInputStream leitor = new ObjectInputStream(input);
		this.clientes = (ArrayList<Cliente>) leitor.readObject();
		leitor.close();
		
		//Adiciona o novo cliente à lista de cadastro
		this.clientes.add(e);
		
		//Salva lista de cadastros em arquivo no disco
		FileOutputStream output = new FileOutputStream(this.pathClientes);
		ObjectOutputStream escritor = new ObjectOutputStream(output);
		escritor.writeObject(this.clientes);
		escritor.close();;
	}
	
	@SuppressWarnings("unchecked")
	public void servico(Servico e) throws Exception {
		//Verifica se arquivo existe
		//Se não existir -> cria novo arquivo em branco
		File temp = new File(this.pathServicos);
		if(!temp.exists()) {
			FileOutputStream output = new FileOutputStream(this.pathServicos);
			ObjectOutputStream escritor = new ObjectOutputStream(output);
			escritor.writeObject(this.servicos);
			escritor.close();;
		}
		
		//Lendo o arquivo de cadastros e salvando em lista local temporaria
		FileInputStream input = new FileInputStream(this.pathServicos);
		ObjectInputStream leitor = new ObjectInputStream(input);
		this.servicos = (ArrayList<Servico>) leitor.readObject();
		leitor.close();
		
		this.servicos.add(e);
		
		FileOutputStream output = new FileOutputStream(this.pathClientes);
		ObjectOutputStream escritor = new ObjectOutputStream(output);
		escritor.writeObject(this.clientes);
		escritor.close();;
	}
}
