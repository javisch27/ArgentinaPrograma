import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContadorTests {

	//Arrange
	Contador miContador;
	
	@Before
	public void setup() {
		miContador = new Contador();
	}
	
	@After
	public void tearDown() {
		miContador = null;
	}
	
	@Test
	public void creacion() {
		assertNotNull(miContador);
	}
	
	@Test
	public void quePuedeContar() {
		//Act
		miContador.contar();
		//Assert
		assertEquals (1, miContador.mostrar());
	}
	
	@Test
	public void queReiniciaSinHaberContado() {
		//Act
		miContador.reiniciar();
		//Assert
		assertEquals (0, miContador.mostrar());
	}

	@Test
	public void queReiniciaLuegoDeContar() {
		//Act
		miContador.contar();
		miContador.reiniciar();
		//Assert
		assertEquals (0, miContador.mostrar());
	}
	
	@Test
	public void queCuenta100Veces() {
		//Arrange
		Contador micontador = new Contador();
		//Act
		for(int i = 0; i < 100; i++)
			micontador.contar();
		//Assert
		assertEquals (100, micontador.mostrar());
	}
	
	
}
