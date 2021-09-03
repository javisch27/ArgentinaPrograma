package parqueDeAtracciones;

import java.util.Arrays;

public class ParqueDeAtraccion {
	private Usuario[] usuarios;
	private Atraccion[] atracciones;
	private Promocion[] promociones;
	
	public void agregarTodosUsuarios(Usuario[] usuarios) {
		this.usuarios = usuarios;
	}
	
	public void agregarTodasAtracciones(Atraccion[] atracciones) {
		this.atracciones = atracciones;
	}
	
	public void agregarTodasPromociones(Promocion[] promociones) {
		this.promociones = promociones;
	}
	
	public void proponerAtraccion() {
		
	}
	
	public Atraccion obtenerAtraccionPorNombre(String nombre) {
		for (Atraccion atraccion : atracciones) {
			if (atraccion.getNombre().equals(nombre)) {
				return atraccion;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "ParqueDeAtraccion [usuarios=" + Arrays.toString(usuarios) + ", atracciones="
				+ Arrays.toString(atracciones) + ", promociones=" + Arrays.toString(promociones) + "]";
	}
}
