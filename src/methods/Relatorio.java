package methods;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
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
		
		System.out.println("\nMédia de idade de todos os clientes: " + media + " anos");
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
		
		Integer media = totalIdade/nascimentos.size();
		
		System.out.println("\nMédia de idade dos clientes do gênero " + genEscrito +": " + media + " anos");
	}
	
	
}
