package auto;

public class Auto {
	private String marca;
	private int costo;
	private int km;

	public Auto(String marca, int costo, int km) {
		this.marca = marca;
		this.costo = costo;
		this.km = km;

	}

	@Override
	public String toString() {
		return "marca: " + marca + ", costo: " + costo + ", km: " + km + "\n";

	}

	public String getMarca() {
		return marca;
	}

	public int getCosto() {
		return costo;
	}
}
