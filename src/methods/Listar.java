package methods;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import objects.Cliente;

public class Listar {
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static String pathClientes = System.getProperty("user.home") + "\\Desktop\\clientes.ser";
	
	@SuppressWarnings("unchecked")
	public static void clientes() throws Exception{
		
		//Lendo arquivo de serialização
		FileInputStream input = new FileInputStream(pathClientes);
		ObjectInputStream leitor = new ObjectInputStream(input);
		clientes = (ArrayList<Cliente>) leitor.readObject();
		leitor.close();
		
		//Colocando em ordem alfabética
		Collections.sort(clientes, new Comparator<Cliente>(){
		    public int compare(Cliente s1, Cliente s2) {
		        return s1.getNome().compareToIgnoreCase(s2.getNome());
		    }
		});
		
		//printando
		System.out.println(clientes.toString());
	}
	
	@SuppressWarnings("unchecked")
	public static void cliente(String alvo) throws Exception{
	
		FileInputStream input = new FileInputStream(pathClientes);
		ObjectInputStream leitor = new ObjectInputStream(input);
		clientes = (ArrayList<Cliente>) leitor.readObject();
		leitor.close();
		for(Cliente c : clientes) {
			String nome = c.getNome().toLowerCase().trim();
			String nomealvo = alvo.toLowerCase().trim();
			if(nome.equals(nomealvo)) {
				System.out.println(c.getNome());
			}
		}
	}
	
	
}

//comentarioo
