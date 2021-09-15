package parqueDeAtracciones;

public class PromocionPorcentual extends Promocion {
	private int porcentajeDescuento;

	public PromocionPorcentual(String nombre, Atraccion[] atracciones, int porcentajeDescuento) {
		super(nombre, atracciones);
		this.porcentajeDescuento = porcentajeDescuento;
	}

	@Override
	public int getCosto() {
		return Math.round(super.getCosto() * ( 100 - this.porcentajeDescuento) / 100);
	}
}