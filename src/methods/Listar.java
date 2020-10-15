package methods;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import objects.Cliente;
import objects.Servico;

public class Listar {
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static ArrayList<Servico> servicos = new ArrayList<Servico>();
	private static String pathClientes = System.getProperty("user.home") + "\\Desktop\\clientes.ser";
	private static String pathServicos = System.getProperty("user.home") + "\\Desktop\\servicos.ser";
	
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
	public static void genero(int genero) throws Exception{
		
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
		
		//printando somente clientes do genero selecionado
		for(Cliente c : clientes) {			
			if (c.getGenero() == genero) {
				c.print();
			}
		}
		
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
	
	@SuppressWarnings("unchecked")
	public static void servicos() throws Exception{
		
		//Lendo arquivo de serialização
		FileInputStream input = new FileInputStream(pathServicos);
		ObjectInputStream leitor = new ObjectInputStream(input);
		servicos = (ArrayList<Servico>) leitor.readObject();
		leitor.close();
		
		//Colocando em ordem alfabética
		Collections.sort(servicos, new Comparator<Servico>(){
		    public int compare(Servico s1, Servico s2) {
		        return s1.getNome().compareToIgnoreCase(s2.getNome());
		    }
		});
		
		//printando
		for (Servico s : servicos) {
			s.printar();
		}
	}
}

//comentarioo
