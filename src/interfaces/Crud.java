package interfaces;

/*Essa interface descreve quais métodos os objetos que persistirêmos
(ou seja, armazenar em um arquivo local) devem possuir e permite a
simplificação das chamadas desses métodos através da classe Crud
dentro do pacote "src/methods"*/

public interface Crud {
	public void cadastrar();
	public void editar();
	public void excluir();
	public void listar();
}
