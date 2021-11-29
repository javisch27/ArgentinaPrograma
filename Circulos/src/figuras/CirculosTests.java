package figuras;

import static org.junit.Assert.*;

import org.junit.Test;

public class CirculosTests {

	@Test
	public void queIntersectan() {
		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(1, 1), 1.5);
		assertTrue (c1.intersectaCon(c2));
	}
	
	@Test
	public void queNoIntersectan() {
		Circulo c1 = new Circulo(new Punto(0, 0), 1);
		Circulo c2 = new Circulo(new Punto(2, 2), 0.5);
		assertFalse (c1.intersectaCon(c2));
	}
	

}
