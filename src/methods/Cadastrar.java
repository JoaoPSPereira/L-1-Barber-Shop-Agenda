package methods;

import java.io.Serializable;
import java.util.ArrayList;

import locals.Escrever;
import locals.Ler;
import objects.*;

public class Cadastrar implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static ArrayList<Servico> servicos = new ArrayList<Servico>();

	
	public static void cliente(Cliente e) throws Exception {
		
		//Lendo o arquivo de cadastros
		clientes = Ler.clientes();
	
		//Adiciona o novo cliente à lista de cadastros
		clientes.add(e);
		
		//Salva o clientes.ser
		Escrever.clientes(clientes);
	}
	
	public static void servico(Servico e) throws Exception {
		
		//Lê o arquivo de servicos
		servicos = Ler.servicos();
		
		//Lê o arquivo de clientes
		clientes = Ler.clientes();
		
		//Adicionando o serviço marcado ao Cliente
		String alvo = e.getCliente().toUpperCase().trim();;
		for(Cliente c : clientes) {
			String nomec = c.getNome().toUpperCase().trim();;
			if (alvo.equals(nomec)) {
				int index = clientes.indexOf(c);
				
				c.addServico(e.getNome());
				clientes.remove(index);
				clientes.add(index, c);	
			}
		}
		
		//Salva o clientes.ser
		Escrever.clientes(clientes);
		
		//Adiciona o novo servico à lista de cadastros
		servicos.add(e);
		
		//Salva o servicos.ser
		Escrever.servicos(servicos);
	}
}
