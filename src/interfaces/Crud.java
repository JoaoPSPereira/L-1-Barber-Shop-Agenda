package interfaces;

/*Essa interface descreve quais m�todos os objetos que persistir�mos
(ou seja, armazenar em um arquivo local) devem possuir e permite a
simplifica��o das chamadas desses m�todos atrav�s da classe Crud
dentro do pacote "src/methods"*/

public interface Crud {
	public void cadastrar();
	public void editar();
	public void excluir();
	public void listar();
}
