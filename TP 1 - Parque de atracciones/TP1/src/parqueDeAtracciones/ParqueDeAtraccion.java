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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(atracciones);
		result = prime * result + Arrays.hashCode(promociones);
		result = prime * result + Arrays.hashCode(usuarios);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParqueDeAtraccion other = (ParqueDeAtraccion) obj;
		return Arrays.equals(atracciones, other.atracciones) && Arrays.equals(promociones, other.promociones)
				&& Arrays.equals(usuarios, other.usuarios);
	}
}