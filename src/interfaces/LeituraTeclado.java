package interfaces;

import java.util.Scanner;

public class LeituraTeclado {
	private Scanner ler;

	public LeituraTeclado() {
		ler = new Scanner(System.in);
	}

	public synchronized int opcao() {
		int o = ler.nextInt();
		ler = ler.reset();
		return o;
	}

	public synchronized String texto() {
		ler = new Scanner(System.in);
		String t = ler.nextLine();
		ler = ler.reset();
		return t;
	}

	@Override
	protected void finalize() throws Throwable {
		ler.close();
	}
}
