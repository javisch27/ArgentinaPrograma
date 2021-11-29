package imperio;

public class Arquero extends Unidad {
	private static final int MAXIMA_CANTIDAD_FLECHAS = 5;
	private int cantidadFlechas = MAXIMA_CANTIDAD_FLECHAS;

	public Arquero(Posicion posicion) {
		super(posicion);
		this.minDistanciaAtaque = 5;
		this.maxDistanciaAtaque = 25;
		this.danio = 7;
	}

	@Override
	public void atacar(Unidad otraUnidad) {
		if (cantidadFlechas > 0) {
			super.atacar(otraUnidad);
			this.cantidadFlechas--;
		}
	}

	public void recargarFlechas() {
		this.cantidadFlechas = MAXIMA_CANTIDAD_FLECHAS;
	}

	public int getCantidadFlechas() {
		return this.cantidadFlechas;
	}
}
