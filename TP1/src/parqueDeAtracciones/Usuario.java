package parqueDeAtracciones;

import java.util.Objects;

public class Usuario {
	private String nombre;
	private TipoDeAtraccion preferencia;
	private int presupuestoDisponible;
	private double tiempoDisponible;

	public Usuario(String nombre, TipoDeAtraccion preferencia, int presupuestoInicial, double tiempoInicial) {
		this.nombre = nombre;
		this.preferencia = preferencia;
		this.presupuestoDisponible = presupuestoInicial;
		this.tiempoDisponible = tiempoInicial;
	}

	public String getNombre() {
		return nombre;
	}

	public TipoDeAtraccion getPreferencia() {
		return preferencia;
	}

	public int getPresupuesto() {
		return presupuestoDisponible;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}
	
	public void aceptarOferta(Ofertable ofertable) {
		this.presupuestoDisponible -= ofertable.getCosto();
		this.tiempoDisponible -= ofertable.getDuracion();
		ofertable.restarCupo();
	}

	@Override
	public String toString() {
		return "Presupuesto disponible= " + presupuestoDisponible
				+ ", tiempoDisponible= " + tiempoDisponible;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, preferencia, presupuestoDisponible, tiempoDisponible);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(nombre, other.nombre) && preferencia == other.preferencia
				&& presupuestoDisponible == other.presupuestoDisponible
				&& Double.doubleToLongBits(tiempoDisponible) == Double.doubleToLongBits(other.tiempoDisponible);
	}
}