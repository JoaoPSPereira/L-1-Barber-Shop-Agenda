package methods;

/*Essa classe server para chamar-mos os métodos crud de um objeto
que implementa a interface Crud */

public class Crud {
	public static void cadastrar(interfaces.Crud obj) {
		obj.cadastrar();
	}
	public static void editar(interfaces.Crud obj) {
		obj.editar();
	}
	public static void excluir(interfaces.Crud obj) {
		obj.cadastrar();
	}
	public static void listar(interfaces.Crud obj) {
		obj.listar();
	}
	
}
