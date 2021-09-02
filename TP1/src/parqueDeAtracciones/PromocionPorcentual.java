package parqueDeAtracciones;

public class PromocionPorcentual extends Promocion {
	private int porcentajeDescuento;

	public PromocionPorcentual(String nombre, Atraccion[] atracciones, int porcentajeDescuento) {
		super(nombre, atracciones);
		this.porcentajeDescuento = porcentajeDescuento;
	}

	@Override
	public int calcularPrecio() {
		return super.calcularPrecio() * this.porcentajeDescuento / 100;
	}
}