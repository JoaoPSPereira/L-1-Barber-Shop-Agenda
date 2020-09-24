package methods;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

import objects.Cliente;

public class Cadastrar{
	
	public static void cliente(Cliente client) throws IOException {
		// TODO Auto-generated method stub
		
		String caminho = "";
		
		Gson gson = new Gson();
		
		String out = gson.toJson(client);
		
		FileWriter arquivo = new FileWriter(caminho);
		arquivo.write(out);
		arquivo.close();
		
		
	}
}
