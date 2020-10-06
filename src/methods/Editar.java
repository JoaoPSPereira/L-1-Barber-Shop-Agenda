package methods;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import objects.Cliente;
import objects.Servico;

public class Editar {
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static ArrayList<Servico> servicos = new ArrayList<Servico>();
	private static String pathClientes = System.getProperty("user.home") + "\\clientes.ser";
	private static String pathServicos = System.getProperty("user.home") + "\\servicos.ser";
	
	@SuppressWarnings("unchecked")
	public static boolean cliente(String alvo, Cliente novo) throws Exception{
		
		//Lendo o arquivo de cadastros e salvando em lista local temporaria
		FileInputStream input = new FileInputStream(pathClientes);
		ObjectInputStream leitor = new ObjectInputStream(input);
		clientes = (ArrayList<Cliente>) leitor.readObject();
		leitor.close();
		
		
		//Percorre a lista contendo os cadastros de clientes
		for(Cliente c : clientes) {
			if (c.getNome().toUpperCase() == alvo.toUpperCase()) {
				/*Se o nome do objeto sendo percorrido é igual ao 
				nome do objeto alvo, remove o objeto da lista*/
				int index = clientes.indexOf(c);
				clientes.remove(c);
				
				clientes.add(index, novo);
				
				FileOutputStream output = new FileOutputStream(pathClientes);
				ObjectOutputStream escritor = new ObjectOutputStream(output);
				escritor.writeObject(clientes);
				escritor.close();;
				
				return true;
			}
		}
		return false;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public static boolean servico(String alvo, Servico novo) throws Exception{
			
		//Lendo o arquivo de cadastros e salvando em lista local temporaria
		FileInputStream input = new FileInputStream(pathServicos);
		ObjectInputStream leitor = new ObjectInputStream(input);
		servicos = (ArrayList<Servico>) leitor.readObject();
		leitor.close();
		
		
		//Percorre a lista contendo os cadastros de clientes
		for(Servico s : servicos) {
			if (s.getNome().toUpperCase() == alvo.toUpperCase()) {
				/*Se o nome do objeto sendo percorrido é igual ao 
				nome do objeto alvo, remove o objeto da lista*/
				int index = servicos.indexOf(s);
				servicos.remove(s);
				
				servicos.add(index, novo);
				
				FileOutputStream output = new FileOutputStream(pathServicos);
				ObjectOutputStream escritor = new ObjectOutputStream(output);
				escritor.writeObject(servicos);
				escritor.close();;
				
				return true;
			}
		}
		return false;
	}
}

