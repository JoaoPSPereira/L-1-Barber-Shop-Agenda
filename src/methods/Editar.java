package methods;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import interfaces.LeituraTeclado;
import interfaces.Menu;
import objects.Cliente;
import objects.Servico;

public class Editar {
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static ArrayList<Servico> servicos = new ArrayList<Servico>();
	private static String pathClientes = System.getProperty("user.home") + "\\Desktop\\clientes.ser";
	private static String pathServicos = System.getProperty("user.home") + "\\Desktop\\servicos.ser";
	
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
				
				String newnome;
				String newtelefone;
				String newnascimento;
				int newgenero;
				int index = clientes.indexOf(c);
				
				Cliente newc = clientes.get(index);
				
				System.out.println("\n*********************");
				System.out.println("CADASTRO SELECIONADO");
				System.out.println("*********************");
				System.out.println("Nome: "+c.getNome());
				System.out.println("Telefone: "+c.getTelefone());
				System.out.println("Data de nascimento: "+c.getNascimento());
				System.out.println("Gênero: "+c.getGenero());
				System.out.println("*********************");
				System.out.println("Escolha a opção desejada:");
				System.out.println("1- Editar nome");
				System.out.println("2- Editar telefone");
				System.out.println("3- Editar data de nascimento");
				System.out.println("4- Editar gênero");
				System.out.println("5- Editar cadastro todo");
				System.out.println("6- Voltar ao menu principal");
				
				int escolha = 0;
				LeituraTeclado leitura = new LeituraTeclado();
				escolha = leitura.numero();
				
				switch (escolha) {
				case 1:
					System.out.println("Novo nome:");
					newnome = leitura.texto();
					newc.setNome(newnome);
					break;
				case 2:
					System.out.println("Novo telefone:");
					newtelefone = leitura.texto();
					newc.setTelefone(newtelefone);
					break;
				case 3:
					System.out.println("Nova data de nascimento:");
					newnascimento = leitura.texto();
					newc.setNascimento(newnascimento);
					break;
				case 4:
					System.out.println("Digite 0 para Masculino, 1 para Feminino ou 2 para Outros");
					System.out.println("Novo gênero:");
					newgenero = leitura.numero();
					newc.setGenero(newgenero);
					break;
				case 5:
					System.out.println("Novo nome:");
					newnome = leitura.texto();
					newc.setNome(newnome);
					System.out.println("Novo telefone:");
					newtelefone = leitura.texto();
					newc.setTelefone(newtelefone);
					System.out.println("Nova data de nascimento:");
					newnascimento = leitura.texto();
					newc.setNascimento(newnascimento);
					System.out.println("Digite 0 para Masculino, 1 para Feminino ou 2 para Outros");
					System.out.println("Novo gênero:");
					newgenero = leitura.numero();
					newc.setGenero(newgenero);
					break;
				case 6:
					Menu.mostrarMenu();
					break;
				}
				
				System.out.println("\n*********************");
				System.out.println("CADASTRO ATUALIZADO");
				System.out.println("*********************");
				System.out.println("Nome: "+newc.getNome());
				System.out.println("Telefone: "+newc.getTelefone());
				System.out.println("Data de nascimento: "+newc.getNascimento());
				System.out.println("Gênero: "+newc.getGenero());
				System.out.println("*********************");
				
				
				FileOutputStream output = new FileOutputStream(pathClientes);
				ObjectOutputStream escritor = new ObjectOutputStream(output);
				escritor.writeObject(clientes);
				escritor.close();;
				//-----------------------------
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

