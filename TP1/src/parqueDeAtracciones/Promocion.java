package parqueDeAtracciones;

import java.util.Arrays;

public abstract class Promocion {
	protected String nombre;
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

	@Override
	public String toString() {
		return "Promocion [nombre=" + nombre + ", atracciones=" + Arrays.toString(atracciones) + ", precio="
				+ this.calcularPrecio() + "]";
	}
}