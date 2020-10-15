package locals;

public class Path {
	
	public static String clientes() {
		return System.getProperty("user.home") + "\\Desktop\\clientes.ser";
	}
	public static String servicos() {
		return System.getProperty("user.home") + "\\Desktop\\servicos.ser";
	}
}

