package main;

import java.io.IOException;

import parqueDeAtracciones.LectorDeArchivos;
import parqueDeAtracciones.ParqueDeAtraccion;
import parqueDeAtracciones.Sistema;


public class Main {

	public static void main(String[] args) throws IOException {
		ParqueDeAtraccion tierraMedia = new ParqueDeAtraccion();
		Sistema sistema = new Sistema();
		
		tierraMedia.agregarTodasAtracciones(LectorDeArchivos.obtenerAtraccionesDesdeArchivo());
		tierraMedia.agregarTodosUsuarios(LectorDeArchivos.obtenerUsuariosDesdeArchivo());
		tierraMedia.agregarTodasPromociones(LectorDeArchivos.obtenerPromosDesdeArchivo(tierraMedia));
		tierraMedia.juntarOfertables();

		sistema.sugerirOfertablesATodosUsuarios(tierraMedia);
	}
}