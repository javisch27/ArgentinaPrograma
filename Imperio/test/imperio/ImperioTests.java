package imperio;
import static org.junit.Assert.*;
import org.junit.Test;

public class ImperioTests {

	@Test
	public void ataqueDifUnidadesTest() {
		Caballero u1 = new Caballero(new Posicion(0, 0));
		Soldado u2 = new Soldado(new Posicion(1, 1));
		Arquero u3 = new Arquero(new Posicion(4, 4));

		assertEquals(100, u2.getSalud());
		u1.atacar(u2);
		assertEquals(70, u2.getSalud());

		assertEquals(100, u3.getSalud());
		u1.atacar(u3);
		assertEquals(100, u3.getSalud());
		
		assertEquals(100, u1.getSalud());
		u2.atacar(u1);
		assertEquals(80, u1.getSalud());
		
		assertEquals(100, u3.getSalud());
		u2.atacar(u3);
		assertEquals(100, u3.getSalud());
		
		assertEquals(80, u1.getSalud());
		u3.atacar(u1);
		assertEquals(73, u1.getSalud());
		
		assertEquals(70, u2.getSalud());
		u3.atacar(u2);
		assertEquals(70, u2.getSalud());
	}
	
	@Test
	public void cantidadFlechasTest() {
		Caballero u1 = new Caballero(new Posicion(0, 0));
		Arquero u3 = new Arquero(new Posicion(4, 4));
		u3.atacar(u1);
		assertEquals(4, u3.getCantidadFlechas());
	}
	
	public void sinFlechasTest() {
		Caballero u1 = new Caballero(new Posicion(0, 0));
		Arquero u3 = new Arquero(new Posicion(4, 4));
		u3.atacar(u1);
		u3.atacar(u1);
		u3.atacar(u1);
		u3.atacar(u1);
		u3.atacar(u1);
		u3.atacar(u1);
		assertEquals(0, u3.getCantidadFlechas());
		assertEquals(65, u1.getSalud());
	}
	
	public void recargarFlechasTest() {
		Caballero u1 = new Caballero(new Posicion(0, 0));
		Arquero u3 = new Arquero(new Posicion(4, 4));
		u3.atacar(u1);
		u3.atacar(u1);
		u3.atacar(u1);
		u3.recargarFlechas();
		assertEquals(5, u3.getCantidadFlechas());
	}
	
	@Test
	public void energiaTest() {
		Caballero u1 = new Caballero(new Posicion(0, 0));
		Soldado u2 = new Soldado(new Posicion(1, 1));
		u2.atacar(u1);
		assertEquals(40, u2.getEnergia());
	}
	
	@Test
	public void sinEnergiaTest() {
		Caballero u1 = new Caballero(new Posicion(0, 0));
		Soldado u2 = new Soldado(new Posicion(1, 1));
		u2.atacar(u1);
		u2.atacar(u1);
		u2.atacar(u1);
		u2.atacar(u1);
		u2.atacar(u1);
		u2.atacar(u1);
		assertEquals(0, u2.getEnergia());
		assertEquals(0, u1.getSalud());
	}
	
	@Test
	public void descansarTest() {
		Caballero u1 = new Caballero(new Posicion(0, 0));
		Soldado u2 = new Soldado(new Posicion(1, 1));
		u2.atacar(u1);
		u2.atacar(u1);
		u2.atacar(u1);
		u2.descansar();
		assertEquals(50, u2.getEnergia());
	}
	
	@Test
	public void caballoEspantadoTest() {
		Caballero u1 = new Caballero(new Posicion(0, 0));
		Soldado u2 = new Soldado(new Posicion(1, 1));
		u1.atacar(u2);
		u1.atacar(u2);
		u1.atacar(u2);
		assertEquals(0, u1.getContadorAtaques());
		assertEquals(new Posicion (-3, -3), u1.posicion);
	}
	
	@Test
	public void robarDineroAlMuertoTest() {
		Caballero u1 = new Caballero(new Posicion(0, 0));
		Soldado u2 = new Soldado(new Posicion(1, 1));
		u2.atacar(u1);
		u2.atacar(u1);
		u2.atacar(u1);
		u2.descansar();
		u2.atacar(u1);
		u2.atacar(u1);
		assertEquals(100, u2.getDinero());
	}
	
	@Test
	public void comprarPocionTest() {
		Caballero u1 = new Caballero(new Posicion(0, 0));
		Soldado u2 = new Soldado(new Posicion(1, 1));
		u2.atacar(u1);
		u2.atacar(u1);
		assertEquals(60, u1.getSalud());
		u1.comprarPocion();
		assertEquals(100, u1.getSalud());
	}
}
