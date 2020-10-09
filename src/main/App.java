package main;

/*Classe do front-end*/

import objects.*;

import java.io.File;

import interfaces.LeituraTeclado;
import interfaces.Menu;
import methods.*;


public class App {

	public static void main(String[] args) throws Exception {
		
		//Inicialização ---- NÃO MEXER !!!
		File clientes = new File(System.getProperty("user.home") + "\\L-1\\clientes.ser");
		File servicos = new File(System.getProperty("user.home") + "\\L-1\\servicos.ser");
		
		clientes.mkdirs(); servicos.mkdirs();
		
		// ------------------------------
		LeituraTeclado leitura = new LeituraTeclado();
		int escolha = 0;
		while (escolha != 6) {
			Menu.mostrarMenu();
			escolha = leitura.opcao();
			
		if (escolha == 1){
			System.out.println("cadastro de cliente");;
		}
		
		if (escolha == 2) {
			System.out.println("editar cliente");
		}
		
		if (escolha == 3) {
			System.out.println("excluir cliente");
		}
		
		if (escolha == 4) {
			System.out.println("listar cliente");
		}
		
		if (escolha == 5) {
			System.out.println("gerar relatorios");
		}
		
		System.out.println(System.getProperty("user.home") + "\\l-1\\clientes.ser");
		//Cadastrar cad = new Cadastrar();
		//cad.cliente(c);
		Listar.clientes();
		
	}
		
  }

}
