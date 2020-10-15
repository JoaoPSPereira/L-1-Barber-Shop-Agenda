package locals;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import objects.Cliente;
import objects.Servico;



public class Escrever {

	private static String pathClientes = Path.clientes();
	private static String pathServicos = Path.servicos();

	public static void clientes(ArrayList<Cliente> clientes) throws IOException, ClassNotFoundException{

		//Escreve a serialização de clientes
		FileOutputStream output = new FileOutputStream(pathClientes);
		ObjectOutputStream escritor = new ObjectOutputStream(output);
		escritor.writeObject(clientes);
		escritor.close();;
	
	}

	public static void servicos(ArrayList<Servico> servicos) throws IOException, ClassNotFoundException{
				
		FileOutputStream output = new FileOutputStream(pathServicos);
		ObjectOutputStream escritor = new ObjectOutputStream(output);
		escritor.writeObject(servicos);
		escritor.close();;
		
	}
}