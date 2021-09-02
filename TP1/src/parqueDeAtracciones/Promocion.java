package parqueDeAtracciones;

public abstract class Promocion {
	private String nombre;
	protected Atraccion[] atracciones;

	public Promocion(String nombre, Atraccion[] atracciones) {
		this.nombre = nombre;
		this.atracciones = atracciones;
	}

	public int calcularPrecio() {
		int precioTotal = 0;
		for (Atraccion atraccion : this.atracciones) {
			precioTotal += atraccion.getCosto();
		}
		return precioTotal;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}