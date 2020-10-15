package objects;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/*Classe que representa o objeto Cliente*/


public class Cliente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//------------------------------------------------------//
	//Atributos
	private String nome;
	private String telefone;
	private LocalDate nascimento = null;
	private int genero;
	private int idade;
	private ArrayList<String> servicos = new ArrayList<String>();
	
	//------------------------------------------------------//
	//Construtor
	public Cliente(String nome, String telefone, LocalDate nascimento, int genero) {
		this.nome = nome;
		this.telefone = telefone;
		this.nascimento = nascimento;
		this.genero = genero;
	}
	
	//------------------------------------------------------//
	//Método toString
	@Override
	public String toString() {
		return "nome=" + nome + " telefone=" + telefone + " nascimento=" + nascimento + " genero=" + genero + "\n";
	}

	public void print() {
		String genEscrito = null;
		switch (this.getGenero()) {
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
		System.out.println("\n*********************");
		System.out.println("CLIENTE CADASTRADO");
		System.out.println("*********************");
		System.out.println("Nome: "+this.getNome());
		System.out.println("Telefone: "+this.getTelefone());
		System.out.println("Data de nascimento: "+this.getNascimento());
		System.out.println("Gênero: "+genEscrito);
		System.out.println("*********************");
	}
	
	//------------------------------------------------------//
	//Getters e Setters
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	public int getGenero() {
		return genero;
	}
	public void setGenero(int genero) {
		this.genero = genero;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void addServico(String e) {
		this.servicos.add(e);
	}
	public ArrayList<String> getServicos(){
		return this.servicos;
	}
	
	public void printarServicos() {
		System.out.println("\n*********************");
		System.out.println("Serviços realizados: \n");
		for (String s : servicos) {
			System.out.println("-"+s);
			
		}
		System.out.println("*********************");
	}
}
