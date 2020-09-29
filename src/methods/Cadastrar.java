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
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static ArrayList<Servico> servicos = new ArrayList<Servico>();
	private static String pathClientes = System.getProperty("user.home") + "\\clientes.ser";
	private static String pathServicos = System.getProperty("user.home") + "\\servicos.ser";
	
	@SuppressWarnings("unchecked")
	public static void cliente(Cliente e) throws Exception {
		//Verifica se arquivo existe
		//Se não existir -> cria novo arquivo em branco
		File temp = new File(pathClientes);
		if(!temp.exists()) {
			FileOutputStream output = new FileOutputStream(pathClientes);
			ObjectOutputStream escritor = new ObjectOutputStream(output);
			escritor.writeObject(clientes);
			escritor.close();;
		}
		
		//Lendo o arquivo de cadastros e salvando em lista local temporaria
		FileInputStream input = new FileInputStream(pathClientes);
		ObjectInputStream leitor = new ObjectInputStream(input);
		clientes = (ArrayList<Cliente>) leitor.readObject();
		leitor.close();
		
		//Adiciona o novo cliente à lista de cadastro
		clientes.add(e);
		
		//Salva lista de cadastros em arquivo no disco
		FileOutputStream output = new FileOutputStream(pathClientes);
		ObjectOutputStream escritor = new ObjectOutputStream(output);
		escritor.writeObject(clientes);
		escritor.close();;
	}
	
	@SuppressWarnings("unchecked")
	public static void servico(Servico e) throws Exception {
		//Verifica se arquivo existe
		//Se não existir -> cria novo arquivo em branco
		File temp = new File(pathServicos);
		if(!temp.exists()) {
			FileOutputStream output = new FileOutputStream(pathServicos);
			ObjectOutputStream escritor = new ObjectOutputStream(output);
			escritor.writeObject(servicos);
			escritor.close();;
		}
		
		//Lendo o arquivo de cadastros e salvando em lista local temporaria
		FileInputStream input = new FileInputStream(pathServicos);
		ObjectInputStream leitor = new ObjectInputStream(input);
		servicos = (ArrayList<Servico>) leitor.readObject();
		leitor.close();
		
		servicos.add(e);
		
		FileOutputStream output = new FileOutputStream(pathClientes);
		ObjectOutputStream escritor = new ObjectOutputStream(output);
		escritor.writeObject(clientes);
		escritor.close();;
	}
}
