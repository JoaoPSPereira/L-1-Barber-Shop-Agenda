package methods;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import interfaces.LeituraTeclado;
import interfaces.Menu;
import locals.Path;
import objects.Cliente;
import objects.Servico;

public class Excluir {
	//Variáveis para leitura do arquivo de cadastros
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static ArrayList<Servico> servicos = new ArrayList<Servico>();
	private static String pathClientes = Path.clientes();
	private static String pathServicos = Path.servicos();
	
	@SuppressWarnings("unchecked")
	public static boolean cliente(String alvo) throws Exception{
		
		//Lendo o arquivo de cadastros e salvando em lista local temporaria
		FileInputStream input = new FileInputStream(pathClientes);
		ObjectInputStream leitor = new ObjectInputStream(input);
		clientes = (ArrayList<Cliente>) leitor.readObject();
		leitor.close();
		
		
		//Percorre a lista contendo os cadastros de clientes
		for(Cliente c : clientes) {
			
			String nomec = c.getNome().toLowerCase().trim();
			String nomealvo = alvo.toLowerCase().trim();
			
			if (nomec.equals(nomealvo)) {
				
				System.out.println("\n*********************");
				System.out.println("CADASTRO SELECIONADO");
				System.out.println("*********************");
				System.out.println("Nome: "+c.getNome());
				System.out.println("Telefone: "+c.getTelefone());
				System.out.println("Data de nascimento: "+c.getNascimento());
				System.out.println("Gênero: "+c.getGenero());
				System.out.println("*********************");
				System.out.println("Deseja excluir o cadastro selecionado? 1-SIM 2-NÃO");
				
				int escolha = 0;
				LeituraTeclado leitura = new LeituraTeclado();
				escolha = leitura.numero();
				
				if (escolha == 1) {
					clientes.remove(c);
					
					FileOutputStream output = new FileOutputStream(pathClientes);
					ObjectOutputStream escritor = new ObjectOutputStream(output);
					escritor.writeObject(clientes);
					escritor.close();
					
					System.out.println("Cadastro excluído com sucesso!");
					System.out.println("Redirecionando para o Menu principal");
					System.out.println(".");
					System.out.println(".");
					System.out.println(".");
					
					return true;
				
				}
				else {
					Menu.mostrarMenu();
				}
				return true;
			}
			else {
				System.out.println("Cadastro não encontrado");
				System.out.println("Redirecionando para o Menu principal");
				System.out.println(".");
				System.out.println(".");
				System.out.println(".");
				return false;
			}
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public static boolean servico(String alvo) throws Exception{
		
		//Lendo o arquivo de cadastros e salvando em lista local temporaria
		FileInputStream input = new FileInputStream(pathServicos);
		ObjectInputStream leitor = new ObjectInputStream(input);
		servicos = (ArrayList<Servico>) leitor.readObject();
		leitor.close();
		
		
		//Percorre a lista contendo os cadastros de servicos
		for(Servico s : servicos) {
			if (s.getNome().toUpperCase() == alvo.toUpperCase()) {
				/*Se o nome do objeto sendo percorrido é igual ao 
				nome do objeto alvo, remove o objeto da lista*/
				servicos.remove(s);
				
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

