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

		// Inicialização ---- NÃO MEXER !!!
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
				System.out.println("Número de telefone:");
				String telefone = leitura.texto();
				System.out.println("Data de nascimento (dd/mm/aaaa):");
				String nascimento = leitura.texto();
				LocalDate data = Conversor.stringToLocalDate(nascimento);
				System.out.println("Informe o gênero");
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
				int opcao = 0;
				opcao = leitura.numero();

				if (opcao == 0 || opcao == 1 || opcao == 2) {
					Listar.genero(opcao);
				} else if (opcao == 3) {
					Listar.clientes();
				}

				else {
					System.out.println("\n*********************");
					System.out.println("SERVIÇOS REALIZADOS");
					System.out.println("*********************");
					Listar.servicos();
					System.out.println("*********************");
				}
			}

			if (escolha == 4) {
				System.out.println("Selecione a opção desejada:");
				System.out.println("0- Média de idade de clientes");
				System.out.println("1- Serviço mais procurado");
				int opcao = 0;
				opcao = leitura.numero();
				if (opcao == 0) {
					System.out.println("\n**********************************");
					System.out.println("RELATÓRIO: IDADE MÉDIA DE CLIENTES");
					System.out.println("**********************************");
					Relatorio.idadeMedia();
					Relatorio.idadeMediaPorGenero(0);
					Relatorio.idadeMediaPorGenero(1);
					Relatorio.idadeMediaPorGenero(2);
					System.out.println("**********************************");
					
				}
				
				else if (opcao == 1) {
					System.out.println("\n**********************************");
					System.out.println("RELATÓRIO: SERVIÇO MAIS PROCURADO");
					System.out.println("**********************************");
					Relatorio.servicoMaisProcurado();
					Relatorio.servicoMaisProcuradoPorGenero(0);
					Relatorio.servicoMaisProcuradoPorGenero(1);
					Relatorio.servicoMaisProcuradoPorGenero(2);
					System.out.println("**********************************");
				}
				

			}
			if (escolha == 5) {
				System.out.println("Digite o serviço desejado:");
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
