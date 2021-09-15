package parqueDeAtracciones;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
	
	public void sugerirOfertablesATodosUsuarios(ParqueDeAtraccion parque) throws IOException {
		
		Scanner in = new Scanner(System.in);
		String entradaConsola;

		for (Usuario usuario : parque.getUsuarios()) {

			List<Ofertable> ofertablesAceptados = new ArrayList<Ofertable>();
			parque.ordenarSegunPrioridadA(usuario);
			int dineroTotalGastado = 0;
			double tiempoTotalAUtilizar = 0;

			System.out.println("Bienvenido/a " + usuario.getNombre() + "!" + "\n");
			for (Ofertable ofertable : parque.getOfertables()) {
				if (ofertable.puedeSerOfertada(usuario)) {
					System.out.println(usuario + "\n" + "\n" + usuario.getNombre()
							+ ", Te interesa la siguiente propuesta? (S/N)" + "\n" + "\n" + ofertable);
					entradaConsola = in.nextLine().toUpperCase();
					if (entradaConsola.equals("S") || entradaConsola.equals("s")) {
						usuario.aceptarOferta(ofertable);
						ofertablesAceptados.add(ofertable);
						dineroTotalGastado += ofertable.getCosto();
						tiempoTotalAUtilizar += ofertable.getDuracion();
					}
					while (!entradaConsola.equals("S") && !entradaConsola.equals("N") && !entradaConsola.equals("s")
							&& !entradaConsola.equals("n")) {
						System.out.println("No se ingresó un mensaje válido. Intente nuevamente.");
						entradaConsola = in.nextLine().toUpperCase();
					}
					System.err.println(entradaConsola);
				}
			}

			System.out.println(
					"Muchas gracias " + usuario.getNombre() + ", le enviamos sus compras por archivo." + "\n" + "\n");

			PrintWriter salida = new PrintWriter(new FileWriter("Itinerario de " + usuario.getNombre() + ".out"));
			salida.print(usuario.getNombre() + ", has seleccionado la/s siguiente/s promocion/es y/o atraccion/es:" + "\n"
					+ "\n" + ofertablesAceptados + "\n" + "\n" + "Costo Total= " + dineroTotalGastado + "\n"
					+ "Tiempo total a utilizar= " + tiempoTotalAUtilizar);
			salida.close();
		}
		in.close();
	}
}
