package methods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import locals.Ler;
import objects.Cliente;
import objects.Servico;

public class Listar {
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static ArrayList<Servico> servicos = new ArrayList<Servico>();

	public static void clientes() throws Exception{
		
		//Lê o arquivo de clientes
		clientes = Ler.clientes();
		
		//Colocando em ordem alfabética
		Collections.sort(clientes, new Comparator<Cliente>(){
		    public int compare(Cliente s1, Cliente s2) {
		        return s1.getNome().compareToIgnoreCase(s2.getNome());
		    }
		});
		
		//printando
		for(Cliente c : clientes) {
			c.print();
		}
	}
	
	
	public static void cliente(String alvo) throws Exception{
	
		//Lê o arquivo de clientes
		clientes = Ler.clientes();
		
		String nomealvo = alvo.toLowerCase().trim();
		for(Cliente c : clientes) {
			String nome = c.getNome().toLowerCase().trim();
			
			if(nome.equals(nomealvo)) {
				System.out.println(c.getNome());
			}
		}
	}

	
	public static void genero(int genero) throws Exception{
		
		//Lê o arquivo de clientes
		clientes = Ler.clientes();
		
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
	

	public static void servicos() throws Exception{
		
		//Lê o arquivo de servicos
		servicos = Ler.servicos();
		
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
	
	public static void historico(String alvo) throws Exception{
	
		//Lê o arquivo de clientes
		clientes = Ler.clientes();
		
		String nomealvo = alvo.toLowerCase().trim();
		for(Cliente c : clientes) {
			String nome = c.getNome().toLowerCase().trim();
			
			if(nome.equals(nomealvo)) {
				c.printarServicos();
			}
		}
	}
	
}