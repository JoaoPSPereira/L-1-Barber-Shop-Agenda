package locals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import objects.Cliente;
import objects.Servico;



public class Ler {
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static ArrayList<Servico> servicos = new ArrayList<Servico>();
	private static String pathClientes = Path.clientes();
	private static String pathServicos = Path.servicos();

	@SuppressWarnings("unchecked")
	public static ArrayList<Cliente> clientes() throws IOException, ClassNotFoundException{
		//Verifica se arquivo existe
		//Se não existir -> cria novo arquivo em branco
		File temp = new File(pathClientes);
		if(!temp.exists()) {
			FileOutputStream output = new FileOutputStream(pathClientes);
			ObjectOutputStream escritor = new ObjectOutputStream(output);
			escritor.writeObject(clientes);
			escritor.close();;
		}
				
		FileInputStream input = new FileInputStream(pathClientes);
		ObjectInputStream leitor = new ObjectInputStream(input);
		clientes = (ArrayList<Cliente>) leitor.readObject();
		leitor.close();
		
		return clientes;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Servico> servicos() throws IOException, ClassNotFoundException{
		//Verifica se arquivo existe
		//Se não existir -> cria novo arquivo em branco
		File temp = new File(pathServicos);
		if(!temp.exists()) {
			FileOutputStream output = new FileOutputStream(pathServicos);
			ObjectOutputStream escritor = new ObjectOutputStream(output);
			escritor.writeObject(servicos);
			escritor.close();;
		}
				
		FileInputStream input = new FileInputStream(pathServicos);
		ObjectInputStream leitor = new ObjectInputStream(input);
		servicos = (ArrayList<Servico>) leitor.readObject();
		leitor.close();
		
		return servicos;
	}
}