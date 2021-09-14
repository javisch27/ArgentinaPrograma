package parqueDeAtracciones;

public class PromocionAxB extends Promocion {
	private Atraccion atraccionGratuita;

	public PromocionAxB(String nombre, Atraccion[] atracciones, Atraccion atraccionGratuita) {
		super(nombre, atracciones);
		this.atraccionGratuita = atraccionGratuita;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n" + "Atracción gratuita= " + this.atraccionGratuita.getNombre();
	}
	
	@Override
	public double getDuracion() {
		return super.getDuracion() + this.atraccionGratuita.getDuracion();
	}
	
	@Override
	public boolean cupoDisponibleEnTodasAtracciones() {
		if(this.atraccionGratuita.getCupo() <= 0) {
			return false;
		}
		return super.cupoDisponibleEnTodasAtracciones();
	}
}