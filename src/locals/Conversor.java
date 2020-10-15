package locals;

import java.time.LocalDate;

public class Conversor {
	
	public static LocalDate stringToLocalDate(String e) {
		
		String separador = "/";
		int dia = Integer.parseInt(e.substring(0, e.indexOf(separador)));
		//separa o mês e transforma em int
		int mes = Integer.parseInt(e.substring(e.indexOf(separador) + 1, e.lastIndexOf(separador)));
		//Separa o dia e transforma em int
		int ano = Integer.parseInt(e.substring(e.lastIndexOf(separador) + 1));
		
		LocalDate data = LocalDate.of(ano,mes,dia);
		return data;
	}
}
