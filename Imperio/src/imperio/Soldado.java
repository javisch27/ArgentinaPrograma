package imperio;

public class Soldado extends Unidad {
	private static final int PERDIDA_DE_ENERGIA_POR_ATAQUE = 10;
	private static final int MAXIMO_ENERGIA = 50;
	private int energia = MAXIMO_ENERGIA;

	public Soldado(Posicion posicion) {
		super(posicion);
		this.maxDistanciaAtaque = 1.5;
		this.danio = 20;
	}

	@Override
	public void atacar(Unidad otraUnidad) {
		if (energia >= PERDIDA_DE_ENERGIA_POR_ATAQUE) {
			super.atacar(otraUnidad);
			this.energia -= PERDIDA_DE_ENERGIA_POR_ATAQUE;
		}
	}

	public void descansar() {
		this.energia = MAXIMO_ENERGIA;
	}

	public int getEnergia() {
		return this.energia;
	}
}
