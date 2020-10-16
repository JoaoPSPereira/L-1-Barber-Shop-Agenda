package main;

/*Classe do front-end*/

import objects.Cliente;
import objects.Servico;

import java.time.LocalDate;

import interfaces.LeituraTeclado;
import interfaces.Menu;
import locals.Conversor;
import methods.*;

public class App {

	public static void main(String[] args) throws Exception {

		// Inicializa��o ---- N�O MEXER !!!
		/*
		 * File clientes = new File(System.getProperty("user.home") + "\\clientes.ser");
		 * File servicos = new File(System.getProperty("user.home") + "\\servicos.ser");
		 * 
		 * clientes.mkdirs(); servicos.mkdirs();
		 */

		// ------------------------------
		LeituraTeclado leitura = new LeituraTeclado();
		int escolha = 0;
		while (escolha != 7) {
			Menu.mostrarMenu();
			escolha = leitura.numero();

			if (escolha == 0) {
				System.out.println("Nome do cliente:");
				String nome = leitura.texto();
				System.out.println("N�mero de telefone:");
				String telefone = leitura.texto();
				System.out.println("Data de nascimento (dd/mm/aaaa):");
				String nascimento = leitura.texto();
				LocalDate data = Conversor.stringToLocalDate(nascimento);
				System.out.println("Informe o g�nero");
				System.out.println("Digite 0 para Masculino, 1 para Feminino ou 2 para Outros");
				int genero = leitura.numero();
				Cliente c = new Cliente(nome, telefone, data, genero);
				Cadastrar.cliente(c);
				System.out.println(c);
			}

			if (escolha == 1) {
				System.out.println("Insira o nome do cliente a ser editado:");
				String alvo = leitura.texto();
				Editar.cliente(alvo);

			}

			if (escolha == 2) {
				System.out.println("Insira o nome do cliente a ser exclu�do:");
				String alvo = leitura.texto();
				Excluir.cliente(alvo);
			}

			if (escolha == 3) {
				System.out.println("Selecione a op��o desejada:");
				System.out.println("0- Listar por g�nero Masculino");
				System.out.println("1- Listar por g�nero Feminino");
				System.out.println("2- Listar por g�nero Outros");
				System.out.println("3- Listar todos os clientes");
				System.out.println("4- Listar servi�os");
				int opcao = 0;
				opcao = leitura.numero();

				if (opcao == 0 || opcao == 1 || opcao == 2) {
					Listar.genero(opcao);
				} else if (opcao == 3) {
					Listar.clientes();
				}

				else {
					System.out.println("\n*********************");
					System.out.println("SERVI�OS REALIZADOS");
					System.out.println("*********************");
					Listar.servicos();
					System.out.println("*********************");
				}
			}

			if (escolha == 4) {
				System.out.println("Selecione a op��o desejada:");
				System.out.println("0- M�dia de idade de clientes");
				System.out.println("1- Servi�o mais procurado");
				int opcao = 0;
				opcao = leitura.numero();
				if (opcao == 0) {
					System.out.println("\n**********************************");
					System.out.println("RELAT�RIO: IDADE M�DIA DE CLIENTES");
					System.out.println("**********************************");
					Relatorio.idadeMedia();
					Relatorio.idadeMediaPorGenero(0);
					Relatorio.idadeMediaPorGenero(1);
					Relatorio.idadeMediaPorGenero(2);
					System.out.println("**********************************");
					
				}
				
				else if (opcao == 1) {
					System.out.println("\n**********************************");
					System.out.println("RELAT�RIO: SERVI�O MAIS PROCURADO");
					System.out.println("**********************************");
					Relatorio.servicoMaisProcurado();
					Relatorio.servicoMaisProcuradoPorGenero(0);
					Relatorio.servicoMaisProcuradoPorGenero(1);
					Relatorio.servicoMaisProcuradoPorGenero(2);
					System.out.println("**********************************");
				}
				

			}
			if (escolha == 5) {
				System.out.println("Digite o servi�o desejado:");
				String servico1 = leitura.texto();
				System.out.println("Digite o nome do cliente:");
				String cliente = leitura.texto();
				System.out.println("Digite o dia agendado (dd/mm/aaaa):");
				String data = leitura.texto();
				System.out.println("Digite a hora agendada (hh:mm)");
				String horario = leitura.texto();
				Servico servico = new Servico(servico1, cliente, data, horario);
				Cadastrar.servico(servico);
				escolha = 0;
			}
			if (escolha == 6) {
				System.out.println("Digite o nome do cliente:");
				String alvo = leitura.texto();
				Listar.historico(alvo);
			}
		}

	}
}
