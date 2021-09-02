package parqueDeAtracciones;

public class PromocionAxB extends Promocion {

	public PromocionAxB(String nombre, Atraccion[] atracciones) {
		super(nombre, atracciones);
	}
	
	@Override
	public int calcularPrecio() {
		return super.calcularPrecio() - atracciones[atracciones.length - 1].getCosto();
	}
}
