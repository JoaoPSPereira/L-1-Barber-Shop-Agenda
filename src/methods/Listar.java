package methods;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import objects.Cliente;

public class Listar {
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private String pathClientes = System.getProperty("user.home") + "\\clientes.ser";
	@SuppressWarnings("unchecked")
	public void clientes() throws Exception{
		FileInputStream input = new FileInputStream(this.pathClientes);
		ObjectInputStream leitor = new ObjectInputStream(input);
		this.clientes = (ArrayList<Cliente>) leitor.readObject();
		leitor.close();
		System.out.println(clientes.toString());
	}
	
}
