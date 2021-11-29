package auto;

import java.util.Arrays;

public class Concesionaria {
	private Auto[] autos;
	private Promo[] promos;

	public Concesionaria() {

	}

	public void agregarTodosAutos(Auto[] autos) {
		this.autos = autos;
	}

	public void agregarTodasPromociones(Promo[] promos) {
		this.promos = promos;
	}

	public Auto obtenerAutoPorMarca(String marca) {
		for (Auto auto : autos) {
			if (auto.getMarca().equals(marca)) {
				return auto;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Concesionaria [autos=\n" + Arrays.toString(autos) + ", promos=\n" + Arrays.toString(promos) + "]";
	}
}
