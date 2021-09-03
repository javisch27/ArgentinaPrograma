package parqueDeAtracciones;

public class Usuario {
	private String nombre;
	private TipoDeAtraccion preferencia;
	private int presupuesto;
	private double tiempoDisponible;

	public Usuario(String nombre, TipoDeAtraccion preferencia, int presupuesto, double tiempoDisponible) {
		this.nombre = nombre;
		this.preferencia = preferencia;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
	}

	public String getNombre() {
		return nombre;
	}

	public TipoDeAtraccion getPreferencia() {
		return preferencia;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", preferencia=" + preferencia + ", presupuesto=" + presupuesto
				+ ", tiempoDisponible=" + tiempoDisponible + "]";
	}
	
	
}
