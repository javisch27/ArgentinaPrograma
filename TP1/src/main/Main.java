package main;

import parqueDeAtracciones.LectorDeArchivos;
import parqueDeAtracciones.ParqueDeAtraccion;

public class Main {
	
	public static void main(String[] args) {
		ParqueDeAtraccion tierraMedia = new ParqueDeAtraccion();
		
		tierraMedia.agregarTodasAtracciones(LectorDeArchivos.obtenerAtraccionesDesdeArchivo());
		
		tierraMedia.agregarTodosUsuarios(LectorDeArchivos.obtenerUsuariosDesdeArchivo());
		
		tierraMedia.agregarTodasPromociones(LectorDeArchivos.obtenerPromosDesdeArchivo(tierraMedia));
		
		System.out.println(tierraMedia.toString());
	}
}