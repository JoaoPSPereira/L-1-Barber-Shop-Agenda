package main;

/*Classe do front-end*/

import objects.*;
import methods.*;


public class App {

	public static void main(String[] args) throws Exception {
		
		//Teste
		DataNasc n = new DataNasc(02,03,2001);
	
		System.out.println(n.toString());
		
		//Cliente c = new Cliente(null, null, null, 0);
		
		System.out.println(System.getProperty("user.home") + "\\local\\l-1\\clientes.ser");
		//Cadastrar cad = new Cadastrar();
		//cad.cliente(c);
		Listar l = new Listar();
		l.clientes();
		
	}

}
