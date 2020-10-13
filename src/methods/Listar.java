package methods;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import objects.Cliente;

public class Listar {
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static String pathClientes = System.getProperty("user.home") + "\\clientes.ser";
	
	@SuppressWarnings("unchecked")
	public static void clientes() throws Exception{
		FileInputStream input = new FileInputStream(pathClientes);
		ObjectInputStream leitor = new ObjectInputStream(input);
		clientes = (ArrayList<Cliente>) leitor.readObject();
		leitor.close();
		System.out.println(clientes.toString());
	}
	
	@SuppressWarnings("unchecked")
	public static Cliente cliente(String alvo) throws Exception{
		FileInputStream input = new FileInputStream(pathClientes);
		ObjectInputStream leitor = new ObjectInputStream(input);
		clientes = (ArrayList<Cliente>) leitor.readObject();
		leitor.close();
		for(Cliente c : clientes) {
			if (c.getNome().toUpperCase() == alvo.toUpperCase()) {
				return c;
			}
		}
		return null;
	}
	
	
}

//comentarioo
