package main;

/*Classe do front-end*/

import objects.Cliente;
import objects.Servico;

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
			
		if (escolha == 0){
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
		
		if (escolha == 1) {
			System.out.println("Insira o nome do cliente a ser editado:");
			String alvo = leitura.texto();
			Editar.cliente(alvo);
			
		}
		
		if (escolha == 2) {
			System.out.println("Insira o nome do cliente a ser excluído:");
			String alvo = leitura.texto();
			Excluir.cliente(alvo);
		}
		
		if (escolha == 3) {
			System.out.println("Selecione a opção desejada:");
			System.out.println("0- Listar por gênero Masculino");
			System.out.println("1- Listar por gênero Feminino");
			System.out.println("2- Listar por gênero Outros");
			System.out.println("3- Listar todos os clientes");
			System.out.println("4- Listar serviços");
			escolha = 0;
			escolha = leitura.numero();
			
			if (escolha == 0 || escolha == 1 || escolha == 2) {
				Listar.genero(escolha);
			}
			else if (escolha == 3) {
				Listar.clientes();
			}
			
			else {
				Listar.servicos();
			}
		}
		
		if (escolha == 4) {
			System.out.println("gerar relatorios");
		}
		
		if (escolha == 5) {
			System.out.println("Digite o serviço desejado:");
			String servico1 = leitura.texto();	
			System.out.println("Digite o nome do cliente:");
			String cliente = leitura.texto();
			System.out.println("Digite o dia agendado em xx/xx/xx:");
			String data = leitura.texto();
			System.out.println("Digite a hora agendada em xx:xx");
			String horario = leitura.texto();
			Servico servico = new Servico(servico1, cliente, data, horario);
			Cadastrar.servico(servico);
			}
		
		
		
	}
		
  }

}
