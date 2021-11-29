package parqueDeAtraccciones;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import parqueDeAtracciones.Atraccion;
import parqueDeAtracciones.LectorDeArchivos;
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
	Atraccion moria, minasTirith, laComarca, mordor, abismoDeHelm, lothlorien, erebor, bosqueNegro;
	Promocion packAventura, packDegustacion, packPaisajes;
	Usuario eowyn, gandalf, sam, galadriel;

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
		tierraMedia.juntarOfertables();
		assertArrayEquals((new Ofertable[] { moria, minasTirith, laComarca, mordor, abismoDeHelm, lothlorien, erebor,
				bosqueNegro, packAventura, packDegustacion, packPaisajes }), tierraMedia.getOfertables());
	}

	@Test
	public void queOrdenaSegunPrioridadTest() {
		tierraMedia.juntarOfertables();
		tierraMedia.ordenarSegunPrioridadA(eowyn);
		assertArrayEquals((new Ofertable[] { packAventura, mordor, moria, bosqueNegro, packDegustacion, packPaisajes,
				lothlorien, erebor, minasTirith, abismoDeHelm, laComarca }), tierraMedia.getOfertables());
		tierraMedia.ordenarSegunPrioridadA(gandalf);
		assertArrayEquals((new Ofertable[] { packPaisajes, erebor, minasTirith, abismoDeHelm, packDegustacion,
				packAventura, lothlorien, mordor, moria, laComarca, bosqueNegro }), tierraMedia.getOfertables());
		tierraMedia.ordenarSegunPrioridadA(sam);
		assertArrayEquals((new Ofertable[] { packDegustacion, lothlorien, laComarca, packAventura, packPaisajes, mordor,
				erebor, moria, minasTirith, abismoDeHelm, bosqueNegro }), tierraMedia.getOfertables());
		tierraMedia.ordenarSegunPrioridadA(galadriel);
		assertArrayEquals((new Ofertable[] { packPaisajes, erebor, minasTirith, abismoDeHelm, packDegustacion,
				packAventura, lothlorien, mordor, moria, laComarca, bosqueNegro }), tierraMedia.getOfertables());
	}

	@Test
	public void queObtieneAtraccionPorNombreTest() {
		assertEquals(bosqueNegro, tierraMedia.obtenerAtraccionPorNombre("bosqueNegro"));
	}

	@Test
	public void queAtraccionNoEsPromocionTest() {
		assertEquals(false, mordor.esPromocion());
	}

	@Test
	public void queAtraccionPuedenSerOfertadaTest() {
		assertEquals(true, mordor.puedeSerOfertada(galadriel));
	}

	@Test
	public void queAtraccionNoPuedenSerOfertadaTest() {
		assertEquals(false, lothlorien.puedeSerOfertada(eowyn));
	}

	@Test
	public void queAtraccionRestaCupoTest() {
		moria.restarCupo();
		assertEquals(5, moria.getCupo());
	}

	@Test
	public void quePromocionPorcentualCalculaCostoTest() {
		assertEquals(22, packAventura.getCosto());
	}

	@Test
	public void quePromocionAbsolutaCalculaCostoTest() {
		assertEquals(36, packDegustacion.getCosto());
	}

	@Test
	public void quePromocionAxBCalculaCostoTest() {
		assertEquals(10, packPaisajes.getCosto());
	}

	@Test
	public void quePromocionPorcentualCalculaDuracionTest() {
		assertEquals(7, packAventura.getDuracion(), 0);
	}

	@Test
	public void quePromocionAbsolutaCalculaDuracionTest() {
		assertEquals(7.5, packDegustacion.getDuracion(), 0);
	}

	@Test
	public void quePromocionAxBCalculaDuracionTest() {
		assertEquals(7.5, packPaisajes.getDuracion(), 0);
	}

	@Test
	public void quePromocionEsPromocionTest() {
		assertEquals(true, packPaisajes.esPromocion());
	}

	@Test
	public void quehayCupoDisponibleEnTodasAtraccionesTest() {
		assertEquals(true, packPaisajes.cupoDisponibleEnTodasAtracciones());
	}

	@Test
	public void quePromocionPuedenSerOfertadaTest() {
		assertEquals(true, packDegustacion.puedeSerOfertada(sam));
	}

	@Test
	public void quePromocionNoPuedenSerOfertadaTest() {
		assertEquals(false, packDegustacion.puedeSerOfertada(eowyn));
	}

	@Test
	public void quePromocionRestaCupoTest() {
		packAventura.restarCupo();
		assertEquals(11, bosqueNegro.getCupo());
		assertEquals(3, mordor.getCupo());
	}

	@Test
	public void queUsuarioRestaPresupuestoAlAceptarOfertaTest() {
		eowyn.aceptarOferta(abismoDeHelm);
		assertEquals(5, eowyn.getPresupuesto());
	}

	@Test
	public void queUsuarioRestaTiempoAlAceptarOfertaTest() {
		eowyn.aceptarOferta(abismoDeHelm);
		assertEquals(6, eowyn.getTiempoDisponible(), 0);
	}

	@Test
	public void queOfertableRestaCupoAlAceptarOfertaTest() {
		eowyn.aceptarOferta(abismoDeHelm);
		assertEquals(14, abismoDeHelm.getCupo());
	}
	
	@Test
	public void queLeeDelArchivoTest() {
		ParqueDeAtraccion tierraMedia2 = new ParqueDeAtraccion();
		tierraMedia2.agregarTodasAtracciones(LectorDeArchivos.obtenerAtraccionesDesdeArchivo());
		tierraMedia2.agregarTodosUsuarios(LectorDeArchivos.obtenerUsuariosDesdeArchivo());
		tierraMedia2.agregarTodasPromociones(LectorDeArchivos.obtenerPromosDesdeArchivo(tierraMedia2));
		assertArrayEquals(tierraMedia.getAtracciones(), tierraMedia2.getAtracciones());
		assertArrayEquals(tierraMedia.getPromociones(), tierraMedia2.getPromociones());
		assertArrayEquals(tierraMedia.getUsuarios(), tierraMedia2.getUsuarios());
		assertEquals(tierraMedia, tierraMedia2);
	}
}