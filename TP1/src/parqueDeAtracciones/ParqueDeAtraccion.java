package parqueDeAtracciones;

import java.util.Arrays;

public class ParqueDeAtraccion {
	private Usuario[] usuarios;
	private Atraccion[] atracciones;
	private Promocion[] promociones;
	private Ofertable[] ofertables;

	public void agregarTodosUsuarios(Usuario[] usuarios) {
		this.usuarios = usuarios;
	}

	public void agregarTodasAtracciones(Atraccion[] atracciones) {
		this.atracciones = atracciones;
	}

	public void agregarTodasPromociones(Promocion[] promociones) {
		this.promociones = promociones;
	}

	public void juntarOfertables() {
		int cantidadOfertables = atracciones.length + promociones.length;
		ofertables = new Ofertable[cantidadOfertables];
		int i = 0;
		for (Atraccion atraccion : atracciones) {
			ofertables[i] = atraccion;
			i++;
		}
		for (Promocion promocion : promociones) {
			ofertables[i] = promocion;
			i++;
		}
	}
	
	public void ordenarSegunPrioridadA(Usuario usuario) {
		Arrays.sort(this.ofertables, new OrdenOfertable(usuario.getPreferencia()));
	}

	public Atraccion obtenerAtraccionPorNombre(String nombre) {
		for (Atraccion atraccion : atracciones) {
			if (atraccion.getNombre().equals(nombre)) {
				return atraccion;
			}
		}
		return null;
	}
	
	public Ofertable[] getOfertables() {
		return this.ofertables;
	}

	public Usuario[] getUsuarios() {
		return usuarios;
	}

	public Atraccion[] getAtracciones() {
		return atracciones;
	}

	public Promocion[] getPromociones() {
		return promociones;
	}
}