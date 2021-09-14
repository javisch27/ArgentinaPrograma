package parqueDeAtracciones;

public class PromocionAbsoluta extends Promocion {
	private int costo;

	public PromocionAbsoluta(String nombre, Atraccion[] atracciones, int costo) {
		super(nombre, atracciones);
		this.costo = costo;
	}

	@Override
	public int getCosto() {
		return this.costo;
	}
}