package auto;

import java.util.Arrays;

public class Promo {
	String nombre;
	Auto[] autos;
	int precio;

	public Promo(String nombre, int precio, Auto[] autos) {
		this.nombre = nombre;
		this.autos = autos;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Promo [nombre=" + nombre + ", autos=\n" + Arrays.toString(autos) + ", precio=" + precio + "]\n";
	}

	// En teoria si quisiera aplicar algun descuento
	public int getPrecio() {
		int precioTotal = 0;
		for (Auto auto : autos) {
			precioTotal += auto.getCosto();
		}

		return (int) Math.floor(precioTotal * (1 - /* descuento */ 0.2));
	}
}
