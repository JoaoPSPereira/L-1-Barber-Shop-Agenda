package main;

/*Classe do front-end*/

import objects.Cliente;

import java.io.File;

import interfaces.LeituraTeclado;
import interfaces.Menu;
import methods.*;


public class App {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		
		//Inicialização ---- NÃO MEXER !!!
		/*File clientes = new File(System.getProperty("user.home") + "\\clientes.ser");
		File servicos = new File(System.getProperty("user.home") + "\\servicos.ser");
		
		clientes.mkdirs(); servicos.mkdirs();*/
		
		// ------------------------------
		LeituraTeclado leitura = new LeituraTeclado();
		int escolha = 0;
		while (escolha != 6) {
			Menu.mostrarMenu();
			escolha = leitura.numero();
			
		if (escolha == 1){
			System.out.println("Nome do cliente:");
			String nome = leitura.texto();
			System.out.println("Número de telefone:");
			String telefone = leitura.texto();
			System.out.println("Data de nascimento:");
			String nascimento = leitura.texto();
			System.out.println("Informe o gênero");
			System.out.println("Digite 0 para Masculino, 1 para Feminino ou 2 para Outros");
			int genero = leitura.numero();
			Cliente c = new Cliente(nome, telefone, nascimento, genero);
			Cadastrar.cliente(c);
			System.out.println(c);
		}
		
		if (escolha == 2) {
			System.out.println("Insira o nome do cliente a ser editado:");
			String alvo = leitura.texto();
			Listar.cliente(alvo);
			
		}
		
		if (escolha == 3) {
			System.out.println("excluir cliente");
		}
		
		if (escolha == 4) {
			System.out.println("listar cliente");
			Listar.clientes();
		}
		
		if (escolha == 5) {
			System.out.println("gerar relatorios");
		}
		
		//Cadastrar cad = new Cadastrar();
		//cad.cliente(c);
		
		
	}
		
  }

}
