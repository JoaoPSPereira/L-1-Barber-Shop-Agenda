package methods;

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
