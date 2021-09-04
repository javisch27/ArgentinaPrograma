package parqueDeAtracciones;

import java.util.Arrays;

public abstract class Promocion implements Ofertable {
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
	
	@Override
	public double getDuracion() {
		double duracionTotal = 0;
		for (Atraccion atraccion : this.atracciones) {
			duracionTotal += atraccion.getDuracion();
		}
		return duracionTotal;
	}
	
	@Override
	public boolean esPromocion() {
		return true;
	}
	//Estos últimos dos métodos no están terminados
	@Override
	public boolean puedeSerOfertada(Usuario usuario) {
		return false;
	}
	
	@Override
	public TipoDeAtraccion getTipoDeAtraccion() {
		TipoDeAtraccion[] tiposDeAtracciones;
		tiposDeAtracciones = new TipoDeAtraccion[atracciones.length];
		for (int i=0; i < tiposDeAtracciones.length; i++) {
			tiposDeAtracciones[i] = atracciones[i].getTipoDeAtraccion();
		}
		return tiposDeAtracciones[0];
	}
}