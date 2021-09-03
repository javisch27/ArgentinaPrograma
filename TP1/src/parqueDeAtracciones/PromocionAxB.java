package parqueDeAtracciones;

public class PromocionAxB extends Promocion {
	private Atraccion atraccionGratuita;

	public PromocionAxB(String nombre, Atraccion[] atracciones, Atraccion atraccionGratuita) {
		super(nombre, atracciones);
		this.atraccionGratuita = atraccionGratuita;
	}

	@Override
	public String toString() {
		return super.toString() + "[atraccionGratuita=" + atraccionGratuita + "]";
	}
}
