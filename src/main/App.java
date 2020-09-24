package main;

import java.io.IOException;

import methods.*;
import objects.*;

public class App {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DataNasc n = new DataNasc(02,03,2001);
		Cliente c = new Cliente("Joao", "12981445566", n, 0);
		
		Cadastrar.cliente(c);
			
		
	}

}
