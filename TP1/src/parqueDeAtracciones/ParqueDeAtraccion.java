package parqueDeAtracciones;

public class ParqueDeAtraccion {
	private Usuario[] usuarios;
	private Atraccion[] atracciones;
	private Promocion[] promociones;
	
	public void agregarTodosUsuarios() {
		
	}
	
	public void agregarTodasAtracciones() {
		
	}
	
	public void agregarTodasPromociones() {
		
	}
	
	public void sugerirAtraccion() {
		
	}
	
	public Atraccion obtenerAtraccionPorNombre(String nombre) {
		for (Atraccion atraccion : atracciones) {
			if (atraccion.getNombre().equals(nombre)) {
				return atraccion;
			}
		}
		return null;
	}
}
