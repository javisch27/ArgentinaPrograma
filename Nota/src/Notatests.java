import static org.junit.Assert.*;

import org.junit.Test;

public class Notatests {

	@Test
	public void inicializacionTest() {
		Nota n1 = new Nota(4);
		assertNotNull(n1);
	}

	@Test
	public void obetenerValorTest() {
		Nota n1 = new Nota(4);
		assertEquals(4, n1.obtenerValor());
	}

	@Test
	public void aprobado4Test() {
		Nota nAp = new Nota(4);
		assertTrue(nAp.aprobado());
	}

	@Test
	public void aprobado10Test() {
		Nota nAp = new Nota(10);
		assertTrue(nAp.aprobado());
	}

	@Test
	public void desaprobado3Test() {
		Nota nIns = new Nota(3);
		assertTrue(nIns.desaprobado());
	}
	
	@Test
	public void desaprobado0Test() {
		Nota nIns = new Nota(0);
		assertTrue(nIns.desaprobado());
	}
	
	@Test
	public void recuperaYSubeNotaTest() {
		Nota nP1 = new Nota(2);
		assertTrue(nP1.desaprobado());
		nP1.recuperar(8);
		assertEquals(8, nP1.obtenerValor());
		assertTrue(nP1.aprobado());
	}
	
	@Test
	public void recuperaYNoSubeNotaTest() {
		Nota nP1 = new Nota(5);
		nP1.recuperar(2);
		assertEquals(5, nP1.obtenerValor());
		assertTrue(nP1.aprobado());
	}
	
	@Test(expected = Error.class)
	public void valorIncorrectoTest() {
		Nota cualquiera = new Nota(11);
	}
	
}
