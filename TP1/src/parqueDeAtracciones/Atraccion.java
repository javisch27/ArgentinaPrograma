package parqueDeAtracciones;

public class Atraccion {
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

	public double getDuracion() {
		return duracion;
	}

	public int getCupo() {
		return cupo;
	}

	public TipoDeAtraccion getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return "Atraccion [nombre=" + nombre + ", costo=" + costo + ", duracion=" + duracion + ", cupo=" + cupo
				+ ", tipo=" + tipo + "]";
	}
}