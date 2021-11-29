package main;

import auto.Concesionaria;
import auto.ManejadorArchivos;

public class Main {

	public static void main(String[] args) {
		Concesionaria concesionaria = new Concesionaria();

		concesionaria.agregarTodosAutos(ManejadorArchivos.obtenerAutosDesdeArchivo());
		// XXX La siguiente linea esta FEA. No debería pasarle concesionaria así
		concesionaria.agregarTodasPromociones(ManejadorArchivos.obtenerPromosDesdeArchivo(concesionaria));

		// Listo todas las "atracciones" y las promos con su contenido
		System.out.println(concesionaria.toString());
	}
}
