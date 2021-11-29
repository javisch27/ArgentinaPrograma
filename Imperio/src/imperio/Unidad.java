package imperio;

public abstract class Unidad {
	private static final int DINERO_INICIAL = 50;
	private static final int VALOR_POCION = 25;
	private static final int SALUD_MAXIMA = 100;
	protected double minDistanciaAtaque;
	protected double maxDistanciaAtaque;
	protected int danio;
	protected Posicion posicion;
	private int salud = SALUD_MAXIMA;
	private int dinero = DINERO_INICIAL;
	private boolean muerto = false;

	public int getSalud() {
		return this.salud;
	}

	public Unidad(Posicion posicion) {
		this.posicion = posicion;
	}

	private double distanciaCon(Unidad unidad2) {
		return this.posicion.distanciaCon(unidad2.posicion);
	}

	private void recibirDanio(Unidad otraUnidad) {
		this.salud -= otraUnidad.danio;
		if (this.salud <= 0) {
			this.morirPor(otraUnidad);
		}
	}

	public void atacar(Unidad otraUnidad) {
		if (!this.muerto && (this.distanciaCon(otraUnidad) < this.maxDistanciaAtaque
				&& this.distanciaCon(otraUnidad) > minDistanciaAtaque)) {
			otraUnidad.recibirDanio(this);
		}
	}

	private void morirPor(Unidad otraUnidad) {
		otraUnidad.dinero += this.dinero;
		this.muerto = true;
	}

	public void comprarPocion() {
		this.dinero -= VALOR_POCION;
		this.salud = SALUD_MAXIMA;
	}

	public int getDinero() {
		return this.dinero;
	}
}
