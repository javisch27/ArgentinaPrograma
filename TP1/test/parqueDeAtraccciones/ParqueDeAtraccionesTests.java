package parqueDeAtraccciones;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import parqueDeAtracciones.Atraccion;
import parqueDeAtracciones.ParqueDeAtraccion;
import parqueDeAtracciones.Promocion;
import parqueDeAtracciones.PromocionAbsoluta;
import parqueDeAtracciones.PromocionAxB;
import parqueDeAtracciones.PromocionPorcentual;
import parqueDeAtracciones.TipoDeAtraccion;
import parqueDeAtracciones.Usuario;
import parqueDeAtracciones.Ofertable;

public class ParqueDeAtraccionesTests {

	ParqueDeAtraccion tierraMedia;
	Atraccion moria;
	Atraccion minasTirith;
	Atraccion laComarca;
	Atraccion mordor;
	Atraccion abismoDeHelm;
	Atraccion lothlorien;
	Atraccion erebor;
	Atraccion bosqueNegro;
	Promocion packAventura;
	Promocion packDegustacion;
	Promocion packPaisajes;
	Usuario eowyn;
	Usuario gandalf;
	Usuario sam;
	Usuario galadriel;

	@Before
	public void setup() {
		tierraMedia = new ParqueDeAtraccion();

		moria = new Atraccion("moria", 10, 2, 6, TipoDeAtraccion.AVENTURA);
		minasTirith = new Atraccion("minasTirith", 5, 2.5, 25, TipoDeAtraccion.PAISAJE);
		laComarca = new Atraccion("laComarca", 3, 6.5, 150, TipoDeAtraccion.DEGUSTACION);
		mordor = new Atraccion("mordor", 25, 3, 4, TipoDeAtraccion.AVENTURA);
		abismoDeHelm = new Atraccion("abismoDeHelm", 5, 2, 15, TipoDeAtraccion.PAISAJE);
		lothlorien = new Atraccion("lothlorien", 35, 1, 30, TipoDeAtraccion.DEGUSTACION);
		erebor = new Atraccion("erebor", 12, 3, 32, TipoDeAtraccion.PAISAJE);
		bosqueNegro = new Atraccion("bosqueNegro", 3, 4, 12, TipoDeAtraccion.AVENTURA);

		packAventura = new PromocionPorcentual("Pack Aventura", (new Atraccion[] { bosqueNegro, mordor }), 20);
		packDegustacion = new PromocionAbsoluta("Pack Degustación", (new Atraccion[] { lothlorien, laComarca }), 36);
		packPaisajes = new PromocionAxB("Pack Paisajes", (new Atraccion[] { minasTirith, abismoDeHelm }), erebor);

		eowyn = new Usuario("Eowyn", TipoDeAtraccion.AVENTURA, 10, 8);
		gandalf = new Usuario("Gandalf", TipoDeAtraccion.PAISAJE, 100, 5);
		sam = new Usuario("Sam", TipoDeAtraccion.DEGUSTACION, 36, 8);
		galadriel = new Usuario("Galadriel", TipoDeAtraccion.PAISAJE, 120, 6);

		tierraMedia.agregarTodosUsuarios(new Usuario[] { eowyn, gandalf, sam, galadriel });
		tierraMedia.agregarTodasAtracciones(new Atraccion[] { moria, minasTirith, laComarca, mordor, abismoDeHelm,
				lothlorien, erebor, bosqueNegro });
		tierraMedia.agregarTodasPromociones(new Promocion[] { packAventura, packDegustacion, packPaisajes });
		tierraMedia.juntarOfertables();
	}

	@Test
	public void queAgregoTodosUsuariosTest() {
		assertArrayEquals((new Usuario[] { eowyn, gandalf, sam, galadriel }), tierraMedia.getUsuarios());
	}

	@Test
	public void queAgregoTodasAtraccionesTest() {
		assertArrayEquals((new Atraccion[] { moria, minasTirith, laComarca, mordor, abismoDeHelm, lothlorien, erebor,
				bosqueNegro }), tierraMedia.getAtracciones());
	}

	@Test
	public void queAgregoTodasPromocionesTest() {
		assertArrayEquals((new Promocion[] { packAventura, packDegustacion, packPaisajes }),
				tierraMedia.getPromociones());
	}

	@Test
	public void juntarOfertablesTest() {
		assertArrayEquals((new Ofertable[] { moria, minasTirith, laComarca, mordor, abismoDeHelm, lothlorien, erebor,
				bosqueNegro, packAventura, packDegustacion, packPaisajes }), tierraMedia.getOfertables());
	}

	@Test
	public void queOrdenaSegunPrioridadTest() {
		tierraMedia.ordenarSegunPrioridadA(eowyn);
		assertArrayEquals((new Ofertable[] { packAventura, mordor, moria, bosqueNegro, packDegustacion, packPaisajes,
				lothlorien, erebor, minasTirith, abismoDeHelm, laComarca}), tierraMedia.getOfertables());
	}
	
	@Test
	public void queObtieneAtraccionPorNombreTest() {
		assertEquals(bosqueNegro, tierraMedia.obtenerAtraccionPorNombre("bosqueNegro"));
	}
	
	@Test
	public void queAtraccionNoEsPromocionTest() {
		assertEquals(mordor.esPromocion(), false);
	}
	
	@Test
	public void queAtraccionPuedenSerOfertadaTest() {
		assertEquals(mordor.puedeSerOfertada(galadriel), true);
	}
	
	@Test
	public void queAtraccionNoPuedenSerOfertadaTest() {
		assertEquals(lothlorien.puedeSerOfertada(eowyn), false);
	}
	
	@Test
	public void queAtraccionRestaCupoTest() {
		moria.restarCupo();
		assertEquals(moria.getCupo(), 5);
	}
	
	@Test
	public void quePromocionPorcentualCalculaCostoTest() {
		assertEquals(packAventura.getCosto(), 22);
	}
	
	@Test
	public void quePromocionAbsolutaCalculaCostoTest() {
		assertEquals(packDegustacion.getCosto(), 36);
	}
	
	@Test
	public void quePromocionAxBCalculaCostoTest() {
		assertEquals(packPaisajes.getCosto(), 10);
	}
	
	@Test
	public void quePromocionPorcentualCalculaDuracionTest() {
		assertEquals(packAventura.getDuracion(), 7, 0);
	}
	
	@Test
	public void quePromocionAbsolutaCalculaDuracionTest() {
		assertEquals(packDegustacion.getDuracion(), 7.5, 0);
	}
	
	@Test
	public void quePromocionAxBCalculaDuracionTest() {
		assertEquals(packPaisajes.getDuracion(), 7.5, 0);
	}
	
	@Test
	public void quePromocionEsPromocionTest() {
		assertEquals(packPaisajes.esPromocion(), true);
	}
	
	@Test
	public void quehayCupoDisponibleEnTodasAtraccionesTest() {
		assertEquals(packPaisajes.cupoDisponibleEnTodasAtracciones(), true);
	}
	
	@Test
	public void quePromocionPuedenSerOfertadaTest() {
		assertEquals(packDegustacion.puedeSerOfertada(sam), true);
	}
	
	@Test
	public void quePromocionNoPuedenSerOfertadaTest() {
		assertEquals(packDegustacion.puedeSerOfertada(eowyn), false);
	}
	
	@Test
	public void quePromocionRestaCupoTest() {
		packAventura.restarCupo();
		assertEquals(bosqueNegro.getCupo(), 11);
		assertEquals(mordor.getCupo(), 3);
	}
	
	@Test
	public void queUsuarioRestaPresupuestoAlAceptarOfertaTest() {
		eowyn.aceptarOferta(abismoDeHelm);
		assertEquals(eowyn.getPresupuesto(), 5);
	}
	
	@Test
	public void queUsuarioRestaTiempoAlAceptarOfertaTest() {
		eowyn.aceptarOferta(abismoDeHelm);
		assertEquals(eowyn.getTiempoDisponible(), 6, 0);
	}
	
	@Test
	public void queOfertableRestaCupoAlAceptarOfertaTest() {
		eowyn.aceptarOferta(abismoDeHelm);
		assertEquals(abismoDeHelm.getCupo(), 14);
	}
}