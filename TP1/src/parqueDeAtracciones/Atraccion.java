package parqueDeAtracciones;

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
}