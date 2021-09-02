package parqueDeAtracciones;

public class PromocionAbsoluta extends Promocion {
	private int precio;

	public PromocionAbsoluta(String nombre, Atraccion[] atracciones, int precio) {
		super(nombre, atracciones);
		this.precio = precio;
	}

	@Override
	public int calcularPrecio() {
		return this.precio;
	}
}
