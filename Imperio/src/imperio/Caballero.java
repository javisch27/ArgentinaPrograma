package imperio;

public class Caballero extends Unidad {
	private static final int RETROCEDIMIENTO_CABALLO_ESPANTADO = 3;
	private static final int MAXIMO_CONTADOR_ATAQUES = 3;
	private int contadorAtaques = 0;

	public Caballero(Posicion posicion) {
		super(posicion);
		this.minDistanciaAtaque = 1;
		this.maxDistanciaAtaque = 3;
		this.danio = 30;
	}

	private void espantarCaballo() {
		this.posicion = new Posicion(this.posicion.getX() - RETROCEDIMIENTO_CABALLO_ESPANTADO,
				this.posicion.getY() - RETROCEDIMIENTO_CABALLO_ESPANTADO);
	}

	@Override
	public void atacar(Unidad otraUnidad) {
		super.atacar(otraUnidad);
		this.contadorAtaques++;
		if (contadorAtaques == MAXIMO_CONTADOR_ATAQUES) {
			this.espantarCaballo();
			this.contadorAtaques = 0;
		}
	}

	public int getContadorAtaques() {
		return this.contadorAtaques;
	}
}
