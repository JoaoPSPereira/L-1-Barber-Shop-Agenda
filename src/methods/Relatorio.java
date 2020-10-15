package methods;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

import objects.Cliente;
import locals.Ler;

public class Relatorio {
	
	public static void idadeMedia() throws ClassNotFoundException, IOException {
		LocalDate hoje = LocalDate.now(); //yyyy-mm-dd
		
		//lê o arquivo de clientes
		ArrayList<Cliente> clientes = Ler.clientes(); 
		
		ArrayList<LocalDate> nascimentos = new ArrayList<LocalDate>();
		Integer totalIdade = 0;
		
		for (Cliente c : clientes) {
			nascimentos.add(c.getNascimento());		
		}
		
		for(LocalDate n : nascimentos) {
			Integer idade = Period.between(n, hoje).getYears();
			totalIdade = totalIdade + idade;
		}
		
		Integer media = totalIdade/nascimentos.size();
		
		System.out.println("Média de idade dos Clientes:" + media);
	}
	
	public static void idadeMediaPorGenero(int genero) throws ClassNotFoundException, IOException {
		LocalDate hoje = LocalDate.now(); //yyyy-mm-dd
		
		//lê o arquivo de clientes
		ArrayList<Cliente> clientes = Ler.clientes(); 
		
		ArrayList<LocalDate> nascimentos = new ArrayList<LocalDate>();
		Integer totalIdade = 0;
		
		for (Cliente c : clientes) {
			if(c.getGenero() == genero) {
				nascimentos.add(c.getNascimento());		
			}
		}
		
		for(LocalDate n : nascimentos) {
			Integer idade = Period.between(n, hoje).getYears();
			totalIdade = totalIdade + idade;
		}
		
		Integer media = totalIdade/nascimentos.size();
		
		System.out.println("Média de idade dos Clientes:" + media);
	}
	
	public static void servicoMaisProcurado() throws ClassNotFoundException, IOException {
		
		ArrayList<String> servicoClientes = new ArrayList<String>();
		
		//Lê o arquivo de clientes
		ArrayList<Cliente> clientes = Ler.clientes();
		
		for (Cliente c : clientes)	{
			servicoClientes.addAll(c.getServicos());
		}
		
		Map<String, Long> occurrences = 
				  servicoClientes.stream().collect(Collectors.groupingBy(w -> w, Collectors.counting()));
		
		System.out.println("Servico mais procurado: " + occurrences);
	}
}

