package consola;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		String[] consultadores = { "Javier A", "Max", "Javier" };

		// Leer por consola y mostrar por pantalla
		Scanner in = new Scanner(System.in);
		String entradaConsola;

		for (String consultador : consultadores) {
			System.out.println(consultador + ", pudiste resolver la duda? (S/N)");
			entradaConsola = in.nextLine().toUpperCase();
			while (!entradaConsola.equals("S") && !entradaConsola.equals("N")) {
				System.out.println("No se ingreso un mensaje válido. Intente nuevamente");
				entradaConsola = in.nextLine().toUpperCase();
			}
			System.err.println(entradaConsola);
		}

		in.close();
	}
}
