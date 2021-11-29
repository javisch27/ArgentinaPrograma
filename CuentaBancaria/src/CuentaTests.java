import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CuentaTests {

	//Arrange
	CuentaBancaria cuentaOrigen;
		
	@Before
	public void setup() {
		cuentaOrigen = new CuentaBancaria();
	}
	
	@Test
	public void creacion() {
		assertNotNull(cuentaOrigen);
	}
	
	@Test
	public void quePuedoDepositar() {
		//Act
		cuentaOrigen.depositar(800);
		//Assert
		assertEquals (800,0 , cuentaOrigen.consultarSaldo());
	}
	
	@Test
	public void quePuedoExtraer() {
		//Act
		cuentaOrigen.depositar(800);
		cuentaOrigen.extraer(500);
		//Assert
		assertEquals (300,0 , cuentaOrigen.consultarSaldo());
	}
	
	@Test 
	public void queNoExtraigoMasDeLoQueTengo() {
		//Act
		cuentaOrigen.depositar(200);
		cuentaOrigen.extraer(500);
		assertEquals (200,0, cuentaOrigen.consultarSaldo());
	}
	
	@Test
	public void queNoExtraigoNegativo() {
		cuentaOrigen.extraer(-500);
		assertEquals (0,0, cuentaOrigen.consultarSaldo());
	}
	
	@Test
	public void queNoDepositoNegativo() {
		cuentaOrigen.depositar(-500);
		assertEquals (0,0, cuentaOrigen.consultarSaldo());
	}
	
	@Test
	public void queNoTransfieroMasDeLoQueTengo() {
		//Act
		CuentaBancaria cuentaDestino = new CuentaBancaria();
		cuentaOrigen.transferirA(cuentaDestino, 50);
		assertEquals (0,0, cuentaOrigen.consultarSaldo());
	}
	
	@Test
	public void queNoTransfieroNegativo() {
		//Act
		CuentaBancaria cuentaDestino = new CuentaBancaria();
		cuentaOrigen.transferirA(cuentaDestino, -50);
		assertEquals (0,0, cuentaOrigen.consultarSaldo());
		assertEquals (0,0, cuentaDestino.consultarSaldo());
	}
	
	@Test
	public void quePuedoExtraerYDepositarEnCuentaDeAhorros() {
		CuentaDeAhorros cuentaAhorros1 = new CuentaDeAhorros();
		cuentaAhorros1.depositar(1000);
		cuentaAhorros1.extraer(800);
		assertEquals (200,0 , cuentaAhorros1.consultarSaldo());
	}
	
	@Test
	public void quePuedoTransferirEnCuentaDeAhorros() {
		CuentaDeAhorros cuentaAhorros1 = new CuentaDeAhorros();
		CuentaDeAhorros cuentaAhorros2 = new CuentaDeAhorros();
		cuentaAhorros1.depositar(1000);
		cuentaAhorros1.transferirA(cuentaAhorros2, 800);
		assertEquals (200,0 , cuentaAhorros1.consultarSaldo());
		assertEquals (800,0 , cuentaAhorros2.consultarSaldo());
	}
	
	@Test
	public void pasarASaldoSecundarioYReintegrar() {
		CuentaDeAhorros cuentaAhorros1 = new CuentaDeAhorros();
		cuentaAhorros1.depositar(1000);
		cuentaAhorros1.pasarASaldoSecundario(400);
		assertEquals (600,0 , cuentaAhorros1.consultarSaldo());
		assertEquals (400,0 , cuentaAhorros1.consultarSaldoSecundario());
		cuentaAhorros1.reintegrarSaldoSecundario(300);
		assertEquals (900,0 , cuentaAhorros1.consultarSaldo());
		assertEquals (100,0 , cuentaAhorros1.consultarSaldoSecundario());
	}
	
	@Test
	public void queNoPasoASaldoSecundarioNegativo() {
		CuentaDeAhorros cuentaAhorros1 = new CuentaDeAhorros();
		cuentaAhorros1.depositar(500);
		cuentaAhorros1.pasarASaldoSecundario(-500);
		assertEquals (0,0, cuentaAhorros1.consultarSaldo());
	}
	
	@Test
	public void queNoPasoASaldoSecundarioMasDeLoQueTengo() {
		CuentaDeAhorros cuentaAhorros1 = new CuentaDeAhorros();
		cuentaAhorros1.pasarASaldoSecundario(100);
		assertEquals (0,0, cuentaAhorros1.consultarSaldo());
		assertEquals (0,0, cuentaAhorros1.consultarSaldoSecundario());
	}
	
	@Test
	public void queNoReintegroNegativo() {
		CuentaDeAhorros cuentaAhorros1 = new CuentaDeAhorros();
		cuentaAhorros1.depositar(700);
		cuentaAhorros1.pasarASaldoSecundario(600);
		cuentaAhorros1.reintegrarSaldoSecundario(-500);
		assertEquals (100,0, cuentaAhorros1.consultarSaldo());
	}
	
	@Test
	public void queNoReintegroMasDeLoQueTengoEnSaldoSecundario() {
		CuentaDeAhorros cuentaAhorros1 = new CuentaDeAhorros();
		cuentaAhorros1.depositar(700);
		cuentaAhorros1.pasarASaldoSecundario(600);
		assertEquals (600,0, cuentaAhorros1.consultarSaldoSecundario());
		cuentaAhorros1.reintegrarSaldoSecundario(800);
		assertEquals (100,0, cuentaAhorros1.consultarSaldo());
		assertEquals (600,0, cuentaAhorros1.consultarSaldoSecundario());
	}
}
