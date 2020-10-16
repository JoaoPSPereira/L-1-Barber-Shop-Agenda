package methods;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
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
		
		System.out.println("\nGeral: " + media + " anos");
	}
	
	public static void idadeMediaPorGenero(int genero) throws ClassNotFoundException, IOException {
		LocalDate hoje = LocalDate.now(); //yyyy-mm-dd
		
		//lê o arquivo de clientes
		ArrayList<Cliente> clientes = Ler.clientes(); 
		
		ArrayList<LocalDate> nascimentos = new ArrayList<LocalDate>();
		Integer totalIdade = 0;
		
		String genEscrito = null;
		switch (genero) {
		case 0:
			genEscrito = "Masculino";
			break;
		case 1:
			genEscrito = "Feminino";
			break;
		case 2:
			genEscrito = "Outros";
			break;
		}
		
		for (Cliente c : clientes) {
			if(c.getGenero() == genero) {
				nascimentos.add(c.getNascimento());		
			}
		}
		
		for(LocalDate n : nascimentos) {
			Integer idade = Period.between(n, hoje).getYears();
			totalIdade = totalIdade + idade;
		}
		
		Integer media = totalIdade/(nascimentos.size() + 1);
		
		System.out.println("\nGênero " + genEscrito +": " + media + " anos");
	}
	
	public static void servicoMaisProcurado() throws ClassNotFoundException, IOException {
		
		ArrayList<String> servicoClientes = new ArrayList<String>();
		
		//Lê o arquivo de clientes
		ArrayList<Cliente> clientes = Ler.clientes();
		
		for (Cliente c : clientes)	{
			servicoClientes.addAll(c.getServicos());
		}
		
		String occurrences = 
				  servicoClientes.stream().collect(Collectors.groupingBy(w -> w, Collectors.counting())).entrySet().stream().max(Comparator.comparing(Entry::getValue)).get().getKey();
		
		System.out.println("Geral: " + occurrences);
	}
	
	public static void servicoMaisProcuradoPorGenero(int genero) throws ClassNotFoundException, IOException {
		
		ArrayList<String> servicoClientes = new ArrayList<String>();
		
		//Lê o arquivo de clientes
		ArrayList<Cliente> clientes = Ler.clientes();
		
		String genEscrito = null;
		switch (genero) {
		case 0:
			genEscrito = "Masculino";
			break;
		case 1:
			genEscrito = "Feminino";
			break;
		case 2:
			genEscrito = "Outros";
			break;
		}
		
		for (Cliente c : clientes)	{
			if (c.getGenero() == genero) {
				servicoClientes.addAll(c.getServicos());
			}
		}
		
		String occurrences = 
				  servicoClientes.stream().collect(Collectors.groupingBy(w -> w, Collectors.counting())).entrySet().stream().max(Comparator.comparing(Entry::getValue)).get().getKey();
		
		
		System.out.println("Servico mais procurado pelo gênero " + genEscrito + ": " + occurrences);
	}
}

