package main;

/*Classe do front-end*/

import objects.*;

import java.io.File;

import methods.*;


public class App {

	public static void main(String[] args) throws Exception {
		
		//Inicialização ---- NÃO MEXER !!!
		File clientes = new File(System.getProperty("user.home") + "\\L-1\\clientes.ser");
		File servicos = new File(System.getProperty("user.home") + "\\L-1\\servicos.ser");
		
		clientes.mkdirs(); servicos.mkdirs();
		
		// ------------------------------
		
		
		//Teste
		DataNasc n = new DataNasc(02,03,2001);
	
		System.out.println(n.toString());
		
		//Cliente c = new Cliente(null, null, null, 0);
		
		System.out.println(System.getProperty("user.home") + "\\l-1\\clientes.ser");
		//Cadastrar cad = new Cadastrar();
		//cad.cliente(c);
		Listar.clientes();
		
	}

}
