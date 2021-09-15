package parqueDeAtracciones;

import java.util.Objects;

public class Atraccion implements Ofertable {
	private String nombre;
	private int costo;
	private double duracion;
	private int cupo;
	private TipoDeAtraccion tipo;

	public Atraccion(String nombre, int costo, double duracion, int cupo, TipoDeAtraccion tipo) {
		this.nombre = nombre;
		this.costo = costo;
		this.duracion = duracion;
		this.cupo = cupo;
		this.tipo = tipo;
	}

	@Override
	public int getCosto() {
		return this.costo;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public double getDuracion() {
		return duracion;
	}

	public int getCupo() {
		return cupo;
	}

	@Override
	public TipoDeAtraccion getTipoDeAtraccion() {
		return this.tipo;
	}

	@Override
	public boolean esPromocion() {
		return false;
	}

	@Override
	public boolean puedeSerOfertada(Usuario usuario) {
		return this.cupo > 0 && usuario.getTiempoDisponible() >= this.duracion
				&& usuario.getPresupuesto() >= this.costo;
	}

	@Override
	public void restarCupo() {
		this.cupo--;
	}
	
	@Override
	public String toString() {
		return "Atracción= " + nombre + "\n" + "Costo= " + costo + "\n" + "Duración= " + duracion + "\n" + "Tipo= "
				+ tipo + "\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(costo, cupo, duracion, nombre, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return costo == other.costo && cupo == other.cupo
				&& Double.doubleToLongBits(duracion) == Double.doubleToLongBits(other.duracion)
				&& Objects.equals(nombre, other.nombre) && tipo == other.tipo;
	}
}